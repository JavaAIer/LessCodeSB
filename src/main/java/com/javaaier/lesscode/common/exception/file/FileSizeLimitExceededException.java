package com.javaaier.lesscode.common.exception.file;

/**
 * 文件大小限制异常类
 * 
 * @author javaaier
 */
public class FileSizeLimitExceededException extends FileException
{
    private static final long serialVersionUID = 1L;

    /**
     * 默认文件大小
     * @param defaultMaxSize
     */
    public FileSizeLimitExceededException(long defaultMaxSize)
    {
        super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
    }
}
