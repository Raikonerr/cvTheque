package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.controllers.CmeController;
import com.cvtheque.cvtheque.models.Cme;
import com.cvtheque.cvtheque.repositories.CmeRepo;
import org.springframework.stereotype.Service;

@Service
public class CmeService {

    private CmeRepo cmeRepo;

    public CmeService(CmeRepo cmeRepo){
        this.cmeRepo = cmeRepo;
    }
}
