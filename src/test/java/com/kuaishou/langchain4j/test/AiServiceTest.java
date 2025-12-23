package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.kuaishou.esp.langchain4j.assistant.Assistant;
import com.kuaishou.esp.langchain4j.config.BeanConfig;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-19
 */
@SpringBootTest
@ContextConfiguration(classes = {BeanConfig.class, Assistant.class})
public class AiServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String chat = assistant.chat("你是谁，有什么用途？");
        System.out.println(chat);
    }

    @Autowired
    private Assistant assistant;
    @Test
    public void testChat2() {
        String chat = assistant.chat("我帅不帅");
        System.out.println(chat);
    }
}
