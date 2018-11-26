package cn.guzt.boottest.dto;

import cn.guzt.boottest.base.dto.AbstractDto;

import javax.validation.constraints.NotNull;

public class LoginDto extends AbstractDto {

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
}
