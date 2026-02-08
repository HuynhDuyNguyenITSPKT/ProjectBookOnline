package com.book.hdn.controller.publics;

import com.book.hdn.entity.Comic;
import com.book.hdn.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor
public class ComicController {

    private final ComicRepository repo;

    @GetMapping
    public List<Comic> all() {
        return repo.findAll();
    }


}