package cn.guzt.boottest.base.vo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库分页查询列表封装对象
 * @author Administrator
 */
public class PageVo <T> implements Serializable {

    private static final long serialVersionUID = 161062864248489310L;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页的数量
     */
    private int pageSize;

    /**
     * 结果集
     */
    private List<T> rows;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 构造函数
     */
    public PageVo() {

    }

    /**
     * 构造函数
     * @param info
     */
    public PageVo(PageInfo<T> info) {
        this.total = info.getTotal();
        this.pageNum = info.getPageNum();
        this.pages = info.getPages();
        this.pageSize = info.getPageSize();
        this.rows = info.getList();
    }

    /**
     * 获取总记录数
     * @return 总记录数
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置 总记录数
     * @param total 总记录数
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取当前页
     * @return 当前页
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * 设置当前页
     * @param pageNum 当前页
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取每页的数量
     * @return 每页的数量
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的数量
     * @param pageSize 每页的数量
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取结果集
     * @return 结果集
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置结果集
     * @param rows 结果集
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 获取总页数
     * @return 总页数
     */
    public int getPages() {
        return pages;
    }

    /**
     * 设置总页数
     * @param pages 总页数
     */
    public void setPages(int pages) {
        this.pages = pages;
    }
}
