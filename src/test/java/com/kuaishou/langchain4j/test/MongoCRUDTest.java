package com.kuaishou.langchain4j.test;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;
import com.kuaishou.esp.langchain4j.bean.ChatMessages;

import jakarta.annotation.Resource;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-28
 */
@SpringBootTest(classes = EspHhswAppApplication.class)
public class MongoCRUDTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        System.out.println("Database name: " + mongoTemplate.getDb().getName());
    }

    /**
     * 插入文档
     */
   /* @Test
    public void testInsert() {
        mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
    }*/

    /**
     * 插入文档
     */
    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        ObjectId objectId = new ObjectId();
        chatMessages.setMessageId(objectId);
        mongoTemplate.insert(chatMessages);
        System.out.println("Inserted document with ID: " + objectId);
    }

    /**
     * 根据id查询文档
     */
    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("69513c6d671ce02613f136e4", ChatMessages.class);
        System.out.println(chatMessages);
    }

    /**
     * 修改文档
     */
    @Test
    public void testUpdate() {

        Criteria criteria = Criteria.where("_id").is("68458d97e398821d3b4107f8");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表");

        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    /**
     * 新增或修改文档
     */
    @Test
    public void testUpdate2() {

        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表");

        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    /**
     * 删除文档
     */
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
