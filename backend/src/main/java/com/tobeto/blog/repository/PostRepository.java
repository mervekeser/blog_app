package com.tobeto.blog.repository;

import com.tobeto.blog.entity.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
