package com.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.DocumentDao;
import com.location.model.Document;

@Service
public class DocumentServiceImpl implements DocumentService {

    DocumentDao documentDao;

    @Autowired
    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public List listAllDocument() {
        return documentDao.listAllDocument();
    }

    public void addDocument(Document document) {
        documentDao.addDocument(document);
    }

    public void updateDocument(Document document) {
        documentDao.updateDocument(document);
    }

    public void delete(Document document) {
        documentDao.delete(document);
    }

    public Document findDocumentById(Document document) {
        return documentDao.findDocumentById(document);
    }

}
