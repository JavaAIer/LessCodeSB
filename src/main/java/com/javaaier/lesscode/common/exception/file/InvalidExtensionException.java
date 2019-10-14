package com.javaaier.lesscode.common.exception.file;

import java.util.Arrays;
import org.apache.commons.fileupload.FileUploadException;

/**
 * 文件上传类型错误异常类
 * 
 * @author javaaier
 */
public class InvalidExtensionException extends FileUploadException
{
    private static final long serialVersionUID = 1L;

    /** 允许的扩展名 */
    private String[] allowedExtension;
    /** 文件扩展名 */
    private String extension;
    /** 文件名 */
    private String filename;

    /**
     *
     * @param allowedExtension 允许的扩展名
     * @param extension 实际的扩展名
     * @param filename 文件名
     */
    public InvalidExtensionException(String[] allowedExtension, String extension, String filename)
    {
        super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : [" + Arrays.toString(allowedExtension) + "]");
        this.allowedExtension = allowedExtension;
        this.extension = extension;
        this.filename = filename;
    }


    public String[] getAllowedExtension()
    {
        return allowedExtension;
    }

    public String getExtension()
    {
        return extension;
    }

    public String getFilename()
    {
        return filename;
    }

    /**
     * 图片类型错误异常
     */
    public static class InvalidImageExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        /**
         *
         * @param allowedExtension 允许的扩展名
         * @param extension 实际的扩展名
         * @param filename 文件名
         */
        public InvalidImageExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }

    /**
     * Flash文件类型错误异常
     */
    public static class InvalidFlashExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        /**
         *
         * @param allowedExtension 允许的扩展名
         * @param extension 实际的扩展名
         * @param filename 文件名
         */
        public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }

    /**
     * 错误的多媒体文件扩展名异常
     */
    public static class InvalidMediaExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        /**
         *
         * @param allowedExtension 允许的扩展名
         * @param extension 实际的扩展名
         * @param filename 文件名
         */
        public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }
}
