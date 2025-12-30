package com.kuaishou.esp.langchain4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuaishou.esp.langchain4j.assistant.HhswAgent;
import com.kuaishou.esp.langchain4j.request.HhswChatRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@RestController
@RequestMapping("/esp/hhsw")
@Tag(name = "HhswController", description = "虎虎生威对话接口")
public class HhswController {

    @Autowired
    private HhswAgent hhswAgent;

    @Operation(summary = "对话")
    @PostMapping("/chat")
    public String chat(@RequestBody HhswChatRequest hhswChatRequest) {
        return hhswAgent.chat(hhswChatRequest.getMemoryId(), hhswChatRequest.getMessage());
    }
}
