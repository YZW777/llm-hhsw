package com.kuaishou.esp.langchain4j.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-28
 */
@Document("chat_messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessages {

    @Id
    private ObjectId messageId;

    private String memoryId;

    private String content;
}
