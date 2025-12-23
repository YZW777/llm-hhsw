package com.kuaishou.esp.langchain4j.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.esp.langchain4j.assistant.Assistant;
import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
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



/*
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(20);
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).build();
    }

    @Bean
    public Assistant assistant() {
        return AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel())
                .chatMemory(chatMemory())
                .build();
    }

    @Bean
    public SeparateChatAssistant separateChatAssistant() {
        return AiServices.builder(SeparateChatAssistant.class)
                .chatLanguageModel(qwenChatModel())
                .chatMemory(chatMemory())
                .chatMemoryProvider(chatMemoryProvider())
                .build();
    }
*/

}
