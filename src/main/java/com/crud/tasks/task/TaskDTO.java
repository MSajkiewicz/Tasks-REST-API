package com.crud.tasks.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String content;
}

