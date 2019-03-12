package client.com.baselibs.constants;

import client.com.baselibs.BuildConfig;

/**
 * Created on 2018/1/30 17:22.
 * <p>
 * 常量
 *
 * @author pan
 * @version 1.0
 */

public interface AppConfig {
    /***************************切换环境需要配置start****************************************/

    /**
     * 是否是正式环境的接口
     */
    boolean IS_RELEASE = false;

    /*****************************切换环境需要配置end**************************************/

    /**
     * base_url
     */

    //测试uc
    String BASE_URL_UC_TEST = "http://47.98.227.240:8085";

    //正式uc
    String BASE_URL_UC_RELEASE = "https://api_se_uc.bzmaster.cn";

    //测试dc
    String BASE_URL_DC_TEST = "http://47.98.227.240:8084";

    //正式dc
    String BASE_URL_DC_RELEASE = "https://api_se_dc.bzmaster.cn";


    //uc
    String BASE_URL_UC = IS_RELEASE ? BASE_URL_UC_RELEASE : BASE_URL_UC_TEST;

    //dc
    String BASE_URL_DC = IS_RELEASE ? BASE_URL_DC_RELEASE : BASE_URL_DC_TEST;


    boolean DEBUG = BuildConfig.DEBUG;

    //报表是否是是测试的
    String FBN_URL = (IS_RELEASE) ? "fnb" : "fnb_test";

    /**
     * 保险算费
     */
    String TEST_INSURANCE_FEE = "https://agent-ent.iyobee.com/login?code=bhcxt";
    /**
     * 保险算费
     */
    String INSURANCE_FEE = BASE_URL_UC + "/AccoutModule/Module/Module/GetModuleUrl";
    /**
     * 联系方式接口
     */
    String CONTACT_METHOD = BASE_URL_UC + "/AccoutModule/Module/Module/GetUsrMobileList";
    /**
     * 登录login
     */
    String LOGIN_URL = BASE_URL_UC + "/AccoutModule/Usr/AppLogin";
    /**
     * 获取用户信息
     */
    String GET_INFO = BASE_URL_UC + "/AccoutModule/Usr/GetInfo";
    /**
     * 重置密码
     */
    String RESET_PWD = BASE_URL_UC + "/AccoutModule/Usr/UpdatePwd";
    /**
     * 获取服务页面banner
     * 端口号：8084
     */
    String GET_BANNER = BASE_URL_DC + "/FRBao/Head/GetHeadList";
    /**
     * 发送验证码
     */
    String SEND_MOBILE_CODE = BASE_URL_UC + "/AccoutModule/Usr/SendMobileCode";
    /**
     * 检查验证码
     */
    String CHECK_CODE = BASE_URL_UC + "/AccoutModule/Usr/CheckCode";

    /**
     * 获根据类型获取集团下的主数据
     * 端口号：8084
     */
    String GET_SALESACTIVITYLIST = BASE_URL_DC + "/FRBao/SalesActivity/GetSalesActivityList";

    /**
     * 获根据类型获取集团下的主数据
     * 端口号：8084
     */
    String GET_BASEVALUEBYTYPE = BASE_URL_DC + "/MdmBaseValue/GetBaseValueByType";

    /**
     * 客户管理搜索列表
     */
    String CUSTOMER_MANAG_LIST = BASE_URL_DC + "/FRBao/CusManager/GetCusLit";
    /**
     * 客户详情
     */
    String CUSTOMER_DETAIL = BASE_URL_DC + "/FRBao/CusManager/CusDetail";
    /**
     * 车辆详情
     */
    String GET_VHICLE_INFO = BASE_URL_DC + "/FRBao/CusManager/GetCarDetail";
    /**
     * 新增或者编辑客户信息
     */
    String ADD_CUS = BASE_URL_DC + "/FRBao/CusManager/AddCus";

    /**
     * 获取提醒列表
     */
    String GET_REMIND_LIST = BASE_URL_DC + "/FRBao/CusManager/GetNoticeList";
    /**
     *取消提醒
     * */
    String CANCLE_NOTICE = BASE_URL_DC + "/FRBao/CusManager/CancleNotice";

