package com.sparta.project_upgradeschedulemanage.entity;

import com.sparta.project_upgradeschedulemanage.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Schedule extends TimeStamp {

    @Id
    //엔티티의 기본 키 값을 데이터베이스의 자동 증가 기능에 의해 자동으로 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "todo_title", nullable = false)
    private String todoTitle;

    @Column(name = "todo_contents", nullable = false)
    private String todoContents;

    @Column
    private Long userId;

    // 댓글과의 다대일 양방향 관계 설정, RMOVE를 이용하여 부모엔티티가 삭제될 떄 연관된 자식엔티티도 삭제
    // orphanRemoval을 이용하여 부모엔티티에서 연관된 자식 엔티티가 삭제될때, 자식엔티티 db를 자동 삭제
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private List<UserSchedule> userScheduleList = new ArrayList<>();

    public Schedule(ScheduleRequestDto requestDto){

        this.username = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
    }

    public void update(ScheduleRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
    }
}
