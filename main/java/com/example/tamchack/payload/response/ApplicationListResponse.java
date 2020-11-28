package com.example.tamchack.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ApplicationListResponse {
    private Integer totalElements;

    private Integer totalPages;

    private List applicationResponses;
}
