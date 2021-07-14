package com.subham.service;


import com.subham.model.AdminGallery;
import com.subham.repository.AdminGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminGalleryService {
    @Autowired
    private AdminGalleryRepository adminGalleryRepository;
    public void saveImage(AdminGallery adminGallery) {
        adminGalleryRepository.save(adminGallery);
    }

    public List<AdminGallery> getAllActiveImages() {
        return adminGalleryRepository.findAll();
    }

    public Optional<AdminGallery> getImageById(Long id) {
        return adminGalleryRepository.findById(id);
    }

}