    /**
     * 新增提醒列表
     */
    String ADD_REMIND_LIST = BASE_URL_DC + "/FRBao/CusManager/AddNotice";
    /**
     * 获取客户名下车辆列表
     */
    String CUS_CAR_LIST = BASE_URL_DC + "/FRBao/CusManager/GetCusCarList";

    /**
     * 营销活动详情
     */
    String GETCRMACTMSTRBYID = BASE_URL_DC + "/FRBao/SalesActivity/GetCrmActMstrById";

    /**
     * 海报保存和分享
     */
    String SAVE_SHARE_POSTER = BASE_URL_DC + "/FRBao/SalesActivity/SaveShareBtnClick";
    /**
     * 新车商城列表接口
     */
    String GETCARLIST = BASE_URL_DC + "/FRBao/NewCarStore/GetCarList";
    /**
     * 新车商城我要购车
     */
    String IWANTNEWCAR = BASE_URL_DC + "/FRBao/NewCarStore/IWantNewCar";
    /**
     * 我要新车需求列表
     */
    String IWANTNEWCARLIST = BASE_URL_DC + "/FRBao/NewCarStore/IWantNewCarList";
    /**
     * 新车商城详情页
     */
    String SINGLENEWCARDETAIL = BASE_URL_DC + "/FRBao/NewCarStore/GetNewCarDetail";
    /**
     * 配件采购
     */
    String SINGLENEWPartsETAIL = BASE_URL_DC + "/FRBao/PurchasParts/GetScmDetail";
    /**
     * 获取保险公司
     */
    String GET_INS_COMPANY = BASE_URL_DC + "/FRBao/CusManager/GetInsCompany";
    /**
     * 新增车辆
     */
    String ADD_CAR = BASE_URL_DC + "/FRBao/CusManager/AddCar";
    /**
     * 客户工单记录
     */
    String GET_SO_LIST = BASE_URL_DC + "/FRBao/CusManager/GetSoList";
    /**
     * 工单管理列表
     */
    String MANAGE_WORK_RECORD_LIST = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/GetSoList";
    /**
     * 工单詳情
     */
    String GET_SO_DETAIL = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/GetSoDetail";
    /**
     * 服务顾问
     */
    String GET_SERVICE_CONSULTANT = BASE_URL_DC + "/FRBao/FrbInSurance/GetAllServiceNameList";
    /**
     * 更新工单状态
     */
    String UPDATE_SO_STATUS = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/UpdateSoStatus";
    /**
     * 更新工单
     */
    String UPDATE_WORK = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/UpdateSo";
    /**
     * 收款
     */
    String RECEIPT_MONEY = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/FrbWkReceipt";
    /**
     * 获取商品列表
     */
    String GET_GOOD_LIST = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/GetGoodsList";

    /**
     * 获取车辆列表(工单模块)
     */
    String WORK_GET_CARLIST = BASE_URL_DC + "/FRBao/FrbWorkOrderManager/GetCarList";

    /**
     * 知识分类列表
     */
    String KNOWLEDGE_CATEGORY_TYPE = BASE_URL_DC + "/FRBao/FrbKbmKnowLedge/GetKonwLedgeBaseValue";
    /**
     * 适用角色
     */
    String ADAPT_ROLE_TYPE = BASE_URL_DC + "/FRBao/FrbKbmKnowLedge/GetKonwLedgeRoleValue";
    /**
     * 知识库查询条件
     */
    String GET_KNOWLEDGECLASS_LIST = BASE_URL_DC + "/FRBao/FrbKbmKnowLedge/GetKonwLedgeClassList";

    /**
     * 知识库详情
     * GET请求
     */
    String GET_KNOWLEDGE_INFO = BASE_URL_DC + "/FRBao/FrbKbmKnowLedge/GetKonwledgeInfo";
    /**
     * 知识库收藏
     */
    String KNOWLEDGE_COLLECT = BASE_URL_DC + "/FRBao/FrbKbmKnowLedge/KonwledgeCollection";
    /**
     * 知识库我的收藏
     */
    String MY_KNOWLEDGE_COLLECT = BASE_URL_DC + "/FRBao/FRBao/FrbKbmKnowLedge/MyKonwledgeCollection";
    /**
     * 保单列表页面
     */
    String GET_INS_LIST = BASE_URL_DC + "/FRBao/FrbInSurance/GetinsList";
    /**
     * 客户保单列表页面
     */
    String GET_CUS_INS_LIST = BASE_URL_DC + "/FRBao/CusManager/GetCusInsList";
    /**
     * 保单详情页面
     */
    String GET_INS_INFO_BYID = BASE_URL_DC + "/FRBao/FrbInSurance/GetinsInfoById";
    /**
     * 修改保单
     */
    String ADD_OR_UPDATE_INSINFO = BASE_URL_DC + "/FRBao/FrbInSurance/AddOrUpdateInsInfo";

