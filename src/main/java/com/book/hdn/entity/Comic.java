package com.book.hdn.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
public class Comic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String coverImage;
}
