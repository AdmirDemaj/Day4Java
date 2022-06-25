package com.web.springboot.demo.service;


import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SPIDService {
    public SPID addSpid(SPID spid) throws Exception;
    public Iterable<SPID> getAllSpids() throws Exception;
    public List<SPID> getSpidByUserId(User user);
    public SPID changeSpidStatus(long id) throws Exception;
    public void deleteSpid(long id) throws Exception;
    public SPID getSpid(SPID spid) throws Exception;

    public SPID findSpidById(long id) throws Exception;

}
