package com.sparta.project_upgradeschedulemanage.comment.service;


import com.sparta.project_upgradeschedulemanage.comment.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.comment.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.comment.entity.Comment;
import com.sparta.project_upgradeschedulemanage.schedule.entity.Schedule;
import com.sparta.project_upgradeschedulemanage.comment.repository.CommentRepository;
import com.sparta.project_upgradeschedulemanage.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    // 생성
   public Comment saveComment(CommentRequestDto commentRequestDto){
       Schedule schedule = scheduleRepository.findById(commentRequestDto.getScheduleId()).orElseThrow(() ->
               new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다."));
       Comment comment = new Comment(commentRequestDto, schedule);

       return commentRepository.save(comment);
   }


    // id로 단건 조회
    public CommentResponseDto getIdInfo(Long id){
        Comment comment = commentRepository.findById(id).orElse(null);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }


    // 전체 댓글 조회
    public List<CommentResponseDto> getComment() {
        // DB 조회
        return commentRepository.findAll().stream().map(CommentResponseDto::new).toList();
    }


    // 수정
    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto){

        Comment comment = findComment(id);
        comment.update(requestDto);

        return id;
    }


    // 삭제
    public Long deleteComment(Long id){

        Comment comment = findComment(id);
        commentRepository.delete(comment);

        return id;
    }


    // Comment에 존재하는 id 유,무 확인
    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다.")
        );
    }
}