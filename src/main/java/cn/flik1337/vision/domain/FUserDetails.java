package cn.flik1337.vision.domain;

import cn.flik1337.vision.mbg.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Description
 * @Author flik
 * @Date 2020/7/28 21:54
 * @Version 1.0
 */
@MapperScan
public class FUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private  User user;

    public FUserDetails(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return user.getPwd();
    }

    /**
    * @Description: 获取用户id（转换为string）
    * @Param:
    * @Date: 2021/5/19 10:30:42
    */
    @Override
    public String getUsername() {

        return user.getUserId().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
