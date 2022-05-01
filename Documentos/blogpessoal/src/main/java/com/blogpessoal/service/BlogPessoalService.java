package com.blogpessoal.service;

import com.blogpessoal.model.Post;

import java.util.List;

public interface BlogPessoalService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
}
