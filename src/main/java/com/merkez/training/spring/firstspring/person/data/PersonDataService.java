package com.merkez.training.spring.firstspring.person.data;

import com.merkez.training.spring.firstspring.person.data.access.IActivityLogDao;
import com.merkez.training.spring.firstspring.person.data.access.IPersonDao;
import com.merkez.training.spring.firstspring.person.services.models.ActivityLogDTO;
import com.merkez.training.spring.firstspring.person.services.models.EPersonStatus;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import com.merkez.training.spring.firstspring.person.services.models.PhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PersonDataService {

    private IPersonDao      personDao;
    private IActivityLogDao activityLogDao;

    @Autowired
    public PersonDataService(IPersonDao personDaoParam,
                             IActivityLogDao activityLogDaoParam) {
        personDao = personDaoParam;
        activityLogDao = activityLogDaoParam;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(PersonDTO personDTOParam) {
        Set<PhoneDTO> phones = personDTOParam.getPhones();
        for (PhoneDTO phone : phones) {
            phone.setPersonDTO(personDTOParam);
        }
        personDao.save(personDTOParam);
        activityLogDao.save(ActivityLogDTO.builder()
                                          .withActivity("New person : " + personDTOParam.getFirstName())
                                          .withLogStr("New person added with " + personDTOParam)
                                          .build());
    }

    public void update(PersonDTO personDTOParam) {
        personDao.save(personDTOParam);
    }

    public void updateStatus(Long personId,
                             EPersonStatus personStatusParam) {
        personDao.updatePersonStatus(personId,
                                     personStatusParam);
    }


    public PersonDTO findPerson(long personId) {
        return personDao.findById(personId)
                        .orElse(null);
    }

    public List<PersonDTO> findAllPersons() {
        return personDao.findAll();
    }

    public List<PersonDTO> findPersonByLastName(String lastName) {
        return personDao.findByLastName(lastName);
    }


}
