package com.example.tamchack.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationListResponse {
    private Integer totalElements;

    private Integer totalPages;

    private List applicationResponses;
}
