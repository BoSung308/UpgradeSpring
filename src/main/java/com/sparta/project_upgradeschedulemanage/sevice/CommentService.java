package com.sparta.project_upgradeschedulemanage.sevice;


import com.sparta.project_upgradeschedulemanage.dto.CommentRequestDto;
import com.sparta.project_upgradeschedulemanage.dto.CommentResponseDto;
import com.sparta.project_upgradeschedulemanage.entity.Comment;
import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import com.sparta.project_upgradeschedulemanage.repository.CommentRepository;
import com.sparta.project_upgradeschedulemanage.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

   public Comment saveComment(Comment comment){
       return commentRepository.save(comment);
   }
//    }public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
//
//        Schedule schedule = scheduleRepository.findById(commentRequestDto.getSchedule_id()).orElseThrow(()
//                -> new IllegalArgumentException("Schedule id 값이 유효하지 않습니다."));
//
//        // RequestDto to Entity
//        Comment comment = new Comment(commentRequestDto);
//        comment.setSchedule(schedule);
//
//        // DB 저장
//        commentRepository.save(comment);
//
//        // Entity to ResponseDto
//        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
//        return commentResponseDto;
//    }


    public CommentResponseDto getIdInfo1(Long id){
        Comment comment = commentRepository.findById(id).orElse(null);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }


    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto){
        Comment comment = findComment(id);

        comment.update(requestDto);

        return id;
    }

    public Long deleteComment(Long id){
        Comment comment = findComment(id);

        commentRepository.delete(comment);

        return id;
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 데이터는 확인할 수 없습니다.")
        );
    }


}