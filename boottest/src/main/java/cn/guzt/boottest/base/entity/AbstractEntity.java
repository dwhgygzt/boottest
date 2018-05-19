package cn.guzt.boottest.base.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * AbstractEntity 数据库实体抽象类.
 *
 * 注解JsonIgnoreProperties: 将这个注解写在类上之后，
 * JSON对象转该类对象时候就会忽略类中不存在的字段
 * @author Admin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 重新定义 toString
     * DisableCircularReferenceDetect含义=消除对同一对象循环引用的问题
     * @return JsonString
     */
    @Override
    public String toString() {
        return JSONObject.toJSONString(this,SerializerFeature.DisableCircularReferenceDetect);
    }

}
