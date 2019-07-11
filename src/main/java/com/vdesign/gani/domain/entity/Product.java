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
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/8 16:52
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Entity
public class Product implements Serializable {
    @SerializedName("brand_id")
    private String brandId;
    private String createdate;
    private String fav;
    @SerializedName("fav_num")
    private Integer favNum;
    @Id
    private String id;
    @SerializedName("param_1")
    private String param1;
    @SerializedName("param_2")
    private String param2;
    @SerializedName("param_3")
    private String param3;
    @SerializedName("param_4")
    private String param4;
    @SerializedName("param_5")
    private String param5;
    @SerializedName("product_content")
    private String productContent;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("product_preview")
    private String productPreview;
    @SerializedName("share_num")
    private Integer shareNum;
    @SerializedName("starproduct_id")
    private String starproductId;
    @SerializedName("style_attr")
    private String styleAttr;

}
