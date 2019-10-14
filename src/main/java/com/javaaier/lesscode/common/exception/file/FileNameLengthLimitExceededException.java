package com.javaaier.lesscode.common.exception.file;

/**
 * 文件名称超长限制异常类
 * 
 * @author javaaier
 */
public class FileNameLengthLimitExceededException extends FileException
{
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param defaultFileNameLength 默认文件名长度
     */
    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
