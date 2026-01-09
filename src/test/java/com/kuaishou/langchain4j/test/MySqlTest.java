package com.kuaishou.langchain4j.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.kuaishou.esp.langchain4j.EspHhswAppApplication;
import com.kuaishou.esp.langchain4j.entity.AdDspCampaign;
import com.kuaishou.esp.langchain4j.service.AdDspCampaignService;
import com.kuaishou.esp.langchain4j.service.AdDspCreativeService;
import com.kuaishou.esp.langchain4j.service.AdDspUnitService;

import jakarta.annotation.Resource;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2026-01-05
 */
@SpringBootTest(classes = EspHhswAppApplication.class)
public class MySqlTest {

    @Resource
    private AdDspCampaignService adDspCampaignService;

    @Test
    public void testSaveCampaign() {
        AdDspCampaign adDspCampaign = new AdDspCampaign();
        adDspCampaign.setAccountId(1L);
        adDspCampaign.setName("test");
        adDspCampaign.setPutStatus(Byte.valueOf("1"));
        adDspCampaign.setType(Byte.valueOf("1"));
        adDspCampaign.setDayBudget(1000L);
        adDspCampaign.setCreateTime(System.currentTimeMillis());
        adDspCampaign.setUpdateTime(System.currentTimeMillis());
        adDspCampaign.setBeginTime(System.currentTimeMillis());
        adDspCampaign.setEndTime(System.currentTimeMillis());
        adDspCampaign.setLiveUserId(1L);
        adDspCampaignService.save(adDspCampaign);
    }



}
