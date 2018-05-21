package cn.guzt.boottest.base.vo;

import java.io.Serializable;

/**
 * 接口返回通用实体
 * @author guzt
 */
public class ResponseVo<T> implements Serializable
{
    private static final long serialVersionUID = 161062865218482240L;

    public static final String SUCCESS = "0";

    public static final String SUCCESS_MSG = "SUCCESS";

    public static final String FAIL = "-1";

    public static final String FAIL_MSG = "FAIL";

    /**
     * 用于返回无data情况下的ResponseVo对象
     */
    private static class NoBody implements Serializable{
        private static final long serialVersionUID = -5050381407741914575L;
    }


    /**
     * 消息状态码
     */
    private String code;

    /**
     * 消息简述
     */
    private String message;

    /**
     * 响应消息体
     */
    private T data;

    /**
     * 默认构造 创建 ResponseVo 的实例.
     */
    public ResponseVo()
    {
        super();
    }

    /**
     * 创建 ResponseVo 的实例.
     * @param code 消息码
     * @param message 消息信息
     */
    public ResponseVo(String code, String message)
    {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 创建 ResponseVo 的实例.
     * @param code 消息码
     * @param message 消息信息
     * @param data 消息体
     */
    public ResponseVo(String code, String message, T data)
    {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 响应操作成功默认消息,无data数据
     * @return ResponseVo
     */
    public static  ResponseVo<NoBody> success()
    {
        return new ResponseVo<>(SUCCESS, SUCCESS_MSG, null);
    }

    /**
     * 响应操作成功自定义消息,无data数据
     * @param message 消息信息
     * @return ResponseVo
     */
    public static  ResponseVo<NoBody> success(String message)
    {
        return new ResponseVo<>(SUCCESS, message, null);
    }

    /**
     * 响应操作成功默认消息,包含data数据
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> success(T data)
    {
        return new ResponseVo<T>(SUCCESS, SUCCESS_MSG, data);
    }

    /**
     * 响应操作成功自定义消息,包含data数据
     * @param message 消息信息
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> success(String message, T data)
    {
        return new ResponseVo<T>(SUCCESS, message, data);
    }

    /**
     * 响应操作成功默认消息,无data数据
     * @return ResponseVo
     */
    public static  ResponseVo<NoBody> fail()
    {
        return new ResponseVo<>(FAIL, FAIL_MSG, null);
    }

    /**
     * 响应操作失败消息.
     * @param message 消息信息
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> fail(String message)
    {
        return new ResponseVo<T>(FAIL, message, null);
    }

    /**
     * 响应操作成功默认消息,包含data数据
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> fail(T data)
    {
        return new ResponseVo<T>(FAIL, FAIL_MSG, data);
    }

    /**
     * 响应操作成功自定义消息,包含data数据
     * @param message 消息信息
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> fail(String message, T data)
    {
        return new ResponseVo<T>(FAIL, message, data);
    }

    /**
     * 自定义消息，无data数据
     * @param code 消息码
     * @param message 消息信息
     * @return ResponseVo
     */
    public static ResponseVo<NoBody> create(String code, String message)
    {
        return new ResponseVo<>(code, message);
    }

    /**
     * 自定义消息，包含data数据
     * @param code 消息码
     * @param message 消息信息
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> create(String code, String message, T data)
    {
        return new ResponseVo<T>(code, message, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
