package com.sparta.project_upgradeschedulemanage.controller;


import com.sparta.project_upgradeschedulemanage.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.dto.ScheduleResponseDto;
import com.sparta.project_upgradeschedulemanage.entity.Comment;
import com.sparta.project_upgradeschedulemanage.sevice.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    // 생성
    @PostMapping("/createComment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto){
        Comment comment = new Comment(commentRequestDto);
        CommentResponseDto commentResponseDto = new CommentResponseDto(commentService.saveComment(comment));
        return ResponseEntity.ok(commentResponseDto);
    }

    // id로 단건 조회
    @GetMapping("/comment/{id}")
    public CommentResponseDto getIdInfo1(@PathVariable Long id) {
        return commentService.getIdInfo1(id);
    }

    // 전체 조회
    @GetMapping("/CommentSearch")
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
