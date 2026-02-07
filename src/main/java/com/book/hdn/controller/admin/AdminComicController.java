package com.book.hdn.controller.admin;

import com.book.hdn.entity.Comic;
import com.book.hdn.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/comics")
@RequiredArgsConstructor
public class AdminComicController {

    private final ComicRepository repo;

    @PostMapping
    public Comic create(@RequestBody Comic comic) {
        return repo.save(comic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}