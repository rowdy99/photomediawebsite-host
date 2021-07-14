package com.subham.repository;

import com.subham.model.AdminGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGalleryRepository extends JpaRepository<AdminGallery,Long> {
}
