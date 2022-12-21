package com.cvtheque.cvtheque.controllers;


import com.cvtheque.cvtheque.models.Comment;
import com.cvtheque.cvtheque.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }


    @PostMapping()
    //Create Comment
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        return new ResponseEntity<Comment>(commentService.save(comment), HttpStatus.CREATED);
    }

    //Get all the comments of a cv
    @GetMapping("{id}")
    public ResponseEntity<List<Comment>> getCommentsOfCv(@PathVariable int id){
          return new ResponseEntity<>(commentService.getCommentsOfCv(id),HttpStatus.CREATED);
    }

    //Update Comment
    @PutMapping("{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment updatedComment,@PathVariable int id){
        //get the object of the given id
        Comment comment = commentService.getComment(id);
        if(comment != null){
            comment.setBody(updatedComment.getBody());
            return new ResponseEntity<>(commentService.save(comment),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
