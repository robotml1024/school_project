package com.zhengyuan.liunao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    int id;                     // 唯一编号
    String name;                // 名称
    String type;                // 类别（景点、教学楼、商店、厕所等）
    double latitude;            // 经度
    double longitude;           // 纬度
    double heat;                // 热度值
    double rating;              // 用户评分
    String tag;                 // 标签（自然、人文、运动）
}
