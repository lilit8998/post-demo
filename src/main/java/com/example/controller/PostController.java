package com.example.controller;


import com.example.endpoint.Post;
import com.example.repository.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepo postRepo;



    @PostMapping("/post/save")
    public String addPost(@ModelAttribute Post post){
        postRepo.save(post);
        return "redirect:/";
    }

    @GetMapping("post/delete")
    public String deletePost(@RequestParam("id") int id){
        postRepo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("post/edit")
    public String editPost(@PathVariable("id")int id, Model model){

        Post post = postRepo.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("post",post);
        return "savePost";
    }


    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;

    }
}
