package com.location.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.ImageDao;
import com.location.model.Image;

@Service
public class ImageServiceImpl implements ImageService {

    ImageDao imageDao;

    @Autowired
    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public List listAllImage() {
        return imageDao.listAllImage();
    }

    public void addImage(Image image) {
        imageDao.addImage(image);
    }

    public void updateImage(Image image) {
        imageDao.updateImage(image);
    }

    public void delete(Image image) {
        imageDao.delete(image);
    }

    public Image findImageById(Image image) {
        return imageDao.findImageById(image);
    }

}