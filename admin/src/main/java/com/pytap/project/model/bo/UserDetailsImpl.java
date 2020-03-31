package com.pytap.project.model.bo;

import com.pytap.project.entity.User;
import com.pytap.project.model.dto.AuthDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/3/23 23:39
 */
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 9061159403035701438L;

    private User user;

    private List<AuthDTO> authList;

    public UserDetailsImpl(User user, List<AuthDTO> authList) {
        this.user = user;
        this.authList = authList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (AuthDTO authDTO : authList) {
            if (authDTO.getName() != null) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authDTO.getName());
                list.add(simpleGrantedAuthority);
            }
        }
        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.getStatus().equals(1);
    }
}
