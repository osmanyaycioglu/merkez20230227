package com.merkez.training.spring.firstspring.person.rest.mappers;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPersonMapper {

    IPersonMapper mapper = Mappers.getMapper(IPersonMapper.class);

    PersonDTO toPersonDTO(Person person);

    Person toPerson(PersonDTO person);

}
