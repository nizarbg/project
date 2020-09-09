package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.location.model.Image;

import com.location.service.ImageService;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value="/user/Image/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Image>> listAllImage(){
        List<Image> list = imageService.listAllImage();

        if(list.size() == 0){
            return new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Image/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Image image){
        imageService.addImage(image);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Image/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Image image){
        image.setId(id);
        imageService.updateImage(image);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Image/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Image image){
        image.setId(id);
        imageService.delete(image);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}