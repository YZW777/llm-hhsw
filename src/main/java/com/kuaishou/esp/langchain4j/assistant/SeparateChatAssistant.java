package com.kuaishou.esp.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-21
 */
@AiService(
        // 指定大模型
        wiringMode = AiServiceWiringMode.EXPLICIT,
        // 大模型名称
        chatModel = "qwenChatModel",
        // 聊天记忆的设置
        chatMemoryProvider = "chatMemoryHhswProvider",
        // 大模型可以调用的工具
        tools = "calculatorTools"
)
public interface SeparateChatAssistant {

    // SystemMessage的作用是一次输入，告诉大模型，你需要做什么
    //@SystemMessage("你是一个助手，请根据用户的提问，给出相应的回答，今天是{{current_date}}.")
    @SystemMessage(fromResource = "documentation.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我老婆，请用河南话回答问题 ")
    String chat2 (@MemoryId int memoryId, @V("message") String userMessage);

    @SystemMessage("你是我的好朋友，我是{{username}}，我今年{{age}}岁，请用轻松愉快的河南话回答问题，适当添加幽默")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );
}
