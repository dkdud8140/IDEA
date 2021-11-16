package com.callor.sec.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsVO implements UserDetails {

    private static final long serialVersionID = 1L;

    private Long id;
    private String username;
    private String password;

    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    private Collection<? extends GrantedAuthority> authorities ;

    private String email;
    private String tel;
    private String address;

}
