package com.book.hdn.service;

import com.book.hdn.dto.request.ComicsRequest;
import com.book.hdn.entity.Comic;
import com.book.hdn.entity.User;
import com.book.hdn.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommicService{

    @Autowired
    private ComicRepository comicRepository;

    public void Save(ComicsRequest comicsRequest){
        Comic comic = new Comic();
        comic.setTitle(comicsRequest.getTitle());
        comic.setAuthor(comicsRequest.getAuthor());
        comic.setDescription(comicsRequest.getDescription());
        comicRepository.save(comic);
    }
}
