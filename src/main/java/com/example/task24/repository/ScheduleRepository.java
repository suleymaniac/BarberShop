package com.example.task24.repository;

import com.example.task24.entity.Schedule;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Schedule schedule) {
        jdbcTemplate.update("INSERT INTO schedule (id, date, " +
                        "time,service,full_name_client,phone_client," +
                        "employee_id) VALUES(?,?,?,?,?,?,?)",
                count()+1, schedule.getDate(), schedule.getTime(),schedule.getService(),
                schedule.getFullNameClient(),schedule.getPhoneClient(),
                schedule.getEmployeeId()
        );
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE from schedule");
    }

    public void delete(Schedule schedule) {
        jdbcTemplate.update("DELETE FROM schedule WHERE id=?",
                schedule.getId());
    }


    public List<Schedule> findAll() {
        return jdbcTemplate.query("SELECT * from schedule",
                BeanPropertyRowMapper.newInstance(Schedule.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM schedule", Integer.class);

    }

    public Schedule findScheduleById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM schedule WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Schedule.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
