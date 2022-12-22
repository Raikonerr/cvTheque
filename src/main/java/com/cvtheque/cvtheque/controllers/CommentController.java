package com.cvtheque.cvtheque.controllers;


import com.cvtheque.cvtheque.exceptions.BadRequestException;
import com.cvtheque.cvtheque.exceptions.NotFoundException;
import com.cvtheque.cvtheque.models.Comment;
import com.cvtheque.cvtheque.services.CommentService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        try {
            return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
        }finally {
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }

    }

    //Get all the comments of a cv
    @GetMapping("{id}")
    public ResponseEntity<List<Comment>> getCommentsOfCv(@PathVariable int id){
         try {
             return new ResponseEntity<>(commentService.getCommentsOfCv(id),HttpStatus.OK);
         }finally {
             throw new NotFoundException("There is no cv with id : " + id);
         }

    }

    //get One Comment
    @GetMapping("/one/{id}")
    public ResponseEntity<Comment> getOneComment(@PathVariable int id){
        //Get one Comment
        try {
            Comment comment = commentService.getComment(id);
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }finally{
            throw new NotFoundException("There is no comment with id : " + id);
        }
    }
    //Update Comment
    @PutMapping("{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment updatedComment,@PathVariable int id){
        //get the object of the given id
        try {
            Comment comment = commentService.getComment(id);
            try {
                comment.setBody(updatedComment.getBody());
                return new ResponseEntity<>(commentService.save(comment),HttpStatus.OK);
            }finally {
                throw new BadRequestException("Something wrong in the form or values of the required data");
            }
        }finally {
            throw new NotFoundException("There is no comment with id : " + id);
        }
    }

    //Delete Comment
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable int id){
        try {
            // find the comment of the id
            Comment commentToDelete = commentService.getComment(id);
            try {
                commentService.deleteComment(commentToDelete);
                return new ResponseEntity<>(true,HttpStatus.OK);
            }finally {
                throw new BadRequestException("Something wrong in the form or values of the required data");
            }
        }finally {
            throw new NotFoundException("There is no comment with id : " + id);
        }
    }

}
