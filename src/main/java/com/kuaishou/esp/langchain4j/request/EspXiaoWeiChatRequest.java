package com.kuaishou.esp.langchain4j.request;

import lombok.Data;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@Data
public class EspXiaoWeiChatRequest {

    // 对话id
    private Long memoryId;

    // 用户问题
    private String message;
}
