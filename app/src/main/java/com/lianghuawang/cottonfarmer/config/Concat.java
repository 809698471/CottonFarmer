package com.lianghuawang.cottonfarmer.config;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public interface Concat {
    String BASE_URL = "http://121.42.39.45:82/v1/";

    String VERIFICATIONCODE_URL = BASE_URL
            + "login/captcha";  //验证码
    String REGISTER_URL = BASE_URL
            + "login/register";//注册
    String SIGNIN_URL = BASE_URL
            + "login/login";//登录

    String MESSAGESNOTIFICATION_URL = BASE_URL
            + "messages";//消息通知
    String UNREADMESSAGENUMBER_URL = BASE_URL
            + "messages/unread-count";//未读消息数


    String PERSONALDETAILS_URL = BASE_URL
            + "cotton-farmers/detail";//棉农个人详情
    String UPLOADAHEADIMAGE_URL = BASE_URL
            + "cotton-farmers/upload-image";//上传头像接口
    String PERFECTPLANTING_URL = BASE_URL
            + "cotton-farmers/update-plant";//完善种植信息
    String IMPROVINGBASICINFORMATION_URL = BASE_URL
            + "cotton-farmers/update-information";//完善基本信息
    String VERIFICATIONOFBANKCARDINFORMATION_URL = BASE_URL
            + "cotton-farmers/validate-bank";//验证银行卡信息
    String BINDINGBANKCARD_URL = BASE_URL
            + "cotton-farmers/update-bank";//绑定银行卡
    String BANKCARDLIST_URL = BASE_URL
            + "cotton-farmers/banks";//银行卡列表
    String SETTHECURRENTBANKCARDASTHEDEFAULTCARD_URL = BASE_URL
            + "cotton-farmers/set-default-bank";//设置当前银行卡为默认卡
    String PROOFOFOWNERSHIP_URL = BASE_URL
            + "cotton-farmers/upload-files"; //权属证明（多图上传）
    String IDENTITYCARDREALNAMEAUTHENTICATION_URL = BASE_URL
            + "cotton-farmers/id-identity";//身份证实名认证
    String UPLOADIDENTITYCARDZHENG_URL = BASE_URL
            + "cotton-farmers//upload-id-card";//上传身份证正面照
    String UPLOADIDENTITYCARDFAN_URL = BASE_URL
            + "cotton-farmers//upload-id-card";//上传身份证反面照
    String INSURANCEPURCHASERECORD_URL = BASE_URL
            + "cotton-farmers/update-insurance-record";//保险购买记录
    String DELETEMASSIFINFORMATION_URL = BASE_URL
            + "cotton-farmers/delete-plant"; //删除地块信息


    String ORDERLIST_URL = BASE_URL
            + "insures";//订单列表
    String MODIFYTHESTATEOFPAYMENT_URL = BASE_URL
            + "insures/update-pay-status"; //修改支付状态
    String GETTHEPAIDORDER_URL = BASE_URL
            + "insures/pay-order";//获取已支付订单
    String OBTAINUNPAIDORDER_URL = BASE_URL
            + "insures/un-pay-order";//获取未支付订单


    String OBTAININGTHEDETAILSOFTHERESERVATION_URL = BASE_URL
            + "insurances/insurance-detail?product_id=101";//获取预约投保详情
    String RESERVATIONPOLICYINTERFACE_URL = BASE_URL
            + "insurances/insured";//预约保单接口
    String SCHEDULEOFRESERVATION_URL = BASE_URL
            + "insurances/progress";//预约投保进度

    String COOPERATIVELIST_URL = BASE_URL
            + "cotton-farmers/get-cooperative";//合作社列表
    String COOPERATIVEMEMBERS_URL = BASE_URL
            + "cotton-farmers/member"; //合作社成员
    String COLLCTIVEPOLICY_URL = BASE_URL
            + "collectives";//集体保单
    String MORECOOPERATIVES_URL = BASE_URL
            + "cotton-farmers/more-cooperative";//更多合作社
    String JOINACOOPERATIVE_URL = BASE_URL
            + "cotton-farmers/join-cooperative";// 加入合作社


    String PRODUCTLIST_URL = BASE_URL
            + "products";//产品列表


    String IWANTTOREPORTCASE_URL = BASE_URL
            + "claims/report"; //我要报案
    String INQUIRYREPORTPROGRESS_URL = BASE_URL
            + "claims/progress";//查询报案进度


    String APPLICATIONAMOUNT_URL = BASE_URL
            + "loans/apply"; //申请额度


}
