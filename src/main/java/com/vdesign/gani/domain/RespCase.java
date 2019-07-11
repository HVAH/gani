package com.vdesign.gani.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
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
public class RespCase implements Serializable {

    /**
     * CAD_url : uploads/CAD/5b0dfd23d1204.dwg
     * VR_list : ["https://720yun.com/t/30cje5sytw9"]
     * VR_type : 1
     * VR_url : https://720yun.com/t/30cje5sytw9
     * adds : 邢台
     * attr : [{"attr_name":"客厅","attr_type":"1","id":"305"},{"attr_name":"餐厅","attr_type":"1","id":"306"},{"attr_name":"灰色","attr_type":"5","id":"361"},{"attr_name":"900*1200","attr_type":"5","id":"369"},{"attr_name":"600*900","attr_type":"5","id":"372"},{"attr_name":"家装","attr_type":"1","id":"658"},{"attr_name":"邢台","attr_type":"1","id":"709"}]
     * builder : 79号院32号楼
     * case_attr_data : [{"attr_name":"空间","id":"301","sattr_data":[{"attr_name":"客厅","id":"36298"},{"attr_name":"餐厅","id":"36299"}]},{"attr_name":"色系","id":"348","sattr_data":[{"attr_name":"灰色","id":"36300"}]},{"attr_name":"规格","id":"349","sattr_data":[{"attr_name":"600*900","id":"36301"},{"attr_name":"900*1200","id":"36304"}]},{"attr_name":"城市","id":"350","sattr_data":[{"attr_name":"邢台","id":"36302"}]},{"attr_name":"类型","id":"656","sattr_data":[{"attr_name":"家装","id":"36303"}]}]
     * case_type : 1
     * content : 整套空间产品使用面积：130㎡
     * createdate : 2018-08-30 10:35:20
     * fav : 0
     * fav_num : 0
     * headimg :
     * imgs : [{"attr_list":["305","372","361","329"],"groupname":"","id":"8218","img_type":"1","path":"uploads/case/5b1dde7640cdc.jpg","product_list":["562","584","618"],"remark":"","seq":"1","updatetime":"2019-03-07 18:54:48"},{"attr_list":["306","372","361","358"],"groupname":"","id":"6392","img_type":"1","path":"uploads/case/5b20c953c402b.jpg","product_list":["562","618","584"],"remark":"","seq":"2","updatetime":"2019-03-07 18:54:48"}]
     * isCAD : 1
     * isVR : 1
     * is_real_scene : 2
     * isbuy : 2
     * likes : [{"builder":"中式别墅套间1","case_id":"643","id":"346","preview":"uploads/case/5ae1bc662a784_thumb.jpg"},{"builder":"龙湖香醍西岸别墅","case_id":"643","id":"353","preview":"uploads/case/5ae1c18ca5f72_thumb.jpg"},{"builder":"意大利狐效果图","case_id":"643","id":"766","preview":"uploads/case/5b10a5a950f70_thumb.jpg"},{"builder":"云雾白效果图","case_id":"643","id":"771","preview":"uploads/case/5b10a8de165ac_thumb.jpg"},{"builder":"希腊灰效果图","case_id":"643","id":"765","preview":"uploads/case/5b10a4bc8bfb0_thumb.jpg"},{"builder":"蓝金沙效果图","case_id":"643","id":"763","preview":"uploads/case/5b10a3f59f1d5_thumb.jpg"}]
     * msg : 查询成功
     * price : 2.00
     * products : [{"id":"584","param_1":"意大利米灰","product_name":"D695868BM"},{"id":"618","param_1":"海纳百川","product_name":"DP91221003BH"},{"id":"562","param_1":"水云石","product_name":"D905854BM|D695854BM|D605854BM"}]
     * realname : 李聪
     * share_num : 5
     * star : 2
     * status : 200
     */
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
    private String isbuy;
    private String price;
    private String realname;
    @SerializedName("share_num")
    private Integer shareNum;
    private String star;
    private Integer status;
    private List<Attr> attr;
    @SerializedName("case_attr_data")
    private List<CaseAttrData> caseAttrData;
    private List<Img> imgs;
    private List<Like> likes;
    private List<RespProduct> products;

    @NoArgsConstructor
    @Data
    public static class Attr implements Serializable{
        /**
         * attr_name : 客厅
         * attr_type : 1
         * id : 305
         */
        @SerializedName("attr_name")
        private String attrName;
        @SerializedName("attr_type")
        private String attrType;
        private String id;
    }

    @NoArgsConstructor
    @Data
    public static class CaseAttrData implements Serializable{
        /**
         * attr_name : 空间
         * id : 301
         * sattr_data : [{"attr_name":"客厅","id":"36298"},{"attr_name":"餐厅","id":"36299"}]
         */

        @SerializedName("attr_name")
        private String attrName;
        private String id;
        @SerializedName("sattr_data")
        private List<SattrData> sattrData;

        @NoArgsConstructor
        @Data
        public static class SattrData implements Serializable{
            /**
             * attr_name : 客厅
             * id : 36298
             */
            @SerializedName("attr_name")
            private String attrName;
            private String id;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Img implements Serializable{
        /**
         * attr_list : ["305","372","361","329"]
         * groupname :
         * id : 8218
         * img_type : 1
         * path : uploads/case/5b1dde7640cdc.jpg
         * product_list : ["562","584","618"]
         * remark :
         * seq : 1
         * updatetime : 2019-03-07 18:54:48
         */

        private String groupname;
        private String id;
        @SerializedName("img_type")
        private String imgType;
        private String path;
        private String remark;
        private String seq;
        private String updatetime;
        @SerializedName("attr_list")
        private List<String> attrList;
        @SerializedName("product_list")
        private List<String> productList;
    }

    @NoArgsConstructor
    @Data
    public static class Like implements Serializable{
        /**
         * builder : 中式别墅套间1
         * case_id : 643
         * id : 346
         * preview : uploads/case/5ae1bc662a784_thumb.jpg
         */

        private String builder;
        @SerializedName("case_id")
        private String caseId;
        private String id;
        private String preview;
    }

}
