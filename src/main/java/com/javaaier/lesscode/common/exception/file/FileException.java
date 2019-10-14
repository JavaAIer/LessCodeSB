package com.javaaier.lesscode.common.exception.file;

import com.javaaier.lesscode.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author javaaier
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param code 错误码
     * @param args 错误码对应的参数
     */
    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
