package com.kuaishou.esp.langchain4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuaishou.esp.langchain4j.assistant.EspXiaoWeiAgent;
import com.kuaishou.esp.langchain4j.request.EspXiaoWeiChatRequest;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@RestController
@RequestMapping("/esp/xiaoWei")
public class EspXiaoWeiController {

    @Autowired
    private EspXiaoWeiAgent espXiaoWeiAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody EspXiaoWeiChatRequest espXiaoWeiChatRequest) {
        return espXiaoWeiAgent.chat(espXiaoWeiChatRequest.getMemoryId(), espXiaoWeiChatRequest.getMessage());
    }
}
