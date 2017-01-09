package com.example.controller;

import com.example.common.ResultStatus;
import com.example.common.TokenManager;
import com.example.mode.ResultModel;
import com.example.mode.TokenInfo;
import com.example.mode.User;
import com.example.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 应用系统登录
     * @param returnURL 系统URL可选s
     *  返回 1 显示登录页面，提示浏览器用户进行登录 2 产生临时认证令牌token,并重定向回系统
     */
    @RequestMapping(value = "/pageLogin", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void pageLogin(@RequestParam String returnURL){

    }

    /**
     * 浏览器登录
     * @param userName 用户名 必须
     * @param passWord 密码 必须
     * @param  returnURL 返回URL 可选
     *  返回： 1 产生临时认证令牌token, 并重定向回系统 2 返回认证中心首页 提示登录
     */
    @RequestMapping(value = "/authLogin", produces="application/json")
//    @ResponseBody
    public ResponseEntity<ResultModel> authLogin( String userName, String passWord,String returnURL){
        Assert.notNull(userName, "username can not be empty");
        Assert.notNull(passWord, "password can not be empty");

        User user = userRepository.findByUsername(userName);
        if (user == null ||  //未注册
                !user.getPassword().equals(passWord)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        String tokenId= UUID.randomUUID().toString().replace("-","");

        TokenInfo tokenInfo=new TokenInfo();
        tokenInfo.setUsername(userName);
        tokenInfo.setUserId(Integer.parseInt(String.valueOf(user.getId())));
        System.out.println(tokenId);

        //生成一个token，保存用户登录状态
        tokenManager.setToken(tokenId,tokenInfo);
        return new ResponseEntity<>(ResultModel.ok(tokenInfo), HttpStatus.OK);
    }


    /**
     *
     * @param token 认证token 必须
     * @param localId 系统本地会话标识 必须
     *   返回  JSON格式消息
     *     {
     *                state  0代表成功
     *                msg  文字说明
     *                userId 用户ID
     *                username 用户登录名
     *                globalId 全局会话ID 登出用
     *     }
     */
    @RequestMapping(value = "/authVerify", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void authVerify(String token,String localId){

    }


    /**
     *
     * @param gId 全局 会话ID 可选
     *   返回 1、返回 "OK" 2 返回认证中心首页
     */
    @RequestMapping(value = "/authLogout", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void authLogout(String gId){

    }
}
