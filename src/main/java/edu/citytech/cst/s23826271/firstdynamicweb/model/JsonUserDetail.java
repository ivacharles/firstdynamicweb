package edu.citytech.cst.s23826271.firstdynamicweb.model;

import com.citytech.basicsecurity.SimpleEncryption;
import com.citytech.basicsecurity.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonUserDetail implements UserDetails {

    private  String userId;
    private  String userPassword;
    private  boolean userActive;
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public JsonUserDetail(User userInfo) {
        this.userId = userInfo.getUserId();
        String userEncryptedPassword = userInfo.getEncryptedPassword();
        this.userPassword = SimpleEncryption.decrypt(userEncryptedPassword);
        this.userActive = !userInfo.isDisabled();

        var roles = userInfo.getRoles();

        this.authorities = Arrays.stream(roles)
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userId;
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
        return this.userActive;
    }
}
