package com.kuaishou.esp.langchain4j.store;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.kuaishou.esp.langchain4j.bean.ChatMessages;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        Query query = new Query();
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        query.addCriteria(criteria);

        ChatMessages  chatMessages = mongoTemplate.findOne(query, ChatMessages.class);
        if (Objects.isNull(chatMessages)) {
            return new LinkedList<>();
        }
        String content = chatMessages.getContent();
        return ChatMessageDeserializer.messagesFromJson(content);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        Query query = new Query();
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("content", ChatMessageSerializer.messagesToJson(list));

        mongoTemplate.upsert(new Query(criteria), update, ChatMessages.class);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        mongoTemplate.remove(new Query(criteria), "chat_memory");
    }
}
