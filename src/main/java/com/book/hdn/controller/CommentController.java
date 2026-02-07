package com.book.hdn.controller;

import com.book.hdn.entity.Comment;
import com.book.hdn.entity.User;
import com.book.hdn.repository.CommentRepository;
import com.book.hdn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository repo;
    private final UserRepository userRepo;

    @PostMapping("/{comicId}")
    public Comment comment(
            @PathVariable Long comicId,
            @RequestBody Comment comment,
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        comment.setUser(user);
        comment.setCreatedAt(LocalDateTime.now());
        return repo.save(comment);
    }
}