    /**
     * 配件采购列表
     */
    String GET_PURCGASPARTS_LIST = BASE_URL_DC + "/FRBao/PurchasParts/GetGoodsList";
    /**
     * 配件采购列表(妥谱汽车)
     */
    String TP_GET_PURCGASPARTS_LIST = BASE_URL_DC + "/TopUnion/TopBoutique/GetTopGoodsList";

    /**
     * 配件--立即下单
     */
    String PLACE_ORDER = BASE_URL_DC + "/FRBao/PurchasParts/PlaceAnOrder";
    /**
     * 配件--
     * 我要配件
     */
    String WANT_PARTS = BASE_URL_DC + "/FRBao/PurchasParts/IWantAnOrder";
    /**
     * 配件--
     * 我的需求列表
     */
    String MY_REQUEST_LIST = BASE_URL_DC + "/FRBao/PurchasParts/IWantOrderList";

    /**
     * 品牌车型
     */
    String GET_CAR_BRAND = BASE_URL_DC + "/Common/GoodsClass/GetGoodsClassList";


    /****赋能宝--运营端**************************/
    /**
     * 获取任务列表
     */

    String GET_TASK_LIST = BASE_URL_DC + "/FRBao/Task/GetTaskListByPage";
    /**
     * 获取任务列表
     */

    String GET_TASK_INFO = BASE_URL_DC + "/FRBao/Task/GetSingleInfo";
    /**
     * 任务--
     * 保存，提交并且完成
     */

    String UPDATE_TASK_BYID = BASE_URL_DC + "/FRBao/Task/UpdateTaskById";
    /**
     * 意见反馈
     */
    String FEED_BACK = BASE_URL_DC + "/FRBao/FrbMy/SendFeedBack";


