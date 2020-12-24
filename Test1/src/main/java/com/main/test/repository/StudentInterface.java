package com.main.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.test.entity.StudentTable;
@Repository
public interface StudentInterface extends CrudRepository<StudentTable, Integer> {
    
}
