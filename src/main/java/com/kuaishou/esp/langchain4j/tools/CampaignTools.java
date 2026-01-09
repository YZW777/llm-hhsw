package com.kuaishou.esp.langchain4j.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaishou.esp.langchain4j.entity.AdDspCampaign;
import com.kuaishou.esp.langchain4j.service.AdDspCampaignService;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2026-01-08
 */
@Component
public class CampaignTools {

    @Autowired
    private AdDspCampaignService adDspCampaignService;

    @Tool(name = "查询计划", value = "根据accountId、campaignId查询计划信息")
    public AdDspCampaign queryCampaign(
            @ToolMemoryId long memoryId,
            @P(value = "accountId", required = true) Long accountId,
            @P(value = "campaignId", required = true) Long campaignId
    ) {
        List<AdDspCampaign> adDspCampaigns = adDspCampaignService.listByAccountIdAndCampaignId(accountId, campaignId);
        return adDspCampaigns.isEmpty() ? null : adDspCampaigns.get(0);
    }

    @Tool
    public Boolean createCampaign(
            @ToolMemoryId long memoryId,
            @P(value = "accountId", required = true) Long accountId,
            @P(value = "dayBudget", required = true) Long dayBudget,
            @P(value = "campaignName", required = true) String campaignName
    ) {
        AdDspCampaign adDspCampaign = new AdDspCampaign();
        adDspCampaign.setAccountId(accountId);
        adDspCampaign.setName(campaignName);
        adDspCampaign.setDayBudget(dayBudget);
        long now = System.currentTimeMillis();
        adDspCampaign.setCreateTime(now);
        adDspCampaign.setUpdateTime(now);
        adDspCampaign.setPutStatus(Byte.valueOf("1"));
        adDspCampaign.setType(Byte.valueOf("1"));
        adDspCampaign.setBeginTime(now);
        return adDspCampaignService.save(adDspCampaign);
    }


    @Tool(name = "更新计划预算", value = "根据accountId、campaignId、dayBudget更新计划预算")
    public Boolean createCampaign(
            @ToolMemoryId long memoryId,
            @P(value = "accountId", required = true) Long accountId,
            @P(value = "campaignId", required = true) Long campaignId,
            @P(value = "dayBudget", required = true) Long dayBudget
    ) {
        int effectedRows = adDspCampaignService.updateDayBudget(accountId, campaignId, dayBudget);
        return effectedRows > 0;
    }
}
