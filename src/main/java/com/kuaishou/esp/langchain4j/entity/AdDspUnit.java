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
public class AdDspUnit {
    /**
     * 单元id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 计划id
     */
    private Long campaignId;

    /**
     * 单元名称
     */
    private String name;

    /**
     * 投放状态 (tinyint)
     */
    private Byte putStatus;

    /**
     * 出价（单位：厘，如 1元 = 1000000）
     */
    private Long bid;

    /**
     * CPA出价（capBid，单位同上）
     */
    private Long cpaBid;

    /**
     * 出价类型 (tinyint)
     */
    private Byte bidType;

    /**
     * 优化目标 (smallint)，可为 null
     */
    private Short ocpxActionType;

    /**
     * 日预算（单位：微分）
     */
    private Long dayBudget;

    /**
     * 投放方式 (tinyint)
     */
    private Byte speed;

    /**
     * 投放开始时间（Unix 时间戳，毫秒或秒，根据业务约定）
     */
    private Long beginTime;

    /**
     * 投放结束时间（Unix 时间戳）
     */
    private Long endTime;

    /**
     * 创建时间（Unix 时间戳）
     */
    private Long createTime;

    /**
     * 更新时间（Unix 时间戳）
     */
    private Long updateTime;
}
