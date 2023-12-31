package com.example.train.service.impl;

import com.example.train.model.Donor;
import com.example.train.model.Schedule;
import com.example.train.repository.ScheduleRepository;
import com.example.train.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ScheduleImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public Schedule saveSchedule(Schedule schedule){
        log.info("Saving donor {} to the database", schedule.getScheduleId());
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> getSchedules(){
        log.info("Get all schedules from database");
        return scheduleRepository.findAll();
    }
    public Schedule getSchedule(Long id){
        log.info("Get {} user from database",id);
        return scheduleRepository.findById(id).get();
    }
    public void deleteSchedule(Long id){
        log.info("Delete user {} from database",id);
        scheduleRepository.deleteById(id);
    }
}
