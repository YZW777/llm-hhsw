package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;
import com.kuaishou.esp.langchain4j.assistant.MemoryChatAssistant;
import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-28
 */
@SpringBootTest(classes = {EspHhswAppApplication.class})
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testSystemMessage() {
        String chat = separateChatAssistant.chat(6, "磁力金牛有手机端吗？");
        System.out.println(chat);
    }

    @Test
    public void testUserMessage() {
        String chat = memoryChatAssistant.chat("你好呀，我觉得你真的很聪明，我喜欢你！");
        System.out.println(chat);
    }

    @Test
    public void testUserInfo() {

        // 从数据库等其他数据源查询到的用户信息
        String username = "yanziwei05";
        int age = 25;

        // 把用户输入，用户信息，系统信息，结合在一起，生成最终的prompt
        String chat = separateChatAssistant.chat3(8, "我是谁，我多大了", username, age);

        System.out.println(chat);
    }
}
