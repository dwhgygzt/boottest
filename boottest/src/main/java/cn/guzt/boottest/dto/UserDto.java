package cn.guzt.boottest.dto;

import cn.guzt.boottest.base.dto.AbstractDto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 前端传递的user相关参数
 */
public class UserDto extends AbstractDto {

    /**
     * 用户名称
     */
    @NotNull(message = "用户名称不能为空")
    private String userName;

    /**
     * 登录密码
     */
    @NotNull(message = "登录密码不能为空")
    private String password;

    /**
     * 用户手机号
     */
    @NotNull(message = "手机号不能为空")
    @Length(min=11, max=15, message="手机号11位~15位")
    private String mobile;

    /**
     * 所在城市编号
     */
    @NotNull(message = "所在城市不能为空")
    private String cityCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
