package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.kuaishou.esp.langchain4j.assistant.Assistant;
import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;
import com.kuaishou.esp.langchain4j.config.BeanConfig;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-19
 */
@SpringBootTest
@ContextConfiguration(classes = {BeanConfig.class, Assistant.class})
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    @Test
    public void testChatMemory() {
        String answer = assistant.chat("你好，我是虎虎生威");
        System.out.println(answer);
        String answer2 = assistant.chat("你好，我是谁？");
        System.out.println(answer2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory1() {
        String answer = separateChatAssistant.chat(1, "你好，我是虎虎生威");
        System.out.println(answer);
        String answer2 = separateChatAssistant.chat(2, "你好，我是谁？");
        System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(1, "你好，我是谁？");
        System.out.println(answer3);
    }
}
