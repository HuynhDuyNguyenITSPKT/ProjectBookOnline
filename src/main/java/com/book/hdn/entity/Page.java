package com.book.hdn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Page {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pageNumber;
    private String imageUrl;

    @ManyToOne
    private Chapter chapter;
}
