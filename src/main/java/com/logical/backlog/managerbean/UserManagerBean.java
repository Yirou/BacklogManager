/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.iDao.UserDaoLocal;
import com.logical.backlog.model.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class UserManagerBean implements Serializable {

    public User user;

    @EJB
    private UserDaoLocal userDao;

    public UserManagerBean() {
        super();
        user = new User();
    }

    public String addUser() {
        return "add-user";
    }

    public String saveUser() {
        userDao.add(user);
        return listUser();
    }

    public List<User> getAllUser() {
        return userDao.getAll();
    }

    public String login() {
        boolean isLogin = userDao.login(user);
        String page = "agence";
        HttpSession session = SessionBean.getSession();
        if (isLogin) {
            user=userDao.get(user);
            session.setAttribute("isLogin", true);
            session.setAttribute("user", user);
        } else {
            session.setAttribute("isLogin", false);
            return inscription();
        }
        return page;
    }

    public String inscription() {
        return "add-user";
    }

    public String listUser() {

        return "index";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
