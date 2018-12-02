package cn.guzt.boottest.dto;

import cn.guzt.boottest.base.dto.AbstractDto;

import javax.validation.constraints.NotNull;

/**
 * @author Admin
 */
public class CityDto extends AbstractDto {

    /**
     * 城市名称
     */
    @NotNull(message = "名称不能为空")
    private String name;

    /**
     * 城市编号
     */
    @NotNull(message = "编码不能为空")
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
