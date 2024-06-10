package com.tobeto.blog.repository;

import com.tobeto.blog.entity.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
