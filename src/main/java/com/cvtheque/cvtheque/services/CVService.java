package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.CV;
import com.cvtheque.cvtheque.repositories.CVRepo;

public interface CVService {
    CV saveCv(CV cv);
    CV updateCv(CV cv);
    void deleteCv(CV cv);
    CV getCvById(int id);
    Iterable<CV> getAllCv();
}

