package com.lianghuawang.cottonfarmer.utils;

/**
 * 常量配置工具类
 */
public class ConstantUtil {
    /**----------------------登录LoginActivity、注册RegisterActivity-----------------------------**/

    public static final int LOGIN_CAPTCHA_NUMBER = 60;//验证码倒计时时间
    public static final String INPUT_PHONE = "请输入手机号";
    public static final String INPUT_CORRECT_PHONE = "请输入正确的手机号";
    public static final String INPUT_CAPTCHA = "请输入验证码";
    //从注册跳转到个人信息页面
    public static final String INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING = "INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING";
    public static final int INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT = 100;

    public static final String CAPTCHA_ONSUCCEED = "验证码发送成功";
    public static final String CAPTCHA_ERROR = "验证码发送失败";

    public static final String REGISTER_NEXT = "下一步";//注册时，填写资料的下一步

    public static final String SAVE_SUCCEED = "保存成功";

    /**
     * ---------------------------------个人信息----------------------------------------
     */
    public static final String PERSONAL = "PERSONAL";//key
    public static final String PERSONAL_HEAD = "PERSONAL_HEAD";
    //从我的模块跳转到个人信息模块
    public static final String INTENT_MY_JUMP_PERSONALINFORMATION_STRING = "INTENT_MY_JUMP_PERSONALINFORMATION_STRING";
    public static final int INTENT_MY_JUMP_PERSONALINFORMATION_INT = 101;

    /** 基础信息 **/
    public static final String ESSENTIAL_INFORMATION_KEY = "ESSENTIAL_INFORMATION";//基本信息key
    public static final String ESSENTIAL_INFORMATION_ISSAVE = "ESSENTIAL_INFORMATION_ISSAVE";//是否保存基本信息

    public static final String ESSENTIAL_INFORMATION_USERNAME = "ESSENTIAL_INFORMATION_USERNAME";//姓名
    public static final String ESSENTIAL_INFORMATION_USERNAME_NULL = "请输入姓名";//姓名

    public static final String ESSENTIAL_INFORMATION_SEX = "ESSENTIAL_INFORMATION_SEX";//性别

    public static final String ESSENTIAL_INFORMATION_NATION = "ESSENTIAL_INFORMATION_NATION";//民族
    public static final String ESSENTIAL_INFORMATION_NATION_NULL = "请选择民族";//民族

    public static final String ESSENTIAL_INFORMATION_IDCARD = "ESSENTIAL_INFORMATION_IDCARD";//身份证
    public static final String ESSENTIAL_INFORMATION_IDCARD_NULL = "请输入身份证号码";//身份证

    public static final String ESSENTIAL_INFORMATION_PHONE = "ESSENTIAL_INFORMATION_PHONE";//联系方式
    public static final String ESSENTIAL_INFORMATION_PHONE_NULL = "请输入联系电话";//联系方式

    public static final String ESSENTIAL_INFORMATION_ADDRESS = "ESSENTIAL_INFORMATION_ADDRESS";//联系地址
    public static final String ESSENTIAL_INFORMATION_ADDRESS_NULL = "请输入家庭地址";//联系地址

    public static final String ESSENTIAL_INFORMATION_ZIP = "ESSENTIAL_INFORMATION_ZIP";//邮编
    public static final String ESSENTIAL_INFORMATION_ZIP_NULL = "请输入邮编";//邮编

    public static final String ESSENTIAL_AUTHENTICATION = "ESSENTIAL_AUTHENTICATION";//是否实名认证

    /** 种植信息 **/
    public static final String PLANTING_KEY = "PLANTING_KEY";//种植信息key
    public static final String PLANTING_ISSAVE = "PLANTING_ISSAVE";//种植信息是否保存

    public static final String PLANTING_AREA = "PLANTING_AREA";//种植地址
    public static final String PLANTING_AREA_NULL = "请选择种植地址";//种植地址

    public static final String PLANTING_ACRES = "PLANTING_ACRES";//种植亩数
    public static final String PLANTING_ACRES_NULL = "请输入种植亩数";//种植亩数

    public static final String PLANTING_KGS = "PLANTING_KGS";//平均产量
    public static final String PLANTING_KGS_NULL = "请输入平均产量";//平均产量

