package com.blogpessoal.controller;

import com.blogpessoal.model.Post;
import com.blogpessoal.service.BlogPessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogPessoalController {

    @Autowired
    BlogPessoalService blogPessoalService;

    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogPessoalService.findAll();
        mv.addObject("posts",posts);
        return mv;
    }
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostId(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postsdetalhes");
        Post post = blogPessoalService.findById(id);
        mv.addObject("post",post);
        return mv;
    }

    @RequestMapping(value = "/novopost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postnovo";
    }
    @RequestMapping(value = "/novopost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","Verifique se os campos foram preenchidos corretamente");
            return "redirect:/novopost";
        }
        post.setData(LocalDate.now());
        blogPessoalService.save(post);
        return "redirect:/novopost";
    }



}
