package com.location.dao;

import com.location.model.Document;

import java.util.List;

public interface DocumentDao {
    public List listAllDocument();

    public void addDocument(Document doc);

    public void updateDocument(Document doc);

    public void delete(Document doc);

    public Document findDocumentById(Document doc);
}
