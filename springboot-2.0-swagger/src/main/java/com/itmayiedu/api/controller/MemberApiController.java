package com.itmayiedu.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-17 下午 12:52
 */
@RestController
@Api("Swagger_MemberController")
public class MemberApiController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 不带参数接口
     * @return
     */
    @ApiOperation("Swagger 演示接口 >> getMember")
    @GetMapping("/getMember")
    public String getMember(){
        System.out.println("System.out.println：Swagger 无参接口 >> getMember");
        return "this is Member; translation:我是会员服务!   服务端口号"+serverPort;
    }

    /**
     * 带参接口
     * @param userName
     * @return
     */
    @ApiOperation("Swagger 演示接口 >> getOrder")
    @ApiImplicitParam(name = "userName",value = "订单信息参数",required = true,dataType = "String")
    @PostMapping("/getOrder")
    public String getOrder(String userName){
        System.out.println("System.out.println：Swagger 带参接口 >> getOrder >> param: "+userName);
        return "userName: "+userName;
    }
}