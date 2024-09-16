package com.sparta.project_upgradeschedulemanage.user.entity;

import com.sparta.project_upgradeschedulemanage.common.TimeStamp;
import com.sparta.project_upgradeschedulemanage.schedule.entity.UserSchedule;
import com.sparta.project_upgradeschedulemanage.user.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table
public class User extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserSchedule> userScheduleList = new ArrayList<>();


    public User(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;

    }
}

