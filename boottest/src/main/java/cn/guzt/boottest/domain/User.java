package cn.guzt.boottest.domain;

import cn.guzt.boottest.base.entity.AbstractEntity;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Admin
 */
@Table(name = "user")
public class User extends AbstractEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名称
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 用户手机号
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 所在城市编号
     */
    @Column(name = "CITY_CODE")
    private String cityCode;

    /**
     * 所在城市名称
     */
    @Column(name = "CITY_NAME")
    private String cityName;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建者
     */
    @Column(name = "CREATE_OPER_ID")
    private String createOperId;

    /**
     * 修改者
     */
    @Column(name = "UPDATE_OPER_ID")
    private String updateOperId;

    /**
     * 用于验证的token
     * Transient 表示不是表中字段的属性
     */
    @Transient
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名称
     *
     * @return USER_NAME - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录密码
     *
     * @return PASSWORD - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户手机号
     *
     * @return MOBILE - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取所在城市编号
     *
     * @return CITY_CODE - 所在城市编号
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置所在城市编号
     *
     * @param cityCode 所在城市编号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取所在城市名称
     *
     * @return CITY_NAME - 所在城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置所在城市名称
     *
     * @param cityName 所在城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return UPDATE_TIME - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者
     *
     * @return CREATE_OPER_ID - 创建者
     */
    public String getCreateOperId() {
        return createOperId;
    }

    /**
     * 设置创建者
     *
     * @param createOperId 创建者
     */
    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId;
    }

    /**
     * 获取修改者
     *
     * @return UPDATE_OPER_ID - 修改者
     */
    public String getUpdateOperId() {
        return updateOperId;
    }

    /**
     * 设置修改者
     *
     * @param updateOperId 修改者
     */
    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId;
    }
}