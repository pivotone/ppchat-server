package com.ppchat.ppchat.controller;

import com.ppchat.ppchat.dao.User;
import com.ppchat.ppchat.entity.Message;
import com.ppchat.ppchat.service.UserService;
import com.ppchat.ppchat.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param request http请求
     * @param ppid    用户id
     * @param pwd     用户密码
     * @return 信息
     */

    @GetMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Message login(HttpServletRequest request, @RequestParam("ppid") String ppid, @RequestParam("pwd") String pwd) {
        User user = userService.login(ppid, pwd);
        user.setPwd(null);

        HttpSession session = request.getSession();
        session.setAttribute("uid", user.getUid());
        session.setAttribute("ppid", user.getPpid());
        session.setAttribute("nickname", user.getPpname());

        if (user.getUid() == 0) return ResultUtils.error("2100", "登录失败，请检查用户信息");
        else return ResultUtils.success(user);
    }

    /**
     * 用户注册
     *
     * @param request  http请求
     * @param nickname 用户昵称
     * @param pwd      用户密码
     * @return 处理信息
     */
    @PostMapping(value = "/signup", produces = "application/json;charset=UTF-8")
    public Message signup(HttpServletRequest request, @RequestParam("nickname") String nickname, @RequestParam("pwd") String pwd) {
        String ppid = newPpid();
        User user = userService.signup(pwd, nickname, ppid);
        user.setPwd(null);
        HttpSession session = request.getSession();
        session.setAttribute("uid", user.getUid());
        session.setAttribute("ppid", user.getPpid());
        session.setAttribute("ppname", user.getPpname());
        if (user.getUid() == 0) return ResultUtils.error("2000", "用户注册失败");
        else return ResultUtils.success(user);
    }

    /**
     * 用户跟新信息
     *
     * @param request  http请求
     * @param nickname 用户昵称
     * @param pwd      用户密码
     * @param ppid     用户id
     * @param uid      用户数据库id
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Message update(HttpServletRequest request, @RequestParam("uid") int uid, @RequestParam("nickname") String nickname, @RequestParam("pwd") String pwd, @RequestParam("ppid") String ppid) {
        User user = userService.updateInfo(nickname, pwd, uid, ppid);
        user.setPwd(null);

        HttpSession session = request.getSession();
        session.setAttribute("uid", user.getUid());
        session.setAttribute("ppid", user.getPpid());
        session.setAttribute("nickname", user.getPpname());

        if (user.getUid() == 0) return ResultUtils.error("2200", "更改信息失败");
        else return ResultUtils.success(user);
    }

    /**
     * 随机生成ppid
     */
    public String newPpid() {
        int s = (int) Math.random() * 1000000;
        if (s < 100000) s += 100000;
        String ppid = String.valueOf(s);
        if (userService.users(ppid)) return ppid;
        else return newPpid();
    }
}
