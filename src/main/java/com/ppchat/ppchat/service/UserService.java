package com.ppchat.ppchat.service;

import com.ppchat.ppchat.dao.User;
import com.ppchat.ppchat.mapper.UserMapper;
import com.ppchat.ppchat.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final private UserMapper userMapper;
    private MD5 md5 = new MD5();

    @Autowired
    public UserService(UserMapper ppuserMapper) {
        this.userMapper = ppuserMapper;
    }


    /**
     * 注册
     *
     * @param pwd      密码
     * @param nickname 昵称
     * @param ppid     用户账号
     **/
    public User signup(String pwd, String nickname, String ppid) {
        User ppuser = new User();
        ppuser.setPpid(ppid);
        ppuser.setPpname(nickname);
        ppuser.setPwd(md5.getCiphertext(pwd));
        userMapper.newUser(ppuser);
        return ppuser;
    }

    /**
     * 登录
     *
     * @param ppid 账号
     * @param pwd  密码
     **/
    public User login(String ppid, String pwd) {
        User ppuser = userMapper.getUser(ppid);
        if (ppuser == null) ppuser = new User();
        if (!md5.verify(pwd, ppuser.getPwd())) ppuser.setUid(0);
        return ppuser;
    }

    /**
     * 更新信息
     *
     * @param nickname 昵称
     * @param pwd      密码
     **/
    public User updateInfo(String nickname, String pwd, int uid, String ppid) {
        return userMapper.updateUser(pwd, nickname, ppid);
    }

    /**
     * 查询用户信息
     */
    public boolean users(String ppid) {
        return userMapper.getUser(ppid) == null ? true : false;
    }
}
