package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SpidService {

    //Create new SPID
    public SPID createService(SPID spid){
        SPID savedSPID = new SPID(
                spid.getId(),
                spid.getModifiedAt(),
                spid.getCreatedAt(),
                spid.getDescription(),
                spid.getStatus(),
                spid.getUser());
        return savedSPID;
    }

    //Edit SPID and changing status to approved
    public static void editSPID(SPID spid, int id, Date createdAt, Date modifiedAt, String description, Status status, User user) {

       spid.setId(id);
       spid.setCreatedAt(createdAt);
       spid.setModifiedAt(modifiedAt);
       spid.setDescription(description);
       spid.setStatus(status.APPROVED);
       spid.setUser(user);
    };



}
