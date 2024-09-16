package com.sparta.project_upgradeschedulemanage.comment.repository;

import com.sparta.project_upgradeschedulemanage.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
}
