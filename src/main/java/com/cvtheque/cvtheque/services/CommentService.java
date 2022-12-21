package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Comment;
import com.cvtheque.cvtheque.repositories.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    //Create Comment
    public Comment save(Comment comment){
        return commentRepo.save(comment);
    }

    //get All comments of a cv
    public List<Comment> getCommentsOfCv(int id){
        return commentRepo.findAllByCv_id(id);
    }

    //delete Comment
    public void deleteComment(Comment comment){
        commentRepo.delete(comment);
    }

    // updateComment
    public boolean updateComment(String body,int id){
        commentRepo.updateComment(body,id);
        return true;
    }

    //get service with id
    public Comment getComment(int id){
        return commentRepo.getReferenceById(id);
    }
}
