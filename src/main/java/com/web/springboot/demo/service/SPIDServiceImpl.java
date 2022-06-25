package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.SPIDRepository;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SPIDServiceImpl implements SPIDService {


    @Autowired
    private SPIDRepository spidRepository;

    @Transactional
    @Override
    public SPID addSpid(SPID spid) throws Exception{
        Optional<SPID> findIfSpidExists = spidRepository.findById(spid.getId());
        if(!(findIfSpidExists.isPresent())){
            return spidRepository.save(spid);
        }
        throw new RuntimeException("User exists");
    }

    @Override
    public Iterable<SPID> getAllSpids() throws Exception {
        List<SPID> spid = (List<SPID>) spidRepository.findAll();
        if(spid.isEmpty()){
            throw new Exception("No Spid Foundd");
        }
        return spidRepository.findAll();
    }


    @Override
    public List<SPID> getSpidByUserId(User user) {
        return spidRepository.findSpidByUserId(user);
    }

    @Override
    public SPID changeSpidStatus(long id) throws Exception {
        Optional<SPID> findIfSpidExists = spidRepository.findById(id);
        SPID spid = findSpidById(id);
        if(!(findIfSpidExists.isPresent())){
            throw new Exception("This SPID does not exist and status can not be changed");
        }
        spid.setStatus(Status.PENDING);
        return spidRepository.save(spid);
    }

    @Override
    public void deleteSpid(long id) throws Exception{
        Optional<SPID> findIfSpidExists = spidRepository.findById(id);

        if(findIfSpidExists.isEmpty()){
            throw new Exception("Spid me kete Id nuk egziston");
        }
        spidRepository.deleteById(id);
    }

    @Override
    public SPID getSpid(SPID spids) throws Exception {
        List<SPID> spid = (List<SPID>) spidRepository.findAll();
        if (!(spid.size() <= 0)) {
            return spid.get(0);
        }
        throw new Exception("SPID doesn't exist");
    }

    @Override
    public SPID findSpidById(long id) throws Exception {
        Optional<SPID> spid = spidRepository.findById(id);
        if(spid.isPresent()){
            return spid.get();
        }
        throw new Exception("Spid with this Id does not exist");
    }


}
