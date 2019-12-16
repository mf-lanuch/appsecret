package com.app.secret.core;

public enum BaseExceptionEnum {

    USER_CODE_NOT_FOUND(1_00_001, "USER_CODE_NOT_FOUND", "用户账号错误"),
    USER_CODE_CAN_NOT_BE_NULL(1_00_002, "USER_CODE_CAN_NOT_BE_NULL", "用户名不能为空"),
    USER_NAME_CAN_NOT_BE_NULL(1_00_002, "USER_NAME_CAN_NOT_BE_NULL", "昵称不能为空"),
    USER_PSWD_CAN_NOT_BE_NULL(1_00_003, "USER_PSWD_CAN_NOT_BE_NULL", "密码不能为空"),
    USER_PSWD_IS_NOT_CORRECT(1_00_004, "USER_PSWD_IS_NOT_CORRECT", "密码不正确"),
    USER_UUID_CAN_NOT_BE_NULL(1_00_005, "USER_UUID_CAN_NOT_BE_NULL", "用户ID不能为空"),
    USER_ROLE_CAN_NOT_BE_NULL(1_00_005, "USER_ROLE_CAN_NOT_BE_NULL", "用户角色不能为空"),


    DELETE_USER_ROLE_FAIL(2_00_001, "DELETE_USER_ROLE_FAIL", "更新用户角色失败"),
    UN_KNOWN_ERROR(9_99_999, "UN_KNOWN_ERROR", "位置错误");

    private int code;

    private String msg;

    private String tip;


    BaseExceptionEnum(int code, String tip, String msg) {
        this.code = code;
        this.msg = msg;
        this.tip = tip;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getTip() {
        return tip;
    }

    public static BaseExceptionEnum getErrorCode(String tips) {
        for (BaseExceptionEnum baseErrorCode: values()) {
            if (tips.toUpperCase().equals(baseErrorCode.tip.toUpperCase())) {
                return baseErrorCode;
            }
        }
        return BaseExceptionEnum.UN_KNOWN_ERROR;
    }

    public static BaseExceptionEnum fromValue(int v) {
        BaseExceptionEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            BaseExceptionEnum c = var1[var3];
            if (c.code == v) {
                return c;
            }
        }
        return  BaseExceptionEnum.UN_KNOWN_ERROR;
    }
}
