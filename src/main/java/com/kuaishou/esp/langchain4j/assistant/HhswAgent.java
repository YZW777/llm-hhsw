package com.kuaishou.esp.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryHhswProvider"
)
public interface HhswAgent {

    @SystemMessage(fromResource = "hhsw-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

    String chat(@UserMessage String userMessage);
}
