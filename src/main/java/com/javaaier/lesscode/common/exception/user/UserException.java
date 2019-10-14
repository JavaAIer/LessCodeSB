package com.javaaier.lesscode.common.exception.user;


import com.javaaier.lesscode.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author javaaier
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param code 错误码
     * @param args 错误码对应的参数
     */
    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }

}
