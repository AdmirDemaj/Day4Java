package com.web.springboot.demo.service;

import com.web.springboot.demo.controller.SPIDController;
import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.Type;
import com.web.springboot.demo.repository.SPIDRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = {SPIDController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SPIDControllerTest {

    SPIDRepository spidRepository;

    @Test
    void addSpid() {
        SPID spid = new SPID();
        spid.setId(2L);
        spid.setStatus(Status.READY_FOR_REVIEW);
        spid.setCreatedBy("test");
        spid.setType(Type.LEVEL_1);
        spid.setCreatedAt(LocalDateTime.now());
    }

    @Test
    void changeSpidStatus() {
        SPID spid = spidRepository.findById(2L).get();
        spid.setStatus(Status.PENDING);
        spidRepository.save(spid);
    }

    @Test
    void deleteSpid() {
        SPID spid = spidRepository.findById(2L).get();
        spidRepository.delete(spid);
    }

}
