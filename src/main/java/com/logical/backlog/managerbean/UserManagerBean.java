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
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yirou
 */
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserManagerBean implements Serializable {

    public User user;
    public boolean login = false;
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
        //wrong solution
        SessionBean.getSession().setAttribute("isLogin", true);
        return index();
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public List<User> getAllUser() {
        return userDao.getAll();
    }

    public String login() {
        boolean isLogin = userDao.login(user);
        HttpSession session = SessionBean.getSession();
        if (isLogin) {
            user = userDao.get(user);
            session.setAttribute("isLogin", true);
            login = true;
            session.setAttribute("user", user);
        } else {
            session.setAttribute("isLogin", false);
        }
        return index();
    }

    public String index() {
        String page = "index";
        
        if(SessionBean.getSession()!=null){
            Object object=SessionBean.getSession().getAttribute("isLogin");
            if(Boolean.parseBoolean(object.toString()))
                page="agence";
        }
        return page;
    }

    public String logout() {
        SessionBean.getSession().invalidate();
        return index();
    }

    public String inscription() {
        return "add-user";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
