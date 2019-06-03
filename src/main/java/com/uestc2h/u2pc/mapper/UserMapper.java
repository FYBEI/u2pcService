package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.mapper.DO.UserDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper{

    @Select("select * from user where email=#{email} and password=#{password};")
    UserDO login(UserDO user);

    @Insert("insert into user(email, password) values (#{email}, #{password});")
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int register(UserDO user);

    @Update("update user set username=#{userName}, sign=#{sign}, phone=#{phone} where userId=#{userId};")
    int setInfo(UserDO user);
}
