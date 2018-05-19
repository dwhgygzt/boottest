package cn.guzt.boottest.vo;

import java.io.Serializable;

public class CountCityUserVo implements Serializable {

    private static final long serialVersionUID = 161112864131589329L;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市编号
     */
    private String code;

    /**
     * 该城市的人数
     */
    private Integer countUser;

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

    public Integer getCountUser() {
        return countUser;
    }

    public void setCountUser(Integer countUser) {
        this.countUser = countUser;
    }
}
