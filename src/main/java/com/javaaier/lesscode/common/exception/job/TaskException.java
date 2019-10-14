package com.javaaier.lesscode.common.exception.job;

/**
 * 计划策略异常
 *
 * @author javaaier
 */
public class TaskException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * 错误代码
     */
    private Code code;

    /**
     * @param msg  错误消息
     * @param code 错误代码
     */
    public TaskException(String msg, Code code) {
        this(msg, code, null);
    }

    /**
     * @param msg      错误消息
     * @param code     错误代码
     * @param nestedEx 内部异常
     */
    public TaskException(String msg, Code code, Exception nestedEx) {
        super(msg, nestedEx);
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

    public enum Code {
        /**
         * 任务已存在
         */
        TASK_EXISTS,
        /**
         * 没有任务
         */
        NO_TASK_EXISTS,
        /**
         * 任务已经启动
         */
        TASK_ALREADY_STARTED,
        /**
         * 未知
         */
        UNKNOWN,
        /**
         * 配置错误
         */
        CONFIG_ERROR,
        /**
         * 任务节点不可用
         */
        TASK_NODE_NOT_AVAILABLE
    }
}