package com.sparta.project_upgradeschedulemanage.entity;

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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "comment_content", nullable = false)
    private String comment_content;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto commentRequestDto){
        this.schedule = commentRequestDto.getSchedule();
        this.username = commentRequestDto.getUsername();
        this.comment_content = commentRequestDto.getComment_content();
    }

    public void update(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.comment_content = requestDto.getComment_content();
    }
}
