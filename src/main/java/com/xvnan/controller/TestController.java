package com.xvnan.controller;


import com.alibaba.fastjson.JSONObject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/hello")
public class TestController {

    /**
     * <p>
     *  前端控制器
     * </p>
     *
     */
        @GetMapping(value = "/test")
        public ResponseEntity<?> list(HttpServletResponse response){
            response.setStatus(1,"测试成功");
            JSONObject json=new JSONObject();
            json.put("uname","zs");
            json.put("pwd",123);
            return ResponseEntity.ok(json.toJSONString());
        }



}
