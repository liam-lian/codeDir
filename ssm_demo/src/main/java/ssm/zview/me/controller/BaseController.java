package ssm.zview.me.controller;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.zview.me.dao.LoginCheck;

@Controller
@RequestMapping("/sqlInsert")
public class BaseController {


    @Autowired
    LoginCheck loginCheck;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String Login(String name,String passwd){
        if(loginCheck.checkLogin(name,passwd)>0){
            return "登录成功\t"+name;
        }
        return "登录失败\t"+name;
    }
}
