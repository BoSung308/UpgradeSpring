package com.sparta.project_upgradeschedulemanage.controller;


import com.sparta.project_upgradeschedulemanage.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.sevice.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    // 생성
    @PostMapping("/createComment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(commentRequestDto);
    }

    // 단건 조회
    @GetMapping("/comment/{id}")
    public CommentResponseDto getIdInfo1(@PathVariable Long id) {
        return commentService.getIdInfo1(id);
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
