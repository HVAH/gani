package com.vdesign.gani;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 9:36
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Prod {
    private String CAD_url;
    private String VR_url;
    private String brand_id;
    private String click_num;
    private String id;
    private String isCAD;
    private String isVR;
    private String isback;
    private String isfav;
    private String param_1;
    private String param_2;
    private String param_3;
    private String param_4;
    private String param_5;
    private String product_content;
    private String product_name;
    private String product_preview;
    private String product_video;
    private String selltime;
    private String starproduct_id;
}
