package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SPIDServiceImpl.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SPIDServiceImplTest {

    @Mock
    SPIDServiceImpl spidService;

    @BeforeAll
    public void setup() {
        SPID spid = new SPID();
        spid.setId(1);
        spid.setStatus(Status.READY_FOR_REVIEW);

    }
}