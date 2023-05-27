package com.example.task24.repository;

import com.example.task24.entity.Employee;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee findEmployeeById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM employee WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Employee.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (id, full_name, " +
                        "passport,address,phone,salary,shift,job_title) VALUES(?,?,?,?,?,?,?,?)",
                count()+1, employee.getFullName(),employee.getPassport(), employee.getAddress(),
                employee.getPhone(), employee.getSalary(),employee.getShift(),employee.getJobTitle());
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM employee");
    }

    public void delete(Employee emp) {
        jdbcTemplate.update("DELETE FROM employee WHERE id=?", emp.getId());
    }


    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                BeanPropertyRowMapper.newInstance(Employee.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM employee", Integer.class);
    }
}
