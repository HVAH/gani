package com.vdesign.gani.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/11 11:11
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "case_img")
@Entity
public class CaseImg {
    @Id
    private String id;
    private String groupname;
    private String imgType;
    private String path;
    private String remark;
    private String seq;
    private String updatetime;
    private String attrIds;
    private String productIds;
}
