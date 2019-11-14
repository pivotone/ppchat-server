package com.ppchat.ppchat.mapper;

import com.ppchat.ppchat.dao.Friends;
import com.ppchat.ppchat.dao.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface FriendsMapper {
    /**
     * 根据ppid来查询用户好友
     **/
    @Select("select *from ppuser where ppid in (select ppid2 from ppfriends where ppid1 = #{ppid})")
    List<User> getFriends(String ppid);

    /**
     * 根据ppid1和ppid2来添加好友
     **/
    @Insert({"insert into ppfriends values(#{ppid1},#{ppid2})", "insert into ppfriends values(#{ppid2},#{ppid1})"})
    Friends setFriends(String ppid1, String ppid2);

    @Delete("delete ppid2=#{ppid2} from ppfriends where ppid1=#{ppid1}")
    int deleteFriends(String ppid1, String ppid2);
}
