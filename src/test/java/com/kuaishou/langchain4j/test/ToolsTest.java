package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;
import com.kuaishou.esp.langchain4j.assistant.SeparateChatAssistant;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-29
 */
@SpringBootTest(classes = EspHhswAppApplication.class)
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void test() {
        String answer = separateChatAssistant.chat(101, "1+2等于几，134141232131254的平方根是多少，请直接回答");
        System.out.println(answer);
    }
}
