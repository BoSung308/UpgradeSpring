package com.sparta.project_upgradeschedulemanage.controller;


import com.sparta.project_upgradeschedulemanage.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.entity.Comment;
import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import com.sparta.project_upgradeschedulemanage.repository.CommentRepository;
import com.sparta.project_upgradeschedulemanage.repository.ScheduleRepository;
import com.sparta.project_upgradeschedulemanage.sevice.CommentService;
import com.sparta.project_upgradeschedulemanage.sevice.ScheduleService;
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


    // 생성
    @PostMapping("/createComment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto){
        // 스케줄 id 기반으로 스케줄을 찾음

        Schedule schedule = scheduleRepository.findById(commentRequestDto.getScheduleId()).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다."));

        Comment comment = new Comment(commentRequestDto, schedule);
        CommentResponseDto commentResponseDto = new CommentResponseDto(commentService.saveComment(comment));
        return ResponseEntity.ok(commentResponseDto);
    }


    // id로 단건 조회
    @GetMapping("/comment/{id}")
    public CommentResponseDto getIdInfo1(@PathVariable Long id) {
        return commentService.getIdInfo1(id);
    }


    // 전체 조회
    @GetMapping("/commentSearch")
    public List<CommentResponseDto> getComment(){
        return commentService.getComment();
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
