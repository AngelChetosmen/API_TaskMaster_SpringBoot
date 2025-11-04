package com.taskmaster.euva.taskmaster.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    private boolean completed;
}