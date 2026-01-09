package com.kuaishou.langchain4j.test;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-23
 */
@SpringBootTest(classes = EspHhswAppApplication.class)
public class RAGTest {

    interface Assistant {
        String chat(String userMessage);
    }

    ChatModel chatModel = OpenAiChatModel.builder()
            .apiKey("demo")
            .modelName("gpt-3.5-turbo")
            .build();


    @Test
    public void testRAG() {
        // 文档加载器FileSystemDocumentLoader
        Document document = FileSystemDocumentLoader.loadDocument(
                "/Users/yanziwei/kuaishou-java/llm-hhsw/src/main/resources/documentation.txt", new TextDocumentParser());
        System.out.println(document.text());
        System.out.println("==================================================================");
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,md}");
        List<Document> documents = FileSystemDocumentLoader.loadDocuments(
                "/Users/yanziwei/kuaishou-java/llm-hhsw/src/main/resources", pathMatcher,
                new TextDocumentParser());
        for (Document doc : documents) {
            System.out.println(doc.text());
        }
        System.out.println("==================================================================");
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor.ingest(document, embeddingStore);
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
                .build();

        String resp = assistant.chat("介绍下互斥投放逻辑");
        System.out.println(resp);
    }


    @Test
    public void testPDF() {
        Document document = FileSystemDocumentLoader.loadDocument("/Users/yanziwei/Desktop/ClickHouse 技术分享.pdf",
                new ApachePdfBoxDocumentParser());
        System.out.println(document.text());
        System.out.println(document.metadata() );
    }
}
