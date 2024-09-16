package com.sparta.project_upgradeschedulemanage.comment.controller;


import com.sparta.project_upgradeschedulemanage.comment.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.comment.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.schedule.repository.ScheduleRepository;
import com.sparta.project_upgradeschedulemanage.comment.service.CommentService;
import com.sparta.project_upgradeschedulemanage.schedule.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final ScheduleRepository scheduleRepository;
    private final CommentService commentService;
    private final ScheduleService scheduleService;

    public CommentController(ScheduleRepository scheduleRepository, CommentService commentService, ScheduleService scheduleService){
        this.scheduleRepository = scheduleRepository;
        this.commentService = commentService;
        this.scheduleService = scheduleService;
    }


    // 생성 (코드방식? 타입?을 통일 시키는것이 가시성 등을 위해서라도 통일시켜야한다는 것을 알지만,
    // 스케줄생성 메서드와 타입이 다른 이유는 코드구성방식의 다양성을 경험해보기 위하여 타입을 달리하여 작성함)

    @PostMapping("/createComment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto){

        // 스케줄 id 기반으로 스케줄을 찾음
        CommentResponseDto commentResponseDto = new CommentResponseDto(commentService.saveComment(commentRequestDto));
        return ResponseEntity.ok(commentResponseDto);
    }


    // id로 단건 조회
    @GetMapping("/comment/{id}")
    public CommentResponseDto getIdInfo(@PathVariable Long id) {
        return commentService.getIdInfo(id);
    }


    // 전체 조회
    @GetMapping("/commentAll")
    public List<CommentResponseDto> getComment(){
        return commentService.getComment() ;
    }


    // 수정
    @PutMapping("/comment/{id}")
    public Long updateComment(@PathVariable("id") Long id, @RequestBody CommentRequestDto requestDto){
        return commentService.updateComment(id,requestDto);
    }


    // 삭제
    @DeleteMapping("/comment/{id}")
    public Long deleteComment(@PathVariable("id") Long id){
        return commentService.deleteComment(id);
    }
}
