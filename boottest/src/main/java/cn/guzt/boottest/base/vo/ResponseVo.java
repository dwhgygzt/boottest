package cn.guzt.boottest.base.vo;

import java.io.Serializable;

/**
 * 接口返回通用实体
 * @author Administrator
 * @param <T> 响应消息体
 */
public class ResponseVo<T> implements Serializable
{
    private static final long serialVersionUID = 161062865218482240L;

    public static final String SUCCESS = "0";

    public static final String SUCCESS_MSG = "SUCCESS";

    public static final String FAIL = "-1";

    public static final String FAIL_MSG = "FAIL";

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
     * @param code
     * @param message
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
     * 响应操作成功默认消息
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> success(T data)
    {
        return new ResponseVo<T>(SUCCESS, SUCCESS_MSG, data);
    }

    /**
     * 响应操作失败消息
     * @param message 消息信息
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> fail(String message)
    {
        return new ResponseVo<T>(FAIL, message, null);
    }

    /**
     * 响应失败消息
     * @param message 消息信息
     * @param data 消息体
     * @return ResponseVo
     */
    public static <T> ResponseVo<T> fail(String code, String message, T data)
    {
        return new ResponseVo<T>(FAIL, message, data);
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
