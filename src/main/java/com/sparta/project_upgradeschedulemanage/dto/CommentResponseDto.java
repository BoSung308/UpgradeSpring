package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.Comment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentResponseDto {
    private Long id;
    private String username;
    private String comment_content;
    private Timestamp create_date;
    private Timestamp modify_date;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment_content = comment.getComment_content();
        this.username = comment.getUsername();
        this.create_date = comment.getCreate_date();
        this.modify_date = comment.getModify_date();
    }
}
