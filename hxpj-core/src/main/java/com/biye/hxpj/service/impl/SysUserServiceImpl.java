package com.biye.hxpj.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.biye.hxpj.mapper.UserMapper;
import com.biye.hxpj.model.User;
import com.biye.hxpj.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

/**
 * @program: hxpj
 * @description:
 * @author: LiLei
 * @create: 2019-04-01 20:30
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageInfo<User> getAdminUserList(Integer pageNum, Integer pageSize,Long userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userMapper.findAll();
//        Iterator<User> iterator=list.iterator();
//        while (iterator.hasNext()){
//
//        }
        for (User user1:list){
            Long id=user1.getUserId();
            if (id.equals(userId)){
                list.remove(user1);
                break;
            }
        }
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<User> getEditorUserList(Integer pageNum, Integer pageSize,Long userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userMapper.selectByRole("visitor");
        for (User user1:list){
            Long id=user1.getUserId();
            if (id.equals(userId)){
                list.remove(user1);
                break;
            }
        }
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addUser(User user) {
        String role=user.getRole();
        if (role.equals("admin")){
            user.setRole("admin");
        }else if (role.equals("editor")){
            user.setRole("editor");
        }else {
            user.setRole("visitor");
        }
        return userMapper.addUser(user);
    }
    @Override
    public User findByName(String username) {
        User user = new User();
        user.setUserAccount(username);
        return userMapper.findUser(user);
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setUserId(id);
        return userMapper.findUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public boolean comparePassword(User loginUser, User dataBaseUser) {
        return loginUser.getPassWord().equals(dataBaseUser.getPassWord());
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUserByPrimaryKey(user.getUserId());
    }

    @Override
    public String getToken(User user) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(user.getUserId().toString())          // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPassWord()));   // 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException ignore) {
        }
        return token;
    }

    //密码加密
    private String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }


}
