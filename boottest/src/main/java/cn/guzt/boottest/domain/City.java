package cn.guzt.boottest.domain;

import cn.guzt.boottest.base.entity.AbstractEntity;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Admin
 */
@Table(name = "city")
public class City extends AbstractEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 城市名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 城市编号
     */
    @Column(name = "CODE")
    private String code;

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
     * 获取主键
     *
     * @return ID - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取城市名称
     *
     * @return NAME - 城市名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置城市名称
     *
     * @param name 城市名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取城市编号
     *
     * @return CODE - 城市编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置城市编号
     *
     * @param code 城市编号
     */
    public void setCode(String code) {
        this.code = code;
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