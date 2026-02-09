package com.book.hdn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListComicsReponse {
    private Long id;
    private String title;
    private String author;
    private String coverImage;
}
