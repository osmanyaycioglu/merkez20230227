package com.merkez.training.spring.firstspring.person.services;

import com.merkez.training.spring.firstspring.person.data.PersonDataService;
import com.merkez.training.spring.firstspring.person.data.access.IActivityLogDao;
import com.merkez.training.spring.firstspring.person.facades.PersonDetails;
import com.merkez.training.spring.firstspring.person.facades.PersonOperationFacade;
import com.merkez.training.spring.firstspring.person.services.models.ActivityLogDTO;
import com.merkez.training.spring.firstspring.person.services.models.EPersonStatus;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PersonProvisionService {

//    private List<String>          strings      = new Vector<>();
//    private Map<String,PersonDTO> personDTOMap = new ConcurrentHashMap<>();
//    private AtomicInteger         counter      = new AtomicInteger();

    private PersonDataService     personDataService;
    private PersonOperationFacade personOperationFacade;
    private IActivityLogDao       activityLogDao;


    @Autowired
    public PersonProvisionService(PersonDataService personDataServiceParam,
                                  PersonOperationFacade personOperationFacadeParam,
                                  IActivityLogDao activityLogDaoParam) {
        personDataService = personDataServiceParam;
        personOperationFacade = personOperationFacadeParam;
        activityLogDao = activityLogDaoParam;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    void writeActivity(PersonDTO personDTOParam) {
        activityLogDao.save(ActivityLogDTO.builder()
                                          .withActivity("Add person : " + personDTOParam.getFirstName())
                                          .withLogStr("Person add request : " + personDTOParam)
                                          .build());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    // @Transactional(isolation = Isolation.READ_COMMITTED, noRollbackFor = {NullPointerException.class}, rollbackFor = {IOException.class})
    public void add(PersonDTO personDTOParam) {
        writeActivity(personDTOParam);
        personDataService.insert(personDTOParam);

        PersonDetails personDetails = personOperationFacade.getPersonDetails(personDTOParam);
        if (personDetails == null) {
            throw new IllegalArgumentException("person detayları alınamadı");
        }
    }

    public void activate(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.ACTIVE);
    }

    public void deactivate(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.PASSIVE);
    }

    public void suspend(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.SUSPENDED);
    }

}
