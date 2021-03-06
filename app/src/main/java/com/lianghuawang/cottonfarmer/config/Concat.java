package com.lianghuawang.cottonfarmer.config;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public interface Concat {

    String TOKEN = "Bearer Ka-el4ED20V8fXQ6pWKXuYFXVStP78Kd";

    String API = "http://39.107.229.149";
//    String APIS = "http://app.lianhuawang.cn";
//    String IMAGE_URL = "http://images.lianhuawang.cn";

    String PORT = ":82";//数据请求端口

    String PORTIMAGE = ":86";//图片请求端口

    String APIS= API + PORT;

    String BASE_URL = APIS + "/v2/";

    String IMAGE_URL = API + PORTIMAGE;

    /**
     * GET兵团分类
     */
    String CORPS = BASE_URL + "areas/get-area?area_type=%1$s&parent_id=%2$s";

    /**
     * GET获取省机构
     */
    String SHENGJIGOU = BASE_URL + "mechanisms/get-province";

    /**
     * 分机构
     */
    String FENJIGOU = BASE_URL + "mechanisms/get-branch?p_id=65";

    /**
     * 机构
     */
    String JIGOU = BASE_URL + "mechanisms/get-mechanism?name=";

    /**
     * POST验证码
     * 已测试调通
     */
    String VERIFICATIONCODE_URL = BASE_URL + "login/captcha";

    /**
     * POST注册
     * 已测试调通
     */
    String REGISTER_URL = BASE_URL + "login/register";

    /**
     * POST登录
     * 已测试调通
     */
    String SIGNIN_URL = BASE_URL + "login/login";

    /**
     * 退出用户
     */
    String EXIT_LOGIN = BASE_URL + "login/log-out";

    /**
     * GET消息通知
     */
    String MESSAGESNOTIFICATION_URL = BASE_URL + "messages";

    /**
     * GET未读消息数
     */
    String UNREADMESSAGENUMBER_URL = BASE_URL + "messages/unread-count";

    /**
     * GET棉农个人详情
     */
    String PERSONALDETAILS_URL = BASE_URL + "cotton-farmers/detail";

    /**
     * POST上传头像接口
     */
    String UPLOADAHEADIMAGE_URL = BASE_URL + "cotton-farmers/upload-image";

    /**
     * PATCH完善种植信息
     */
    String PERFECTPLANTING_URL = BASE_URL + "cotton-farmers/update-plants";

    /**
     * 新增地块
     */
    String ADD_BLOCK_URL = BASE_URL + "cotton-farmers/add-plot";
    /**
     * 获取地块列表
     */
    String BLOCK_URL = BASE_URL + "cotton-farmers/plot-list";

    /**
     * PATCH完善基本信息
     */
    String IMPROVINGBASICINFORMATION_URL = BASE_URL + "cotton-farmers/update-information";

    /**
     * POST验证银行卡信息
     */
    String VERIFICATIONOFBANKCARDINFORMATION_URL = BASE_URL + "cotton-farmers/validate-bank";

    /**
     * PATCH绑定银行卡
     */
    String BINDINGBANKCARD_URL = BASE_URL + "cotton-farmers/update-bank";

    /**
     * GET银行卡列表
     */
    String BANKCARDLIST_URL = BASE_URL + "cotton-farmers/banks";

    /**
     * PATCH设置当前银行卡为默认卡
     */
    String SETTHECURRENTBANKCARDASTHEDEFAULTCARD_URL = BASE_URL + "cotton-farmers/set-default-bank";

    /**
     * POST权属证明（多图上传）
     */
    String PROOFOFOWNERSHIP_URL = BASE_URL + "cotton-farmers/upload-files";

    /**
     * 删除权属证明
     */
    String DELEPROOFO_URL = BASE_URL + "cotton-farmers/delete-owner-image";

    /**
     * 权属列表
     */
    String PROOFLIST_URL = BASE_URL + "cotton-farmers/owner-image";

    /**
     * POST身份证实名认证
     */
    String IDENTITYCARDREALNAMEAUTHENTICATION_URL = BASE_URL + "cotton-farmers/id-identity";

    /**
     * POST上传身份证正面照
     */
    String UPLOADIDENTITYCARDZHENG_URL = BASE_URL + "cotton-farmers/upload-id-card";

    /**
     * POST上传身份证反面照
     */
    String UPLOADIDENTITYCARDFAN_URL = BASE_URL + "cotton-farmers upload-id-card";

    /**
     * GET保险购买记录
     */
    String INSURANCEPURCHASERECORD_URL = BASE_URL + "cotton-farmers/insurance-record";

    /**
     * GET购买保险记录--险种类别
     */
    String INSURANCEPURCHASERECORDTYPES_URL = BASE_URL + "cotton-farmers/get-risk";

    /**
     * POST删除保险记录--
     */
    String INSURANCEPURCHASERECORDDEL_URL = BASE_URL + "cotton-farmers/delete-insurance-record";

    /**
     * PAT修改保险记录--
     */
    String INSURANCEPURCHASERECORDUPDATE_URL = BASE_URL + "cotton-farmers/update-insurance-record";

    /**
     * POST修改保险记录--
     */
    String INSURANCEPURCHASERECORDUPADD_URL = BASE_URL + "cotton-farmers/add-insurance-record";

    /**
     * DELETE删除地块信息
     */
    String DELETEMASSIFINFORMATION_URL = BASE_URL + "cotton-farmers/delete-plant";

    /**
     * 支付
     */
    String PAY_URL = BASE_URL + "insures/update-pay-status";


    /**
     * GET订单列表
     */
    String ORDERLIST_URL = BASE_URL + "insures";

    /**
     * GET我的订单列表(保险)
     */
    String ORDER_INSURANCE_LIST_URL = BASE_URL + "insures/my-order";


    /**
     * PUT修改支付状态
     */
    String MODIFYTHESTATEOFPAYMENT_URL = BASE_URL + "insures/update-pay-status";

    /**
     * GET获取已支付订单
     */
    String GETTHEPAIDORDER_URL = BASE_URL + "insures/pay-order";

    /**
     * GET获取未支付订单
     */
    String OBTAINUNPAIDORDER_URL = BASE_URL + "insures/un-pay-order";

    /**
     * GET获取预约投保详情
     */
    String OBTAININGTHEDETAILSOFTHERESERVATION_URL = BASE_URL + "insurances/insurance-detail?product_id=101";

    /**
     * POST预约保单接口
     */
    String RESERVATIONPOLICYINTERFACE_URL = BASE_URL + "insurances/insured";

    /**
     * GET预约投保进度
     */
    String SCHEDULEOFRESERVATION_URL = BASE_URL + "insurances/progress";

    /**
     * GET合作社列表
     */
    String COOPERATIVELIST_URL = BASE_URL + "cotton-farmers/get-cooperative";

    /**
     * GET合作社成员
     */
    String COOPERATIVEMEMBERS_URL = BASE_URL + "cotton-farmers/member";

    /**
     * GET集体保单
     */
    String COLLCTIVEPOLICY_URL = BASE_URL + "collectives";

    /**
     * 更多合作社
     */
    String MORECOOPERATIVES_URL = BASE_URL + "cotton-farmers/more-cooperative";

    /**
     * POST加入合作社
     */
    String JOINACOOPERATIVE_URL = BASE_URL + "cotton-farmers/join-cooperative";


    /**
     * GET保险列表
     * cate_id = 1表示为农业保险
     * cate_id = 2表示为信用保险
     */
    String PRODUCTLIST_URL = BASE_URL + "products/list?cate_id=%1$s";

    /**
     * GET保险详情
     */
    String PRODUCTS_QUERY_URL = BASE_URL + "products/query-by-id?product_id=%1$s&cate_id=%2$s";
    /**
     * GET确认订单
     */
    String CONFIRMORDER_URL = BASE_URL + "insurances/insurance-detail?product_id=%1$s&cate_id=%2$s";

    /**
     * 预约保险订单
     */
    String YUYUEBAOXIAN_URL = BASE_URL + "insurances/insured";

    /**
     * GET检测是否可用购买保险
     */
    String INSURANCES_IS_IDENTITY_URL = BASE_URL + "insurances/is-identity";
    /**
     * 签名
     */
    String QIANMING_URL = BASE_URL + "insurances/sign";

    /**
     * POST我要报案
     */
    String IWANTTOREPORTCASE_URL = BASE_URL + "claims/report";

    /**
     * POST查询报案进度
     */
    String INQUIRYREPORTPROGRESS_URL = BASE_URL + "claims/progress";

    /**
     * POST申请额度
     */
    String APPLICATIONAMOUNT_URL = BASE_URL + "loans/apply";


    /**
     * 新闻资讯
     * news_type:1链花头条;2推荐资讯
     */
    String NEWS = BASE_URL + "news/list?news_type=%1$s";

    /**
     * 新闻详情
     */
    String NEWS_PARTICULAR = BASE_URL + "news/by-id?news_id=%1$s";
}
