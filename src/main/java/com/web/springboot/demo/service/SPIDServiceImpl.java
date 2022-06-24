package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.SPIDRepository;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SPIDServiceImpl implements SPIDService {

    @Autowired
    private SPIDRepository spidRepository;

    @Override
    public SPID addSpid(SPID spid) {
       return spidRepository.save(spid);
    }

    @Override
    public List<SPID> getAllSpids() {
        return null;
    }

    @Override
    public SPID getSpidByUserId(SPID spidId, User user) {
        SPID spid = getSpid(spidId);
        spid.getUserId();
        return spid;
    }

    @Override
    public SPID changeSpidStatus(SPID spid) {
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidRepository.save(spid);
    }

    @Override
    public SPID deleteSpid(SPID spid) {
        if (spid.getStatus() != Status.PENDING) {
            System.out.println("Status is PENDING :(");
        }
        spidRepository.delete(spid);
        return spid;
    }

    @Override
    public SPID getSpid(SPID spids) {
       List<SPID> spid = (List<SPID>) spidRepository.findAll();
       return (SPID) spid;
    }



}
