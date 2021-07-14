package com.subham.controller;

import com.subham.model.AdminGallery;
import com.subham.repository.AdminGalleryRepository;
import com.subham.service.AdminGalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WinController {
    @Value("${uploadDir}")
    private String uploadFolder;
    @Autowired
    private   AdminGalleryRepository adminGalleryRepository;
    @Autowired
    private AdminGalleryService adminGalleryService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = {"/uploadwinphoto", "/home"})
    public String uploadwinphoto() {

        return "uploadwinphoto";
    }
    @GetMapping("/winer")
    String winer(Model map) {
        List<AdminGallery> images = adminGalleryService.getAllActiveImages();
        map.addAttribute("images", images);
        return "winer";
    }
    @GetMapping("/winerdelete")
    String winerdelete(Model map) {
        List<AdminGallery> images = adminGalleryService.getAllActiveImages();
        map.addAttribute("images", images);
        return "winerdelete";
    }



}
