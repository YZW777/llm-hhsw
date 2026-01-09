package com.kuaishou.esp.langchain4j.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuaishou.esp.langchain4j.entity.AdDspCampaign;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2026-01-05
 */
@Service
public interface AdDspCampaignService extends IService<AdDspCampaign> {

    List<AdDspCampaign> listByAccountIdAndCampaignId(Long accountId, Long campaignId);

    int updateDayBudget(Long accountId, Long campaignId, Long dayBudget);
}
