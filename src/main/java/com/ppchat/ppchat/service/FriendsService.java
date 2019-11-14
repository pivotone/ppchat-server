package com.ppchat.ppchat.service;

import com.ppchat.ppchat.dao.Friends;
import com.ppchat.ppchat.dao.User;
import com.ppchat.ppchat.mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {
    final private FriendsMapper friendsMapper;

    @Autowired
    public FriendsService(FriendsMapper friendsMapper) {
        this.friendsMapper = friendsMapper;
    }


    /**
     * 添加好友
     *
     * @param ppid1 添加人ppid
     * @param ppid2 被添加人ppid
     **/
    public Friends addFriends(String ppid1, String ppid2) {
        return friendsMapper.setFriends(ppid1, ppid2);
    }

    /**
     * 查询好友列表
     *
     * @param ppid 好友源ppid
     **/

    public List<User> FindFriends(String ppid) {
        return friendsMapper.getFriends(ppid);
    }

    /**
     * 删除好友
     *
     * @param ppid1 好友源ppid
     * @param ppid2 被删除ppid
     **/

    boolean deleteFriends(String ppid1, String ppid2) {
        return friendsMapper.deleteFriends(ppid1, ppid2) != 0;
    }
}
