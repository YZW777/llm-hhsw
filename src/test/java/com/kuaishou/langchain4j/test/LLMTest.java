package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kuaishou.esp.langchain4j.config.BeanConfig;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxHelper;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.community.model.dashscope.WanxImageSize;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-14
 */
@SpringBootTest(classes = BeanConfig.class)
public class LLMTest {


    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testQwen() {
        String chat = qwenChatModel.chat("介绍下你自己");
        System.out.println(chat);
    }

    @Test
    public void testDashScopeWanx() {
        WanxImageModel model = WanxImageModel.builder()
                .apiKey("sk-80fba6ef1f804d4f881bfecfe0da512a")
                .modelName("wanx2.1-t2i-plus")
                .baseUrl("https://dashscope.aliyuncs.com/api/v1")
                .negativePrompt("")
                .size(WanxImageSize.SIZE_1024_1024)
                .build();
        Response<Image> generate = model.generate("请生成一张图片，内容是：猫咪和狗狗打架，猫咪胜利了");

        System.out.println(generate.content().url());
    }

    @Test
    public void testWordToVideo() {
        WanxImageModel model = WanxImageModel.builder()
                .apiKey("sk-80fba6ef1f804d4f881bfecfe0da512a")
                .modelName("wanx2.1-t2v-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/api/v1")
                .negativePrompt("")
                .size(WanxImageSize.SIZE_1024_1024)
                .build();
        Response<Image> generate = model.generate("一只小猫在月光下奔跑");
        System.out.println(generate.content().url());
    }

}
