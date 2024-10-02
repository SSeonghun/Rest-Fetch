package com.example.backend.domain.search.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDto {

    private long reportId;
    private long observerId;
    private String observerSerialNumber;
    private String picture;
    private LocalDateTime createdAt;
    private boolean isPicked;

}
