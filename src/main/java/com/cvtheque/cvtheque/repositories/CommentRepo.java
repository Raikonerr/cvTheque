package com.cvtheque.cvtheque.repositories;

import com.cvtheque.cvtheque.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

}
