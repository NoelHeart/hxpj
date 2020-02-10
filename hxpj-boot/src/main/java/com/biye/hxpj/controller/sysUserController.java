package com.biye.hxpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.biye.hxpj.annotation.CurrentUser;
import com.biye.hxpj.annotation.LoginRequired;
import com.biye.hxpj.model.User;
import com.biye.hxpj.request.PageData;
import com.biye.hxpj.response.ResponseResult;
import com.biye.hxpj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hxpj
 * @description: 用户逻辑控制
 * @author: LiLei
 * @create: 2019-04-01 20:11
 **/

@RequestMapping("/user")
@RestController
public class sysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * Login interface
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        try {
            JSONObject jsonObject = new JSONObject();
            if (user == null) {
                ResponseResult.buildError(4001,"登录入参错误!");
            }
            String userAccount = user.getUserAccount();
            User dataBaseUser = sysUserService.findByName(userAccount);
            if (dataBaseUser == null) {
                return ResponseResult.buildError(4001,"用户不存在！");
            }
            if (!sysUserService.comparePassword(user, dataBaseUser)) {
                return ResponseResult.buildError(4001,"密码错误！");
            }
            String roles=dataBaseUser.getRole();
            if (roles.equals("admin")){
                jsonObject.put("roles","admin");
            }else if (roles.equals("editor")){
                jsonObject.put("roles","editor");
            }else {
                jsonObject.put("roles","visitor");
            }
            String token = sysUserService.getToken(dataBaseUser);
            jsonObject.put("token", token);
            jsonObject.put("user",dataBaseUser);
            return ResponseResult.buildSuccess("登陆成功！",jsonObject);
        } catch (Exception e) {
            return ResponseResult.buildError(4001,"登录异常！");
        }
    }
    /**
     * register interface
     */

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        try{
            if(user == null){
                ResponseResult.buildError(4003,"注册入参错误！");
            }
            String userAccount = user.getUserAccount();
            User dataBaseUser = sysUserService.findByName(userAccount);
            if (dataBaseUser == null) {
                sysUserService.addUser(user);
            }
            else {
                return ResponseResult.buildError(4003,"用户名已存在！");
            }
            JSONObject jsonObject = new JSONObject();
            return ResponseResult.buildSuccess("注册成功！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"注册异常！");
        }
    }
    /**
     * userInfo interface
     */
    @GetMapping("/getUserInfo")
    @LoginRequired
    public ResponseResult getUserInfo(@CurrentUser User user){
        try{
            JSONObject jsonObject=new JSONObject();
            String userAccount = user.getUserAccount();
            User dataBaseUser = sysUserService.findByName(userAccount);
            jsonObject.put("userInfo",dataBaseUser);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4001,"获取用户信息异常");
        }
    }
    @PostMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user){
        try{
            if (user.getUserId()==null){
                return ResponseResult.buildError(4003,"更新用户个人信息失败，入参为空！");
            }
            sysUserService.updateUser(user);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功更新用户信息！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"更新用户个人信息异常");
        }
    }
    @PostMapping("/getAdminUserList")
    public ResponseResult getAdminUserList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取用户列表失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            Long selectId=pageData.getMohuId();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",sysUserService.getAdminUserList(pageNum,pageSize,selectId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取用户列表异常！");
        }
    }
    @PostMapping("/getEditorUserList")
    public ResponseResult getEditorUserList(@RequestBody PageData pageData){
        try {
            if (pageData==null){
                return ResponseResult.buildError(4003,"获取用户列表失败，入参为空！");
            }
            Integer pageNum=pageData.getPageNum();
            Integer pageSize=pageData.getPageSize();
            Long selectId=pageData.getMohuId();
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("content",sysUserService.getEditorUserList(pageNum,pageSize,selectId));
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"获取用户列表异常！");
        }
    }

    @PostMapping("/deleteUser")
    public ResponseResult deleteUser(@RequestBody User user){
        try {
            if (user.getUserId()==null){
                return ResponseResult.buildError(4003,"删除用户失败，入参为空！");
            }
            sysUserService.deleteUser(user);
            JSONObject jsonObject=new JSONObject();
            return ResponseResult.buildSuccess("成功删除该用户！",jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError(4003,"删除用户异常！");
        }
    }


    @PostMapping("/logout")
    @LoginRequired
    public ResponseResult logout(@CurrentUser User user){
        try{
            int code=20000;
            String data="success";
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",code);
            jsonObject.put("data",data);
            return ResponseResult.buildSuccess(jsonObject);
        }catch (Exception e){
            return ResponseResult.buildError("登出异常！");
        }
    }


}
