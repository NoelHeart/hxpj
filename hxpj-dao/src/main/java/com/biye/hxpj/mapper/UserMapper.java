package com.biye.hxpj.mapper;


import com.biye.hxpj.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    List<User> selectByRole(@Param("role") String role);

    int addUser(User user);
    User findUser(User user);
    int updateByPrimaryKeySelective(User user);

    int deleteUserByPrimaryKey(@Param("userId") Long userId);
}
