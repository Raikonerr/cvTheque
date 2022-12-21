package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.repositories.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }
}
