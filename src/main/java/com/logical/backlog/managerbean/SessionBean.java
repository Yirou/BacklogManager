/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.managerbean;

import com.logical.backlog.model.Entries;
import com.logical.backlog.model.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yirou
 */
public class SessionBean {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("name").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("id");
        } else {
            return null;
        }
    }

    public static User getUser() {
        HttpSession session = getSession();

        if (session != null) {
            return (User) session.getAttribute("user");
        } else {
            System.err.println("Erreur sesssion");
            return null;
        }
    }

    public static Entries getEntry() {
        HttpSession session = getSession();

        if (session != null) {
            return (Entries) session.getAttribute("entry");
        } else {
            System.err.println("Erreur sesssion");
            return null;
        }
    }
}
