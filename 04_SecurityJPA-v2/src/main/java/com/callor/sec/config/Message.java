package com.callor.sec.config;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class Message {

    public static class ERROR {
        
        // 대표 exception
        public final static String BadCredentials
                = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해 주세요.";
    
        public final static String Disabled
            ="계정이 비활성화 되었습니다, 관리자에게 문의하세요";        
    
        public final static String CredentialsExpired
            = "비밀번호 유효기간이 만료되었습니다. 비번을 변경해주세요";

        public final static String Locked
            = "계정이 차단되었습니다. 관리자에게 문의하세요";

        public final static String AccountExpired
                = "계정 기간이 만료되었습니다.";

        public final static String SessionAuthentication
                ="인증세션 문제";
    }

}
