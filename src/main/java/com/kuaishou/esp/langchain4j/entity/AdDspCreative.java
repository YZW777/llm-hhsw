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
public class AdDspCreative {
    /** 创意id */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 账户id */
    private Long accountId;

    /** 计划id */
    private Long campaignId;

    /** 单元id */
    private Long unitId;

    /** 创意名称 */
    private String name;

    /** 视频id */
    private Long photoId;

    /** 重复视频id最小值 */
    private Long dupPhotoId;

    /** photo & dupPhoto相似值 */
    private Double similarityDupPhotoValue;

    /** 视频时长单位ms */
    private Integer duration;

    /** height */
    private Long coverHeight;

    /** 封面id */
    private Long coverId;

    /** 投放状态 */
    private Byte putStatus;

    /** 审核状态 */
    private Byte reviewStatus;

    /** 审核详情 */
    private String reviewDetail;

    /** 创意类型，默认值 1 */
    private Byte creativeType;

    /** 创建时间（Unix 时间戳） */
    private Long createTime;

    /** 更新时间（Unix 时间戳） */
    private Long updateTime;
}
