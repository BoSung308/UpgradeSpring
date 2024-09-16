package com.sparta.project_upgradeschedulemanage.comment.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto{

    private Long scheduleId;
    private String username;
    private String commentContent;
}