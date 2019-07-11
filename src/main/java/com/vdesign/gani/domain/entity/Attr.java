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
 * @Date 2019/7/11 10:55
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attr")
@Entity
public class Attr {
    @Id
    private String id;
    private String attrName;
    private String attrType;
}
