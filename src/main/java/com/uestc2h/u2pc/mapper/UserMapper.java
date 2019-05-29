package com.uestc2h.u2pc.mapper;

import com.uestc2h.u2pc.mapper.DO.UserDO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper{

    @Select("select userId from user where email=#{email} and password=#{password}")
    Long login(UserDO user);

    @Insert("insert into user(email, password) values (#{email}, #{password})")
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int register(UserDO user);

    @Update("update user set username=#{username}, sign=#{sign}, phone=#{phone}")
    int setInfo(UserDO user);
}
