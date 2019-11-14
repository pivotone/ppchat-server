package com.ppchat.ppchat.mapper;

import com.ppchat.ppchat.dao.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    /**
     * 根据ppid来查询用户信息
     **/
    @Select("select *from ppuser where ppid = #{ppid}")
    User getUser(String ppid);

    /**
     * 新用户插入
     **/
    @Insert("insert into ppuser(ppid,nickname,pwd) values(#{ppid},#{nickname},#{pwd})")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    void newUser(User ppuser);

    @Update("update ppuser set pwd = #{pwd} , nickname = #{nickname} where ppid = #{ppid}")
    User updateUser(String pwd, String nickname, String ppid);

}
