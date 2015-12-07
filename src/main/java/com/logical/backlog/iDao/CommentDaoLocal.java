/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logical.backlog.iDao;

import com.logical.backlog.model.Comment;
import com.logical.backlog.model.Entries;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author yirou
 */
@Remote
public interface CommentDaoLocal {

    public void add(Comment comment);

    public Comment get(int id);

    public List<Comment> getAll();

    public void update(Comment comment);

    public void detele(Comment comment);

    public List<Comment> getAll(Entries entry);
}
