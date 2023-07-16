package com.platform.service;

import com.platform.model.ImageCatcher;
import com.platform.repository.ImageRespository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ImageService {

    @Inject
    private ImageRespository imageRepo;

    public ImageCatcher saveImage(String encodedStringImage) {
        ImageCatcher imageCatcher = new ImageCatcher().encodedImage(encodedStringImage);
        return imageRepo.save(imageCatcher);
    }
}
