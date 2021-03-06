package com.callor.sec.service.auth;

import com.callor.sec.config.Message;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service("loginFailService")
public class LoginFailService implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse res,
                                        AuthenticationException exception) throws IOException, ServletException {

        log.debug("LOGIN FAIL EXCEPTION START");
        log.debug("Exception :: {}", exception.getClass().getName());

        String error_msg ="";

        /**
        //어떤 문제가 발생하여 loginFail이 작동되었는지를 알기 위해
        // exception의 정체를 파악하기
            1. exception의 클래스 이름을 문자열로 비교하여 정체 파악하기
                type 오류로 인한 문제를 일으킬 수 있다.
            if(exception.getClass().getName().equalsIgnoreCase("CredentialsExpiredException"))
         **/


        //2, exception 객체가 어떤 클래스의 인스턴스인가를 알아보고 exception의 정체를 파악하기
        // 최소한 type오류는 발생하지 않는다.
        if(exception instanceof CredentialsExpiredException) {
            error_msg = Message.ERROR.CredentialsExpired;
        } else  if(exception instanceof AccountExpiredException) {
            error_msg = Message.ERROR.AccountExpired;
        } else if(exception instanceof DisabledException) {
            error_msg = Message.ERROR.Disabled;
        } else if(exception instanceof LockedException) {
            error_msg = Message.ERROR.Locked;
        } else if(exception instanceof SessionAuthenticationException) {
            error_msg = Message.ERROR.SessionAuthentication;
        } else {
            error_msg = Message.ERROR.BadCredentials;
        }


        /**
         * GET 방식으로 /member/login URL은 login.jsp를 열기 위한 요청
         * login.jsp에서 "로그인" 버튼을 클릭(submit)하면
         * POST 방식으로 /login URL로 요청이 전달된다.
         *
         * LOGIN이 실패했을 떄
         * 다시 /member/login으로 forwarding을 수행한다
         *
         * 이 때 /member/login은 POST 방식으로 호출이 된다.
         *
         * POST /login을 수행하는 과정에서 forwarding을 했기 때문에
         *
         * 만약 redirect를 했다면 GET 방식으로 호출이 된다
         */

        req.setAttribute("ERROR_MSG", "로그인문제발생");
        req.setAttribute("AUTHOR","졸려뒈지겠다");

        // /member/login URL로 forwarding을 수행하라
        // redirect를 하는게 아니다
        // 위의 error 메세지를 같이 담아서 보내기 위해서
        req.getRequestDispatcher("/member/login?error").forward(req,res);

    }
}
