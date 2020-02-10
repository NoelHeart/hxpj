package com.biye.hxpj.service;

import com.biye.hxpj.model.User;
import com.github.pagehelper.PageInfo;

public interface SysUserService {

    PageInfo<User> getAdminUserList(Integer pageNum,Integer pageSize,Long userId);

    PageInfo<User> getEditorUserList(Integer pageNum,Integer pageSize,Long userId);

    int addUser(User user);

    User findByName(String username);

    User findById(Long id);

    int updateUser(User user);

    boolean comparePassword(User loginUser,User dataBaseUser);

    String getToken(User user);

    int deleteUser(User user);
}
