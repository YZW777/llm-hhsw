package com.kuaishou.esp.langchain4j.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2026-01-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdDspCampaign {
    /** 计划id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 账户id */
    private Long accountId;

    /** 计划名称 */
    private String name;

    /** 投放状态 */
    private Byte putStatus;

    /** 计划类型 */
    private Byte type;

    /** 日预算（单位：微分） */
    private Long dayBudget;

    /** 创建时间（Unix 时间戳） */
    private Long createTime;

    /** 更新时间（Unix 时间戳） */
    private Long updateTime;

    /** 开始时间（Unix 时间戳，默认 0） */
    private Long beginTime;

    /** 结束时间（Unix 时间戳，默认 0） */
    private Long endTime;

    /** 直播userId（默认 0） */
    private Long liveUserId;
}