    public static final String PLANTING_NUMBER = "PLANTING_NUMBER";//地块数量
    public static final String PLANTING_NUMBER_NULL = "请输入地块数量";//地块数量

    public static final String PLANTING_DIVISION = "PLANTING_DIVISION";//省/师代码
    public static final String PLANTING_GROUP = "PLANTING_GROUP";//市/团代码
    public static final String PLANTING_EVEN = "PLANTING_EVEN";//县/连代码
    public static final String PLANTING_TOWNSHIP = "PLANTING_TOWNSHIP";//乡代码
    public static final String PLANTING_VILLAGE = "PLANTING_VILLAGE";//村代码
    public static final String PLANTING_AREA_TYPE = "PLANTING_AREA_TYPE";//区域类型

    /** 权属证明 **/


    /** 购买保险记录 **/
    public static final String INSURANCE_KEY = "INSURANCE_KEY";//购买保险记录险种的key

    public static final String INSURANCE_PRODUCT_TYPE = "INSURANCE_PRODUCT_TYPE";//险种的名称


    /** 银行卡 **/
    public static final String BANK_USERNAME = "BANK_USERNAME";//持卡人
    public static final String BANK_USERNAME_NULL = "请输入持卡人姓名";

    public static final String BANK_CARDID = "BANK_CARDID";//卡号
    public static final String BANK_CARDID_NULL = "请输入卡号";

    public static final String BANK_PHONE = "BANK_PHONE";//银行预留手机号
    public static final String BANK_PHONE_NULL = "请输入银行预留手机号";

    public static final String BANK_ADDRESS = "BANK_ADDRESS";//开户行地区
    public static final String BANK_ADDRESS_NULL = "请选择开户行地区";

    public static final String BANK_ADDRESS_DETAIL = "BANK_ADDRESS_DETAIL";//详细地址
    public static final String BANK_ADDRESS_DETAIL_NULL = "请输入银行详细地址";//详细地址



    public static final String HEAD_LINE = "head_line";
    public static String tokenKey = "Authorization";
    /**
     * ---------------保险模块-------------------
     */

    public static final String AGRICULTURE = "AGRICULTURE";

    public static final String TAG1 = "TAG1";

    public static final String TAG2 = "TAG2";

    public static final String AGRICLURAL = "AGRICLURAL";

    public static final String TAG3 = "TAG3";

    public static final String TAG4 = "TAG4";

    public static final String TAG5 = "TAG5";

    public static final String TAG6 = "TAG6";

    public static final String TAG7 = "TAG7";

    public static final String TAG8 = "TAG8";

    public static final String INSURANCE = "INSURANCE";//传递订单详情key

    public static final String INSURANCE_ID = "INSURANCE_TYPE";//保险类型

    public static final String  INSURANCE_ACT = "INSURANCE_ACT";//保险条例

    /**
     * -------------------订单模块
     */
    public static final int ALL = 0;//全部
    public static final int NON_PAYMENT = 1;//未付款
    public static final int PAYMENT_HAS_BEEN = 2;//已付款
    public static final int HAS_BEEN_COMPLETED = 3;//已完成


    /**---------------------------------数据库-----------------------------------**/


    /**
     * ---------------------------------SharedPreferencesUtil-----------------------------------
     **/
    //启动页
    public static final String STARTPAGE = "STARTPAGE";//启动页key
    public static final String ISSTART = "ISSTART";//是否已启动
    //登录模块
    public static final String LOGINSP = "LOGIONSP";//登录状态key
    public static final String LOGINSTATE = "LOGINSTATE";//是否登录
    public static final String LOGINTOKEN = "TOKEN";//Token



    /**---------------------------------Intent-----------------------------------**/
    public static final String INTENTTOKEN = "intent_token";

    /**---------------------------------Intent-----------------------------------**/
    public static final String NETERROR = "网络连接失败";

    /**---------------------------------新闻-----------------------------------**/



    /** ----------------------DialogUtil-----------------------**/

    public static final int POSITIVE = -1;//PositiveButton
    public static final int NEGATIVE = -2;//NegativeButton
}