    /**
     * 全部车间 http://47.98.227.240:8084/EgateModule/GetWorkShopList
     */
    String GETWORKSHOPLIST = BASE_URL_DC + "/Egate/EgateModule/GetWorkShopList";
    /**
     * 车间记录列表
     */
    String GETALLCARRECORDLIST = BASE_URL_DC + "/Egate/EgateModule/GetAllCarRecordList";
    /**
     * 车间异常车辆列表
     */
    String GETALLCARNORMALLIST = BASE_URL_DC + "/Egate/EgateModule/GetAllCarNormalList";
    /**
     * 车间异常车辆详情
     */
    String GETNORMALINFO = BASE_URL_DC + "/Egate/EgateModule/GetNormalInfo";
    /**
     * 车间异常车辆说明
     */
    String UPDATENONLICETRMK = BASE_URL_DC + "/Egate/EgateModule/UpdateNonlicetRmk";
    /**
     * 发放卡券
     */
    String PRESENTCOUPON = BASE_URL_DC + "/Egate/SeCoupon/PresentCoupon";
    /**
     * 卡券列表
     */
    String GETCOUPONLIST = BASE_URL_DC + "/Egate/SeCoupon/GetCouponList";
    /**
     * 授权列表
     */
    String GETAUTHLIST = BASE_URL_DC + "/Egate/SeOutAuth/GetAuthList";
    /**
     * 授权审批操作
     */
    String AUTHOPER = BASE_URL_DC + "/Egate/SeOutAuth/AuthOper";
    /**
     * 授权详情
     */
    String GETAUTHINFO = BASE_URL_DC + "/Egate/SeOutAuth/GetAuthInfo";
    /**
     * 获取进出场记录
     */
    String GETPASSRECORDLIST = BASE_URL_DC + "/Egate/SePassRecord/GetPassRecordlist";
    /**
     * 场内车辆列表
     */
    String GETNOTOUTLIST = BASE_URL_DC + "/Egate/SePark/GetNotOutList";
    /**
     * 场内车辆详情 /Egate/SePark/GetNotOutDetail
     */
    String GETNOTOUTDETAIL = BASE_URL_DC + "/Egate/SePark/GetNotOutDetail";
    /**
     * 开工单
     */
    String EGATEPARKBILL = BASE_URL_DC + "/Egate/SePark/EgateParkBill";
    /**
     * 结算
     */
    String EGATESOPAY = BASE_URL_DC + "/Egate/SePark/EgateSoPay";
    /**
     * 获取用户所在闸道列表
     */
    String GETEGATEGATLIST = BASE_URL_DC + "/Egate/SePark/GetEgateGatList";
    /**
     * 车辆补录
     */
    String EGATEVEHICLECOLLECTION = BASE_URL_DC + "/Egate/SePark/EgateVehicleCollection";
    /**
     * 车牌号或是vin码维护
     */
    String EGATEUPDATECARIDORVIN = BASE_URL_DC + "/Egate/SePark/EgateUpdateCarIdOrVin";
    /**
     * 获取订单业务类型
     */
    String GETSOTYPELIST = BASE_URL_DC + "/Common/CommonSo/GetSoTypeList";
    /**
     * 获取监控列表
     */
    String GETMONITORINGLIST = BASE_URL_DC + "/Egate/SeMonitoring/GetMonitoringList";
    /**
     * 忽略任务
     */
    String MONITORIGNORE = BASE_URL_DC + "/Egate/SeMonitoring/MonitorIgnore";
    /**
     * 关闭任务
     */
    String MONITORCLOSE = BASE_URL_DC + "/Egate/SeOutAuth/MonitorClose";
    /**
     * 确认客户目的
     */
    String MONITORINGUPDATEPURPOSE = BASE_URL_DC + "/Egate/SeMonitoring/MonitoringUpdatePurpose";

    /**
     * 修改车牌号
     */
    String MONITORINGUPDATECARID = BASE_URL_DC + "/Egate/SeMonitoring/MonitoringUpdateCarId";
    /**
     * 申请出场授权
     */
    String APPLY = BASE_URL_DC + "/Egate/SeOutAuth/Apply";

    /**
     * 索取电子放行单
     */
    String OBTAIN_ELEC_PASS_SINGLE = BASE_URL_DC + "/Egate/SeMonitoring/ObtainElectronicPassSingle";
    /**
     * 更新车架号
     */
    String UPDATEMONITORINGVIN = BASE_URL_DC + "/Egate/SeOutAuth/UpdateMonitoringVin";
    /**
     * 试驾车列表POST
     */
    String GETTESTDRIVELIST = BASE_URL_DC + "/Egate/SeFEU/GettestDriveList";
    /**
     * 试驾车详情GET
     */
    String GETTESTDRIVEDETAILS = BASE_URL_DC + "/Egate/SeFEU/GettestDriveDetail";
    /**
     * 试驾历史
     */
    String TESTDRIVEHISTORY = BASE_URL_DC + "/Egate/SeFEU/TestDriveHistory";
    /**
     * 试驾登记
     */
    String TESTDRIVEREG = BASE_URL_DC + "/Egate/SeFEU/TestDriveReg";
    /**
     * 取消试驾
     */
    String CANCELTESTDRIVE = BASE_URL_DC + "/Egate/SeFEU/CancelTestDrive";
    /**
     * 结束试驾
     */
    String FINISHTESTDRIVE = BASE_URL_DC + "/Egate/SeFEU/FinishTestDrive";
    /**
     * 维修车
     */
    String REPAIR_CAR = BASE_URL_DC + "/Egate/SeTrialMaintenanceVehicle/GetTrialNotOutList";
    /**
     * 登记试车
     */
    String REGIT_TRY_CAR = BASE_URL_DC + "/Egate/SeTrialMaintenanceVehicle/TrialLock";
    /**
     * 取消试车
     */
    String CANCEL_TRY_CAR = BASE_URL_DC + "/Egate/SeTrialMaintenanceVehicle/TrialUnlock";
    /**
     * 维修试车登记信息列表
     */
    String TRIAL_LOCK_LIST = BASE_URL_DC + "/Egate/SeTrialMaintenanceVehicle/TrialLockList";

