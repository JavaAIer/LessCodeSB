package com.javaaier.lesscode.common.exception.base;
import org.springframework.util.StringUtils;
import com.javaaier.lesscode.common.utils.MessageUtils;
/**
 * 基础异常
 * 
 * @author javaaier
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    /**
     *
     * @param module 模块名
     * @param code 错误码
     * @param args 错误码对应的参数
     * @param defaultMessage 错误消息
     */
    public BaseException(String module, String code, Object[] args, String defaultMessage)
    {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    /**
     *
     * @param module 模块名
     * @param code 错误码
     * @param args 错误码对应的参数
     */
    public BaseException(String module, String code, Object[] args)
    {
        this(module, code, args, null);
    }

    /**
     *
     * @param module 模块名
     * @param defaultMessage 错误消息
     */
    public BaseException(String module, String defaultMessage)
    {
        this(module, null, null, defaultMessage);
    }
    /**
     *
     * @param code 错误码
     * @param args 错误码对应的参数
     */
    public BaseException(String code, Object[] args)
    {
        this(null, code, args, null);
    }
    /**
     * @param defaultMessage 错误消息
     */
    public BaseException(String defaultMessage)
    {
        this(null, null, null, defaultMessage);
    }

    /**
     * 获取消息
     * @return
     */
    @Override
    public String getMessage()
    {
        String message = null;
        if (!StringUtils.isEmpty(code))
        {
            message = MessageUtils.message(code, args);
        }
        if (message == null)
        {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule()
    {
        return module;
    }

    public String getCode()
    {
        return code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getDefaultMessage()
    {
        return defaultMessage;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "{" + "module='" + module + '\'' + ", message='" + getMessage() + '\'' + '}';
    }
}
