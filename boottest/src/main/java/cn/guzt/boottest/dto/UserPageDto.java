package cn.guzt.boottest.dto;

import cn.guzt.boottest.base.dto.PageDto;

/**
 * @author Admin
 */
public class UserPageDto extends PageDto {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 所在城市编号
     */
    private String cityCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
