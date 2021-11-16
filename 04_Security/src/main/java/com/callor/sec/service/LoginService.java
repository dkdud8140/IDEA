package com.callor.sec.service;

import com.callor.sec.models.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$IGYpdkDQg407AwjASjHs5ea8cmsoaMM3oxSezDPQI3dBdfmwZ1hsu";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("callor").password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();

        if(userVO == null) {
            log.debug("{} username 없음", username);
            throw new UsernameNotFoundException(username+"사용자없음");
        }

//        //=======================================
//        //Security에 내장된 코드
//        try {
//            UserDetails vo = loadUserByUsername("callor");
//
//            //비밀번호를 검사하는 코드가 내장되어 있을 것이다.
//        } catch (UsernameNotFoundException e) {
//            // redirect "/member/login?error=****"
//        }
//
//        //======================================

        return userVO;
    }


}
