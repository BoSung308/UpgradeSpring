package com.sparta.project_upgradeschedulemanage.schedule.repository;

import com.sparta.project_upgradeschedulemanage.schedule.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {

}
