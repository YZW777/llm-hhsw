package com.kuaishou.esp.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-19
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);
}
