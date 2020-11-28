package com.example.tamchack.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchResponse {
    private String title;

    private String preViewContent;
}
