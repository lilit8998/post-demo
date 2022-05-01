package com.example.controller;

import com.example.endpoint.Post;
import com.example.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PostRepo postRepo;

    @GetMapping("/")
    public String homePage(ModelMap modelMap){
        List<Post> all = postRepo.findAll();
        modelMap.addAttribute("posts",all);
        return "home";
    }
}
