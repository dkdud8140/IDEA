package com.callor.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginf() {
        return "member/login";
    }

}
