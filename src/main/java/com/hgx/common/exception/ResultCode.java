package com.hgx.common.exception;


/**
 * 错误码枚举类
 */
public enum ResultCode {

    /**
     * 公共错误码
     */
    SUC(0, "请求处理成功"),
    SYS_ERROR(-1, "处理失败，系统内部错误"),
    CLUE_ID_IS_NOT_EMPTY(20001, "线索ID不能为空"),
    CLUE_ID_ERROR(20002, "提交线索ID有误"),
    ID_NOT_EXIST_ERROR(20003, "ID不存在"),
    REQUEST_PARAMETERS_ERROR(20004, "请检查参数错误"),


    CLUE_TASK_SYNC_ERROR(30001, "线索任务同步到指挥调度席失败"),
    CHECK_TASK_SYNC_ERROR(30002, "核查任务同步到指挥调度席失败"),
    ASSIST_TASK_SYNC_ERROR(30003, "协查任务同步到指挥调度席失败"),
    SURVEY_TASK_SYNC_ERROR(30004, "调查任务同步到指挥调度席失败"),
    CLUE_TASK_CODE_ERROR(30009, "线索任务编码不存在"),
    ASSIST_TASK_CODE_ERROR(30005, "协查任务编码不存在"),
    INSPECT_TASK_CODE_ERROR(30006, "核查任务编码不存在"),
    SUPER_TASK_CODE_ERROR(30007, "督导任务id不存在"),
    SURVEY_TASK_CODE_ERROR(30008, "调查任务编码不存在"),

    FILE_PATH_ISNULL(40001, "文件路径为空"),
    FILE_ISNULL(40002, "文件为空"),
    FILE_UPLOAD_FAILED(40003, "文件上传失败"),
    FILE_NOT_EXIST(40004, "文件不存在"),
    FILE_DOWNLOAD_FAILED(40005, "文件下载失败"),
    FILE_DELETE_FAILED(40006, "删除文件失败"),
    FILE_SERVER_CONNECTION_FAILED(40007, "文件服务器连接失败"),
    FILE_OUT_SIZE(40008, "文件超过大小"),
    FILE_TYPE_ERROR_IMAGE(40009, "图片类型错误"),
    FILE_TYPE_ERROR_DOC(40010, "文档类型错误"),
    FILE_TYPE_ERROR_VIDEO(40011, "音频类型错误"),
    FILE_TYPE_ERROR_COMPRESS(40012, "压缩文件类型错误"),

    REPEAT_MODELPARAM_ERROR(50001, "重复线索模型传参错误"),
    SIMILART_MODELPARAM_ERROR(50002, "相似线索模型传参错误"),
    REPEAT_ADOPT_ERROR(50003, "重复线索批量采纳出现错误"),
    SUBJECT_MODEL_ERROR(50004, "主题词模型配置出现错误，请先检查主题词模型名字是否为空"),
    FOLDER_INSERT_ERROR(50005, "线索插入收藏夹失败"),
    FOLDER_REPEAT_ERROR(50006, "线索插入收藏夹失败,线索重复"),

    //IDaas业务错误码
    BUSINESS_IDAAS_SUCCESS_ERROR(1100, "错误内容: "),
    BUSINESS_IDAAS_APPLICATION_ERROR(1101, "idaas连接异常，请联系管理员！ "),
    BUSINESS_IDAAS_REQUEST_ERROR(1102, "请求响应结果异常"),
    BUSINESS_IDAAS_EXTERNALID_NULL(1103, "组织机构的ID不能为空"),
    BUSINESS_IDAAS_LOGIN_ERROR(1104, "登陆信息已失效,请重新登陆"),

    //业务错误
    DATAKANBAN_TIMETYPE_ERROR(1106, "没有该时间类型"),
    BUSINESS_EXECUTION_FAILED(1105, "业务执行失败");


    private ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return Integer.valueOf(this.code).toString();
    }

}
