package com.sparta.project_upgradeschedulemanage.comment.dto;

import com.sparta.project_upgradeschedulemanage.comment.entity.Comment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentResponseDto {
    private Long id;
    private String username;
    private String commentContent;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.commentContent = comment.getCommentContent();
        this.username = comment.getUsername();
        this.createDate = comment.getCreateDate();
        this.modifyDate = comment.getModifyDate();
    }
}
