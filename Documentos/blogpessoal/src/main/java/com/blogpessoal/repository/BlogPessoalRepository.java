package com.blogpessoal.repository;

import com.blogpessoal.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPessoalRepository extends JpaRepository<Post, Long> {
}
