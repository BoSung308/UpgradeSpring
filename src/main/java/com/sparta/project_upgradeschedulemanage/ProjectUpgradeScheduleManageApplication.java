package com.sparta.project_upgradeschedulemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectUpgradeScheduleManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUpgradeScheduleManageApplication.class, args);
    }

}
