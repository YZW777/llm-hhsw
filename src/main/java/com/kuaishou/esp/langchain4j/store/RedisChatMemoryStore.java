package com.kuaishou.esp.langchain4j.store;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-22
 */
@Component
public class RedisChatMemoryStore implements ChatMemoryStore {



    @Override
    public List<ChatMessage> getMessages(Object memoryId) {

        return ChatMessageDeserializer.messagesFromJson("");
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {

    }

    @Override
    public void deleteMessages(Object memoryId) {

    }
}
