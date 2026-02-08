package com.book.hdn.controller.admin;

import com.book.hdn.dto.request.ComicsRequest;
import com.book.hdn.dto.response.ApiResponse;
import com.book.hdn.entity.Comic;
import com.book.hdn.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/comics")
@RequiredArgsConstructor
public class AdminComicController {

    private final ComicRepository repo;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody ComicsRequest comic) {
        ApiResponse response = new ApiResponse();
        Comic newComic = new Comic();
        newComic.setTitle(comic.getTitle());
        newComic.setDescription(comic.getDescription());
        newComic.setAuthor(comic.getAuthor());
        repo.save(newComic);
        response.setSussess(true);
        response.setData(newComic);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }


}