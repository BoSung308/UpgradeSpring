package com.sparta.project_upgradeschedulemanage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.project_upgradeschedulemanage.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "User", nullable = false)
    private String username;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto commentRequestDto, Schedule schedule) {
        this.schedule = schedule;
        this.username = commentRequestDto.getUsername();
        this.commentContent = commentRequestDto.getCommentContent();
    }

    public void update(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.commentContent = requestDto.getCommentContent();
    }
}
