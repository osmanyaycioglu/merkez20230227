package com.merkez.training.spring.firstspring.person.data.access;

import com.merkez.training.spring.firstspring.person.services.models.EPersonStatus;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPersonDao extends JpaRepository<PersonDTO, Long> {

    List<PersonDTO> findByLastName(String lastName);

    List<PersonDTO> findByLastNameIn(List<String> lastName);

    List<PersonDTO> findByFirstNameAndLastName(String firstName,
                                               String lastName);

    List<PersonDTO> findByFirstNameAndLastNameOrderByFirstName(String firstName,
                                                               String lastName);

    List<PersonDTO> findByAgeBetween(int min,
                                     int max);

    List<PersonDTO> findByLastNameLike(String lastName);

    List<PersonDTO> findByLastNameStartsWith(String st);

    @Query("select p from PersonDTO p where p.lastName=?1")
    List<PersonDTO> searchLastName(String lastName);

    @Query(value = "select * from person p where p.lastName=?1", nativeQuery = true)
    List<PersonDTO> searchLastNameNative(String lastName);

    @Query("select p.lastName from PersonDTO p where p.lastName=?1")
    List<String> searchLastNameAndGetLastName(String lastName);

    @Modifying
    @Transactional
    @Query("update PersonDTO p set p.personStatus =?2 where p.personId=?1")
    void updatePersonStatus(Long personId,EPersonStatus personStatusParam);
}
