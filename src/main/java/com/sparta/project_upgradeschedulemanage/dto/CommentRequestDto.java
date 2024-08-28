package com.sparta.project_upgradeschedulemanage.dto;

import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import lombok.Getter;

@Getter
public class CommentRequestDto{

    private Schedule schedule; //entity 생성자에서 this.schedule_id를 넣어서 사용하고싶었지만, 방법을 찾지못해 postman에서 schedule_id를 객체타입으로 요청함 -> 그래서 schedule 객체를 선언하고, entitiy 생성자 필드에 넣어줌.
    private Long scheduleId;
    private String username;
    private String comment_content;
}