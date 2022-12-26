package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.CV;
import com.cvtheque.cvtheque.repositories.CVRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
@Service
public class CVServiceImp implements CVService {
    public HttpStatusCode getCvByLearnerId;
    @Autowired
    private CVRepo cvRepo;

    public CVServiceImp(CVRepo cvRepo) {
        this.cvRepo = cvRepo;
    }

    @Override
    public CV saveCv(CV cv) {
        return cvRepo.save(cv);
    }

    @Override
    public CV updateCv(CV cv) {
        return cvRepo.save(cv);
    }

    @Override
    public void deleteCv(CV cv) {
        cvRepo.delete(cv);
    }

    @Override
    public CV getCvById(int id) {
        return cvRepo.findById(id).get();
    }

    @Override
    public Iterable<CV> getAllCv() {
        return cvRepo.findAll();
    }
    
    // get cv by learner id
    
    public CV getCvByLearnerId(int id) {
        return cvRepo.findByLearnerId(id);
    }
}
