package com.merkez.training.spring.firstspring.person.rest.mappers;

import com.merkez.training.spring.firstspring.person.rest.models.Address;
import com.merkez.training.spring.firstspring.person.rest.models.Person;
import com.merkez.training.spring.firstspring.person.services.models.AddressDTO;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IPersonMapper {

    IPersonMapper mapper = Mappers.getMapper(IPersonMapper.class);

    PersonDTO toPersonDTO(Person person);

    Person toPerson(PersonDTO person);

    List<PersonDTO> toPersonDTOs(List<Person> person);

    List<Person> toPersons(List<PersonDTO> person);

    AddressDTO toAddressDTO(Address addressParam);

    Address toAddress(AddressDTO addressParam);

}
