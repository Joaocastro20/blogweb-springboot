package com.blogpessoal.service.serviceImpl;

import com.blogpessoal.model.Post;
import com.blogpessoal.repository.BlogPessoalRepository;
import com.blogpessoal.service.BlogPessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPessoalServiceImpl implements BlogPessoalService {

    @Autowired
    BlogPessoalRepository blogPessoalRepository;

    @Override
    public List<Post> findAll() {
        return blogPessoalRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return blogPessoalRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return blogPessoalRepository.save(post);
    }
}
