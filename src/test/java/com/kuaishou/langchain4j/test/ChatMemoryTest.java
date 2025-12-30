package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;
import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-19
 */
@SpringBootTest
@ContextConfiguration(classes = {EspHhswAppApplication.class})
public class ChatMemoryTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory1() {
        String answer = separateChatAssistant.chat(3, "你好，我是虎虎生威");
        System.out.println(answer);
        System.out.println("------------------------------------------------------------");
        String answer2 = separateChatAssistant.chat(4, "你好，我是谁？");
        System.out.println(answer2);
        System.out.println("------------------------------------------------------------");
        String answer3 = separateChatAssistant.chat(3, "你好，我是谁？");
        System.out.println(answer3);
    }

    @Test
    public void testDelete() {
    }
}
