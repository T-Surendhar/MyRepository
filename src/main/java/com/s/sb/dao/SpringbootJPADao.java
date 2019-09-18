package com.s.sb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.s.sb.entity.Student;

@Repository
public interface SpringbootJPADao extends JpaRepository<Student, Integer>{

}
