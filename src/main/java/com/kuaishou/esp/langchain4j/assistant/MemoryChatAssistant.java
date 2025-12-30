package com.kuaishou.esp.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-21
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    // UserMessage的作用是，在每次用户输入的问题之前，都拼接上UserMessage
    @UserMessage("你是一个智能助手，请用愤怒的语气回答用户的问题， {{message}} 是用户的问题")
    String chat(@V("message") String userMessage);
}
