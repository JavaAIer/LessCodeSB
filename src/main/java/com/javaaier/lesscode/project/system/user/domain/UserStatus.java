package com.javaaier.lesscode.project.system.user.domain;

/**
 * 用户状态
 * 
 * @author javaaier
 *
 */
public enum UserStatus
{
    /**
     * 正常
     */
    OK("0", "正常"),
    /**
     * 停用
     */
    DISABLE("1", "停用"),
    /**
     * 删除
     */
    DELETED("2", "删除");

    /**
     * 状态编码
     */
    private final String code;
    /**
     * 状态说明
     */
    private final String info;

    /**
     *
     * @param code 状态编码
     * @param info 状态说明
     */
    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    /**
     * 获取状态编码
     * @return
     */
    public String getCode()
    {
        return code;
    }

    /**
     * 获取状态说明
     * @return
     */
    public String getInfo()
    {
        return info;
    }
}
