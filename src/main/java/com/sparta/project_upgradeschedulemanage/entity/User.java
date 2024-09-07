package com.sparta.project_upgradeschedulemanage.entity;

import com.sparta.project_upgradeschedulemanage.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class User extends TimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserSchedule> userScheduleList = new ArrayList<>();

    public User(UserRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();

    }
}

