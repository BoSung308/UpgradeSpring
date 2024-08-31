package com.sparta.project_upgradeschedulemanage.repository;


import com.sparta.project_upgradeschedulemanage.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


}

