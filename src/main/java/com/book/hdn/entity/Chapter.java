package com.book.hdn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Chapter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int chapterNumber;

    @ManyToOne
    private Comic comic;
}
