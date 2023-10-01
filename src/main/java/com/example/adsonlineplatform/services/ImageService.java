package com.example.adsonlineplatform.services;

import org.springframework.web.multipart.MultipartFile;


public interface ImageService {
    void updateAdImages(int adId, MultipartFile image);
}
