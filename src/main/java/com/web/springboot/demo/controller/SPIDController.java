package com.web.springboot.demo.controller;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.service.SPIDServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SPIDController {

    SPIDServiceImpl spidService;
    SPIDController(SPIDServiceImpl spidService) {
        this.spidService = spidService;
    }

    private static final Logger log = LoggerFactory.getLogger(SPIDController.class);

    @PostMapping("/create/Spid")
    public ResponseEntity<SPID> addSpid(
            @RequestBody SPID spid) throws Exception {
    log.info(spid.getCreatedBy());
    spidService.addSpid(spid);
    return new ResponseEntity(spid, HttpStatus.OK);
            }

    @GetMapping("/get/Spids")
    public ResponseEntity<Iterable<SPID>> getAllSpids() throws Exception {
        return new ResponseEntity<>(spidService.getAllSpids(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/spid/{id}")
    public ResponseEntity<String> deleteSpid(
            @PathVariable(name = "id") long id) throws Exception {
        spidService.deleteSpid(id);
        return new ResponseEntity("Personi me kte id u fshi", HttpStatus.OK);
    }

    @GetMapping("/spid/{id}")
    public ResponseEntity<SPID> getSpid(
            @PathVariable(name = "id") long id
    ) throws Exception {
        return new ResponseEntity(spidService.findSpidById(id), HttpStatus.OK);
    }

    @GetMapping("/spid/changeStatus/{id}")
    public ResponseEntity<SPID> changeStatus(
            @PathVariable(name = "id") long id) throws Exception {
        return new ResponseEntity(spidService.changeSpidStatus(id), HttpStatus.OK);
    }



}

