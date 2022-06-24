package com.web.springboot.demo.service;


import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SPIDService {
    public SPID addSpid(SPID spid);
    public List<SPID> getAllSpids();
    public SPID getSpidByUserId(SPID spidId, User user);
    public SPID changeSpidStatus(SPID spid);
    public SPID deleteSpid(SPID spid);
    public SPID getSpid(SPID spid);

}
