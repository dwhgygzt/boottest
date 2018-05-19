package cn.guzt.boottest.dto;

import cn.guzt.boottest.base.dto.PageDto;

/**
 * 分页查询
 */
public class CityPageDto extends PageDto {

    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市编号
     */
    private String code;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
