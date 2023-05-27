package com.example.task24.repository;

import com.example.task24.entity.Services;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Services findServicesById(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM service WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Services.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Services service) {
        jdbcTemplate.update("INSERT INTO service (id, code_service, " +
                        "name,price) VALUES(?,?,?,?)",
                    count()+1, service.getCodeService(), service.getName(),
                service.getPrice());
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE from service");
    }

    public void delete(Services services) {
        jdbcTemplate.update("DELETE FROM service WHERE id=?", services.getId());
    }


    public List<Services> findAll() {
        return jdbcTemplate.query("SELECT * from service",
                BeanPropertyRowMapper.newInstance(Services.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM service", Integer.class);

    }
}
