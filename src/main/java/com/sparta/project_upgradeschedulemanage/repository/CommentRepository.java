package com.sparta.project_upgradeschedulemanage.repository;

import com.sparta.project_upgradeschedulemanage.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
}
