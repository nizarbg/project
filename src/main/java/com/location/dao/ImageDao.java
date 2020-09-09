package com.location.dao;

import com.location.model.Image;

import java.util.List;

public interface ImageDao {
    public List listAllImage();

    public void addImage(Image img);

    public void updateImage(Image img);

    public void delete(Image img);

    public Image findImageById(Image img);
}
