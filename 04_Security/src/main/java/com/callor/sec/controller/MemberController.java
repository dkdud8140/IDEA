package com.callor.sec.controller;

import com.callor.sec.models.UserDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "member/login";
    }

    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public String join() {
        return "member/join";
    }

    @RequestMapping(value="/join",method=RequestMethod.POST)
    public String join(UserDetailsVO userVO) {
        log.debug("회원가입 : {}", userVO.toString());
        return "member/join";
    }

    @ResponseBody
    @RequestMapping(value = "/idcheck",method = RequestMethod.GET)
    public String idcheck(String username) {

        if(username.equalsIgnoreCase("callor")) {
            return "callor";
        } else {
            return null;
        }
    }


}
