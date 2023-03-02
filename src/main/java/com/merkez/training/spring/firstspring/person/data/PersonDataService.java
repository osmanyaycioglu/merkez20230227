package com.merkez.training.spring.firstspring.person.data;

import com.merkez.training.spring.firstspring.person.data.access.IPersonDao;
import com.merkez.training.spring.firstspring.person.services.models.EPersonStatus;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataService {

    private IPersonDao personDao;

    @Autowired
    public PersonDataService(IPersonDao personDaoParam) {
        personDao = personDaoParam;
    }

    public void insert(PersonDTO personDTOParam) {
        personDao.save(personDTOParam);
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
