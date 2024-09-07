package com.sparta.project_upgradeschedulemanage.repository;


import com.sparta.project_upgradeschedulemanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

}
