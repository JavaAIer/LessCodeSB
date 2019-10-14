package com.javaaier.lesscode.common.utils.file;

/**
 * 媒体类型工具类
 *
 * @author javaaier
 */
public class MimeTypeUtils {
    /**
     * png 图片类型
     */
    public static final String IMAGE_PNG = "image/png";
    /**
     * jpg 图片类型
     */
    public static final String IMAGE_JPG = "image/jpg";
    /**
     * jpeg 图片类型
     */
    public static final String IMAGE_JPEG = "image/jpeg";
    /**
     * bmp 图片类型
     */
    public static final String IMAGE_BMP = "image/bmp";
    /**
     * gif 图片类型
     */
    public static final String IMAGE_GIF = "image/gif";
    /**
     * 图片类型
     */
    public static final String[] IMAGE_EXTENSION = {"bmp", "gif", "jpg", "jpeg", "png"};
    /**
     * 动画类型
     */
    public static final String[] FLASH_EXTENSION = {"swf", "flv"};
    /**
     * 媒体类型（动画、音乐、视频）
     */
    public static final String[] MEDIA_EXTENSION = {"swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg",
            "asf", "rm", "rmvb"};

    /**
     * 默认可上传类型
     */
    public static final String[] DEFAULT_ALLOWED_EXTENSION = {
            // 图片
            "bmp", "gif", "jpg", "jpeg", "png",
            // word excel powerpoint
            "doc", "docx", "xls", "xlsx", "ppt", "pptx", "html", "htm", "txt",
            // 压缩文件
            "rar", "zip", "gz", "bz2",
            // pdf
            "pdf"};

    /**
     * 获取文件的类型
     * @param prefix
     * @return
     */
    public static String getExtension(String prefix) {
        switch (prefix) {
            case IMAGE_PNG:
                return "png";
            case IMAGE_JPG:
                return "jpg";
            case IMAGE_JPEG:
                return "jpeg";
            case IMAGE_BMP:
                return "bmp";
            case IMAGE_GIF:
                return "gif";
            default:
                return "";
        }
    }
}
