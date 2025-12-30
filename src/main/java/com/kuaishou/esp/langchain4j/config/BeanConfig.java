package com.kuaishou.esp.langchain4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;
import com.kuaishou.esp.langchain4j.store.MongoChatMemoryStore;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-15
 */
@Configuration
public class BeanConfig {

/*
    @Value("${langchain4j.open-ai.chat-model.base-url}")
    private String openAiBaseUrl;

    @Value("${langchain4j.open-ai.chat-model.api-key}")
    private String openAiApiKey;
    @Value("${langchain4j.open-ai.chat-model.model-name}")
    private String openAiModelName;

    @Bean
    public OpenAiChatModel openAiChatModel() {
        return OpenAiChatModel.builder()
                .baseUrl(openAiBaseUrl)
                .modelName(openAiModelName)
                .apiKey(openAiApiKey)
                .build();
    }

    @Value("${langchain4j.ollama.chat-model.base-url}")
    private String ollamaBaseUrl;

    @Value("${langchain4j.ollama.chat-model.model-name}")
    private String ollamaModelName;

    @Bean
    public OllamaChatModel ollamaChatModel() {
        return OllamaChatModel.builder()
                .baseUrl(ollamaBaseUrl)
                .modelName(ollamaModelName)
                .build();
    }
*/

    @Value("${langchain4j.community.dashscope.chat-model.api-key}")
    private String qwenApiKey;

    @Value("${langchain4j.community.dashscope.chat-model.model-name}")
    private String qwenModelName;

    @Value("${langchain4j.community.dashscope.chat-model.temperature}")
    private float temperature;


    @Bean
    public QwenChatModel qwenChatModel() {
        return QwenChatModel.builder()
                .modelName(qwenModelName)
                .apiKey(qwenApiKey)
                .temperature(temperature)
                .build();
    }

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    public ChatMemoryProvider chatMemoryHhswProvider() {
        return memoryId ->
                MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(10)
                        .chatMemoryStore(mongoChatMemoryStore)
                        .build();
    }

    @Bean
    public SeparateChatAssistant separateChatAssistant() {
        return AiServices.builder(SeparateChatAssistant.class)
                .chatMemoryProvider(chatMemoryHhswProvider())
                .chatModel(qwenChatModel())
                .build();
    }



}