    /**
     * 登记历史
     */
    String TRIAL_HISTORY = BASE_URL_DC + "/Egate/SeTrialMaintenanceVehicle/TrialHistory";
    /**
     * 发放电子放行单
     */
    String ELEC_FORM = BASE_URL_DC + "/Egate/SeCoupon/ElectronicsPassSingle";
    /**
     * 提前申请出场授权
     * */
    String ADVANCE_APPLY = BASE_URL_DC + "/Egate/SeMonitoring/AdvanceMonitoringApply";
    /**
     * 是否启用电子放行单(true:启用/false:未启用)
     * */
    String IS_ENABLE_RELEASELIST = BASE_URL_DC + "/Egate/SePark/IsEnabledReleaseList";

    /**
     * 获取记录日志
     */
    String RECORD_LOG = BASE_URL_DC + "/Egate/SeFEU/GetTestDriveLog";

    /***
     *智能报表h5
     */
    /**
     * 客户消费
     */
    String CUS_CUSTOMER = "http://114.55.2.156:8888/WebReport/ReportServer?reportlet=/" + FBN_URL + "/cus_consume.cpt&op=h5";
    /**
     * 配件统计
     */
    String PARTS_STASTICS = "http://114.55.2.156:8888/WebReport/ReportServer?reportlet=/" + FBN_URL + "/Goods.cpt&op=h5";
    /**
     * 保单统计
     */
    String POLICY_STASTICS = "http://114.55.2.156:8888/WebReport/ReportServer?reportlet=/" + FBN_URL + "/Insurance.cpt&op=h5";
    /**
     * 工单统计
     */
    String WORK_STASTICS = "http://114.55.2.156:8888/WebReport/ReportServer?reportlet=/" + FBN_URL + "/Order.cpt&op=h5";

    /**
     * 服务统计
     */
    String SERVICE_STASTICS = "http://114.55.2.156:8888/WebReport/ReportServer?reportlet=/" + FBN_URL + "/Service.cpt&op=h5";


    //正式
    public static final String INSURANCE_FORMAL= "https://api.bzmaster.cn:4437/";//保险
    public static final String IDS_URL_FORMAL   = "https://api_uc.bzmaster.cn:4431/";//uc(账号)
    public static final String IDS_FORMAL       = "https://api_dc.bzmaster.cn:4432/";//dc

    //测试
    public static final String INSURANCE_TEST = "https://test-api.bzmaster.cn/";//";//保险
    public static final String IDS_URL_TEST  = "http://47.98.227.240:8083/";//";//uc(测试账号)
    public static final String IDS_TEST       = "http://47.98.227.240:8082/";//dc

    public static final String TOKENINSURANCE       = "https://uissit.insaic.com:9443/services/security/getApiToken/";//企业token
    public static final String TOKENINSURANCEUSER       = "https://uissit.insaic.com:9443/services/security/getUserToken/";//用户token
    public static final String TOKENINSURANCEPARAM       = "yingzhong-test/a1ec945d42qazws";


    //通过AppSwitch来切换正式和测试接口

    //上汽h5 token(正式1 测试0)
    public static final int IsForaml=IS_RELEASE ? 1:0;
    //保险
    public static  final String INSURANCE=IS_RELEASE ? INSURANCE_FORMAL:INSURANCE_TEST;
    //uc(账号)
    public static final String IDS_URL   = IS_RELEASE ? IDS_URL_FORMAL:IDS_URL_TEST;
    //dc
    public static final String IDS   = IS_RELEASE ? IDS_FORMAL:IDS_TEST;

    //保险
    interface Insurance {
        //开单页面获取信息
        public static final String GETVIEWINFOV2             = INSURANCE + "v2.0/Insurance/Billling/GetViewInfo";
        public static final String GETVIEWINFOV3             = INSURANCE + "v3.0/Insurance/BilllingV3/GetViewInfo";
    }


    public static final String YONGAN_INS_PAY_URL="https://test-mmall.bzmaster.cn/peceivables?userId=ya2019&pawd=ya2019";

}
