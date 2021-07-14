package com.subham.controller;

import com.subham.repository.AdminGalleryRepository;
import com.subham.service.AdminGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeleteController {
    @Autowired
    private AdminGalleryRepository adminGalleryRepository;
    @Autowired
    private AdminGalleryService adminGalleryService;
    @GetMapping("/delete/{id}")
    public String DeleteImages(){
        adminGalleryRepository.deleteAll();
        return "redirect:/winer";
    }
}
