package com.wasu.demo11.controller;

import com.wasu.demo11.pojo.ResponseBo;
import com.wasu.demo11.pojo.UserOnline;
import com.wasu.demo11.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName:SessionController
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/7/21 16:17
 */
@Controller
@RequestMapping("/online")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @RequestMapping("index")
    public String online(){
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list(){
        return sessionService.list();
    }


    @ResponseBody
    @RequestMapping("forceLogout")
    public ResponseBo forceLogout(String id){
        try {
            sessionService.forceLogout(id);
            return ResponseBo.ok();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("提出用户失败");
        }
    }

}

