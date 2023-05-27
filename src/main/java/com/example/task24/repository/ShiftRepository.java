package com.example.task24.repository;

import com.example.task24.entity.Services;
import com.example.task24.entity.Shift;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ShiftRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShiftRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Shift findShiftById(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM shift WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Shift.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Shift shift) {
        jdbcTemplate.update("INSERT INTO shift (id, code, " +
                        "name) VALUES(?,?,?)",
                count()+1, shift.getCode(), shift.getName());
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE from shift");
    }

    public void delete(Shift shift) {
        jdbcTemplate.update("DELETE FROM shift WHERE id=?",
                shift.getId());
    }


    public List<Shift> findAll() {
        return jdbcTemplate.query("SELECT * from shift",
                BeanPropertyRowMapper.newInstance(Shift.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM shift", Integer.class);

    }
}
