package com.kuaishou.langchain4j.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
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
@SpringBootTest
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
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("documentation.txt");
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
                .build();

        String resp = assistant.chat("介绍下互斥投放逻辑");
        System.out.println(resp);
    }
}
