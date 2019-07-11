package com.vdesign.gani.domain;

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
public class RespProduct implements Serializable {
    /**
     * CAD_url :
     * VR_url : 111
     * brand_id : 12
     * case_data : [{"attr_data":[{"attr_name":"欧式"},{"attr_name":"餐厅"},{"attr_name":"客厅"},{"attr_name":"棕色"},{"attr_name":"600*1200"},{"attr_name":"600*900"},{"attr_name":"家装"}],"builder":"保加利亚灰效果图","id":"758","preview":"uploads/case/5b10a0bbc59bd_thumb.jpg"},{"attr_data":[{"attr_name":"其他"},{"attr_name":"美式"},{"attr_name":"欧式"},{"attr_name":"现代"},{"attr_name":"中式"},{"attr_name":"棕色"},{"attr_name":"灰色"},{"attr_name":"红色"},{"attr_name":"白色"},{"attr_name":"黑色"},{"attr_name":"米色"},{"attr_name":"金色"},{"attr_name":"绿色"},{"attr_name":"蓝色"},{"attr_name":"600*900"},{"attr_name":"600*1200"},{"attr_name":"900*1200"},{"attr_name":"810*1620"},{"attr_name":"900*900"},{"attr_name":"家装"},{"attr_name":"卫浴"}],"builder":"卫浴效果图","id":"773","preview":"uploads/case/5b10c1abaadd8_thumb.jpg"},{"attr_data":[{"attr_name":"餐厅"},{"attr_name":"中式"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"家装"}],"builder":"餐厅效果图25","id":"815","preview":"uploads/case/5b17448c66dd8_thumb.jpg"},{"attr_data":[{"attr_name":"厨房"},{"attr_name":"现代"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"家装"}],"builder":"厨房效果图8","id":"823","preview":"uploads/case/5b17491b5103b_thumb.jpg"},{"attr_data":[{"attr_name":"卫浴"},{"attr_name":"欧式"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"家装"}],"builder":"卫浴效果图11","id":"1130","preview":"uploads/case/5b189feb3bf9d_thumb.jpg"},{"attr_data":[{"attr_name":"宜家风"},{"attr_name":"楼梯"},{"attr_name":"混搭风"},{"attr_name":"家装"},{"attr_name":"富阳（杭州）"}],"builder":"美庐1-1601","id":"1512","preview":"uploads/case/5b72dd7570349_thumb.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"哈尔滨"},{"attr_name":"欧式"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"白色"},{"attr_name":"600*1200"},{"attr_name":"客厅"},{"attr_name":"米色"}],"builder":"讷河锦祥二期","id":"1622","preview":"uploads/case/5b7fc6ede855d_thumb.jpg"},{"attr_data":[{"attr_name":"武汉"},{"attr_name":"家装"},{"attr_name":"卫浴"},{"attr_name":"现代"},{"attr_name":"黑色"}],"builder":"保利十二橡树庄园\u2014罗岩","id":"1615","preview":"uploads/case/5b7f689828302_thumb.jpg"},{"attr_data":[{"attr_name":"哈尔滨"},{"attr_name":"中式"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"家装"}],"builder":"长岛5","id":"1633","preview":"uploads/case/5b80ad6c71da5_thumb.jpg"},{"attr_data":[{"attr_name":"哈尔滨"},{"attr_name":"现代"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"工装"},{"attr_name":"棕色"}],"builder":"昌黎","id":"1642","preview":"uploads/case/5b80b7fe6a45a_thumb.jpg"},{"attr_data":[{"attr_name":"株洲"},{"attr_name":"家装"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"黑色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"白色"},{"attr_name":"前厅"},{"attr_name":"餐厅"}],"builder":"景秀家园","id":"1748","preview":"uploads/case/5b8f37fbc1427_thumb.jpg"},{"attr_data":[{"attr_name":"卫浴"},{"attr_name":"欧式"},{"attr_name":"白色"},{"attr_name":"米色"},{"attr_name":"600*900"},{"attr_name":"600*1200"},{"attr_name":"北京"},{"attr_name":"家装"}],"builder":"丽宫别墅","id":"1792","preview":"uploads/case/5b9c73660c699_thumb.jpg"},{"attr_data":[{"attr_name":"广州"},{"attr_name":"中式"},{"attr_name":"白色"},{"attr_name":"600*900"},{"attr_name":"厨房"},{"attr_name":"900*1200"},{"attr_name":"卫浴"},{"attr_name":"绿色"},{"attr_name":"餐厅"}],"builder":"云岭湖云景三街45号","id":"2458","preview":"uploads/case/5bf79d2107ee0_thumb.jpg"},{"attr_data":[{"attr_name":"抚州"},{"attr_name":"家装"},{"attr_name":"现代"},{"attr_name":"白色"},{"attr_name":"600*600"},{"attr_name":"卫浴"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"600*900"}],"builder":"凤凰香域滨江8#101","id":"2781","preview":"uploads/case/5c08d6462bc7d_thumb.jpg"},{"attr_data":[{"attr_name":"抚州"},{"attr_name":"家装"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"客厅"},{"attr_name":"现代"},{"attr_name":"卫浴"},{"attr_name":"白色"},{"attr_name":"600*900"}],"builder":"瑞日嘉园卜美女","id":"2793","preview":"uploads/case/5c08ec293c0fc_thumb.jpg"},{"attr_data":[{"attr_name":"滁州"},{"attr_name":"家装"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"客厅"},{"attr_name":"卫浴"},{"attr_name":"厨房"},{"attr_name":"米色"},{"attr_name":"蓝色"},{"attr_name":"过道"}],"builder":"琅琊天下","id":"2748","preview":"uploads/case/5c060b6a3bb85_thumb.png"},{"attr_data":[{"attr_name":"衡阳"},{"attr_name":"家装"},{"attr_name":"其他"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"客厅"},{"attr_name":"白色"},{"attr_name":"厨房"},{"attr_name":"600*600"},{"attr_name":"卫浴"}],"builder":"芸莎诗意1栋2602","id":"2930","preview":"uploads/case/5c19bc44e2813_thumb.jpg"},{"attr_data":[{"attr_name":"金华"},{"attr_name":"家装"},{"attr_name":"客厅"},{"attr_name":"厨房"},{"attr_name":"卫浴"},{"attr_name":"法式"},{"attr_name":"白色"},{"attr_name":"灰色"},{"attr_name":"600*1200"}],"builder":"保集庄园28-2","id":"2970","preview":"uploads/case/5c1c5eae4a098_thumb.jpg"},{"attr_data":[{"attr_name":"温州"},{"attr_name":"家装"},{"attr_name":"现代"},{"attr_name":"白色"},{"attr_name":"900*1800"},{"attr_name":"客厅"},{"attr_name":"黑色"},{"attr_name":"600*1200"},{"attr_name":"卫浴"},{"attr_name":"灰色"},{"attr_name":"600*600"},{"attr_name":"600*900"},{"attr_name":"餐厅"},{"attr_name":"法式"},{"attr_name":"红色"}],"builder":"吹着口哨的绅士","id":"2859","preview":"uploads/case/5c1292aac7e36_thumb.jpg"},{"attr_data":[{"attr_name":"丰城"},{"attr_name":"家装"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"过道"},{"attr_name":"客厅"},{"attr_name":"蓝色"},{"attr_name":"茶室"},{"attr_name":"餐厅"},{"attr_name":"卫浴"},{"attr_name":"600*900"}],"builder":"中式别墅","id":"2941","preview":"uploads/case/5c19ec7e81503_thumb.jpg"},{"attr_data":[{"attr_name":"滁州"},{"attr_name":"中式"},{"attr_name":"米色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"灰色"},{"attr_name":"900*900"},{"attr_name":"客厅"},{"attr_name":"白色"},{"attr_name":"600*1200"},{"attr_name":"过道"},{"attr_name":"茶室"},{"attr_name":"餐厅"},{"attr_name":"家装"}],"builder":"玲珑湾卢总","id":"3103","preview":"uploads/case/5c36cc8904772_thumb.jpg"},{"attr_data":[{"attr_name":"连云港"},{"attr_name":"家装"},{"attr_name":"现代"},{"attr_name":"蓝色"},{"attr_name":"600*900"},{"attr_name":"前厅"},{"attr_name":"灰色"},{"attr_name":"餐厅"},{"attr_name":"白色"},{"attr_name":"客厅"},{"attr_name":"黑色"}],"builder":"御湖豪庭","id":"3145","preview":"uploads/case/5c64c5b02e0c3_thumb.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"黄石"},{"attr_name":"欧式"},{"attr_name":"米色"},{"attr_name":"600*600"},{"attr_name":"灰色"},{"attr_name":"卫浴"},{"attr_name":"600*900"}],"builder":"仁智山水田总","id":"3222","preview":"uploads/case/5c6f9e7403025_thumb.png"},{"attr_data":[{"attr_name":"现代"},{"attr_name":"白色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"900*900"},{"attr_name":"中式"},{"attr_name":"米色"},{"attr_name":"法式"},{"attr_name":"黑色"},{"attr_name":"浏阳"},{"attr_name":"家装"}],"builder":"浏阳亚大新城法式","id":"2712","preview":"uploads/case/5c7c868262be6_thumb.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"滁州"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"过道"},{"attr_name":"米色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"客厅"},{"attr_name":"厨房"},{"attr_name":"餐厅"}],"builder":"玫瑰郡","id":"3444","preview":"uploads/case/5c8dddcbb4bdd_thumb.jpg"},{"attr_data":[{"attr_name":"温州"},{"attr_name":"家装"},{"attr_name":"现代"},{"attr_name":"黑色"},{"attr_name":"600*1200"},{"attr_name":"客厅"}],"builder":"太平洋的风","id":"3622","preview":"uploads/case/5caac1d3af035_thumb.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"滁州"},{"attr_name":"美式"},{"attr_name":"米色"},{"attr_name":"900*900"},{"attr_name":"前厅"},{"attr_name":"客厅"},{"attr_name":"餐厅"},{"attr_name":"过道"},{"attr_name":"楼梯"},{"attr_name":"卫浴"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"中式"},{"attr_name":"白色"},{"attr_name":"书房"},{"attr_name":"地下室"}],"builder":"玲珑湾刘总福宅","id":"3713","preview":"uploads/case/5cc52c431e502_thumb.jpg"},{"attr_data":[{"attr_name":"重庆"},{"attr_name":"家装"},{"attr_name":"美式"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"餐厅"},{"attr_name":"地下室"}],"builder":"江与城原山","id":"3748","preview":"uploads/case/5cc9089789c9e_thumb.jpg"},{"attr_data":[{"attr_name":"洛阳"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"客厅"},{"attr_name":"白色"},{"attr_name":"卫浴"},{"attr_name":"过道"},{"attr_name":"其他"},{"attr_name":"前厅"},{"attr_name":"家装"}],"builder":"洛阳花语墅","id":"3436","preview":"uploads/case/5c8c54b7088d0_thumb.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"滁州"},{"attr_name":"中式"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"过道"},{"attr_name":"客厅"},{"attr_name":"米色"},{"attr_name":"600*900"},{"attr_name":"卫浴"}],"builder":"玫瑰郡","id":"3511","preview":"uploads/case/5caddcdc5f568_thumb.jpg"},{"attr_data":[{"attr_name":"黄石"},{"attr_name":"中式"},{"attr_name":"白色"},{"attr_name":"600*900"},{"attr_name":"客厅"},{"attr_name":"灰色"},{"attr_name":"卫浴"},{"attr_name":"楼梯"},{"attr_name":"厨房"},{"attr_name":"家装"}],"builder":"鄂州江总","id":"3857","preview":"case/5ce77f3696f22.jpg"},{"attr_data":[{"attr_name":"滁州"},{"attr_name":"家装"},{"attr_name":"现代"},{"attr_name":"灰色"},{"attr_name":"600*1200"},{"attr_name":"厨房"},{"attr_name":"客厅"},{"attr_name":"棕色"},{"attr_name":"600*900"},{"attr_name":"卫浴"}],"builder":"三盛卞总福宅","id":"3903","preview":"case/5cf5e1e2681b6.jpg"},{"attr_data":[{"attr_name":"家装"},{"attr_name":"邯郸"},{"attr_name":"现代"},{"attr_name":"灰色"},{"attr_name":"600*900"},{"attr_name":"卫浴"},{"attr_name":"中式"},{"attr_name":"白色"},{"attr_name":"蓝色"},{"attr_name":"600*1200"}],"builder":"锦河湾案例","id":"4031","preview":"case/5d14307453380.jpg"}]
     * createdate : 2018-04-14 21:17:14
     * fav : 0
     * fav_num : 2
     * id : 612
     * isCAD : 2
     * isVR : 1
     * isback : 1
     * msg : 查询成功
     * param_1 : 黑金沙
     * param_2 : Palissandro Black
     * param_3 :
     * param_4 :
     * param_5 :
     * product_attr_data : [{"id":"202","product_attr_name":"价格","sattr_data":[{"id":"26846","path":"","product_attr_name":"200-500元/㎡"}],"type":"1"},{"id":"194","product_attr_name":"规格","sattr_data":[{"id":"26847","path":"","product_attr_name":"600X900"}],"type":"1"},{"id":"188","product_attr_name":"纹理","sattr_data":[{"id":"26848","path":"","product_attr_name":"直纹"}],"type":"1"},{"id":"179","product_attr_name":"色系","sattr_data":[{"id":"26849","path":"","product_attr_name":"黑色"}],"type":"1"}]
     * product_content : 600x900mm 468 元/ m² D696833BMT（通体石材光）  原石产地：意大利 原石等级：A级  著名的香港汇丰银行就采用了黑金沙。 黑金沙纹理顺直，层叠有序，给人的感觉深沉、严谨、有延伸感。
     * product_img_data : []
     * product_name : D602169BM|D692169BM
     * product_preview : product/5cecfbc15d41b.jpg
     * product_video :
     * share_num : 32
     * starproduct_id : 0
     * starproduct_video :
     * status : 200
     * style_attr : 1,1,1,1
     */

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
    @SerializedName("product_video")
    private String product_video;
    @SerializedName("share_num")
    private Integer shareNum;
    @SerializedName("starproduct_id")
    private String starproductId;
    @SerializedName("starproduct_video")
    private String starproductVideo;
    private Integer status;
    @SerializedName("style_attr")
    private String styleAttr;
    @SerializedName("case_data")
    private List<CaseData> caseData;
    @SerializedName("product_attr_data")
    private List<ProductAttrData> productAttrData;
    @SerializedName("product_img_data")
    private List<ProductImg> productImgData;

