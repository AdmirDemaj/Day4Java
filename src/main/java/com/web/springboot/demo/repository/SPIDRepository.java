package com.web.springboot.demo.repository;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SPIDRepository extends CrudRepository<SPID, Long> {

    List<SPID> findSpidByUserId(User user);

}
