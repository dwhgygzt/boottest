package cn.guzt.boottest.base.dto;

import java.io.Serializable;

/**
 * AbstractDto
 * @author Administrator
 */
public class AbstractDto implements Serializable{

    private static final long serialVersionUID = 161062863248489221L;

    /**
     * 记录主键
     */
    private Long id;

    /**
     * 记录创建时间
     */
    private String createTime;

    /**
     * 记录修改时间
     */
    private String updateTime;

    /**
     * 创建人工号
     */
    private String createOperId;

    /**
     * 修改人工号
     */
    private String updateOperId;

    /**
     * 关键字搜索
     */
    private String searchText;

    /**
     * 搜索开始时间
     */
    private String searchStartTime;

    /**
     * 搜索结束时间
     */
    private String searchEndTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchStartTime() {
        return searchStartTime;
    }

    public void setSearchStartTime(String searchStartTime) {
        this.searchStartTime = searchStartTime;
    }

    public String getSearchEndTime() {
        return searchEndTime;
    }

    public void setSearchEndTime(String searchEndTime) {
        this.searchEndTime = searchEndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
