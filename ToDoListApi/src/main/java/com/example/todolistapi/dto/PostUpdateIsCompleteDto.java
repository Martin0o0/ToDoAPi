package com.example.todolistapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUpdateIsCompleteDto {
    private Boolean isComplete;

    @Builder
    public PostUpdateIsCompleteDto(Boolean iscomplete) {
        this.isComplete = iscomplete;
    }
}
