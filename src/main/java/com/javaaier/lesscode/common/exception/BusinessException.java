package com.javaaier.lesscode.common.exception;

/**
 * 业务异常
 * 
 * @author javaaier
 */
public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 错误消息
     */
    protected final String message;

    public BusinessException(String message)
    {
        this.message = message;
    }

    /**
     *
     * @param message 错误消息
     * @param cause　Throwable cause 这里cause要传一个Throwable的子类异常进去么？是引起这个异常的异常，如果这个值是空值，那么这个异常就是源头；如果这个值等于自己，那么这个异常还没被初始化。
     */
    public BusinessException(String message, Throwable cause)
    {
        super(message, cause);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