    @NoArgsConstructor
    @Data
    public static class CaseData implements Serializable{
        /**
         * attr_data : [{"attr_name":"欧式"},{"attr_name":"餐厅"},{"attr_name":"客厅"},{"attr_name":"棕色"},{"attr_name":"600*1200"},{"attr_name":"600*900"},{"attr_name":"家装"}]
         * builder : 保加利亚灰效果图
         * id : 758
         * preview : uploads/case/5b10a0bbc59bd_thumb.jpg
         */

        private String builder;
        private String id;
        private String preview;
        @SerializedName("attr_data")
        private List<AttrData> attrData;

        @NoArgsConstructor
        @Data
        public static class AttrData implements Serializable{
            /**
             * attr_name : 欧式
             */
            @SerializedName("attr_name")
            private String attrAame;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ProductAttrData implements Serializable{
        /**
         * id : 202
         * product_attr_name : 价格
         * sattr_data : [{"id":"26846","path":"","product_attr_name":"200-500元/㎡"}]
         * type : 1
         */

        private String id;
        @SerializedName("product_attr_name")
        private String productAttrName;
        private String type;
        @SerializedName("sattr_data")
        private List<SattrData> sattrData;

        @NoArgsConstructor
        @Data
        public static class SattrData implements Serializable{
            /**
             * id : 26846
             * path :
             * product_attr_name : 200-500元/㎡
             */

            private String id;
            private String path;
            @SerializedName("product_attr_name")
            private String productAttrName;
        }
    }
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductImg implements Serializable{
        private String id;
        private String groupanme;
        private String path;
        @SerializedName("product_id")
        private String productId;
        @SerializedName("seq")
        private Integer seq;
        private Date updatetime;
    }

}
