package com.vdesign.gani.domain.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/8 17:42
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "casee")
@Entity
public class Case implements Serializable {

    @Id
    private String id;
    private String adds;
    private String builder;
    @SerializedName("case_type")
    private String caseType;
    private String content;
    private String createdate;
    private String fav;
    @SerializedName("fav_num")
    private Integer favNum;
    private String headimg;
    @SerializedName("is_real_scene")
    private String isRealScene;
    private String price;
    private String realname;
    @SerializedName("share_num")
    private Integer shareNum;
    private String star;
}
