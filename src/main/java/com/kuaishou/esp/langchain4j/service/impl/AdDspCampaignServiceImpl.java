package com.kuaishou.esp.langchain4j.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuaishou.esp.langchain4j.entity.AdDspCampaign;
import com.kuaishou.esp.langchain4j.mapper.AdDspCampaignMapper;
import com.kuaishou.esp.langchain4j.service.AdDspCampaignService;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2026-01-05
 */
@Service
public class AdDspCampaignServiceImpl extends ServiceImpl<AdDspCampaignMapper, AdDspCampaign> implements AdDspCampaignService {
    @Override
    public List<AdDspCampaign> listByAccountIdAndCampaignId(Long accountId, Long campaignId) {
        LambdaQueryWrapper<AdDspCampaign> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdDspCampaign::getAccountId, accountId);
        queryWrapper.eq(AdDspCampaign::getId, campaignId);
        AdDspCampaign adDspCampaign = baseMapper.selectOne(queryWrapper);
        return List.of(adDspCampaign);
    }

    @Override
    public int updateDayBudget(Long accountId, Long campaignId, Long dayBudget) {
        LambdaUpdateWrapper<AdDspCampaign> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(AdDspCampaign::getAccountId, accountId);
        updateWrapper.eq(AdDspCampaign::getId, campaignId);
        updateWrapper.set(AdDspCampaign::getDayBudget, dayBudget);
        return baseMapper.update(null, updateWrapper);
    }
}
