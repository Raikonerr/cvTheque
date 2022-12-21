package com.cvtheque.cvtheque.repositories;

import com.cvtheque.cvtheque.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

    List<Comment> findAllByCv_id(int id);

    @Modifying
    @Query("update Comment c set c.body=?1 where c.id=?2")
    void updateComment(String body,int id);

}
