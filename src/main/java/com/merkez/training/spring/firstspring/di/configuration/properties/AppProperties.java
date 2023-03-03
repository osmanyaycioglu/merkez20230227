package com.merkez.training.spring.firstspring.di.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.merkez.training.spring.firstspring.person.rest.models.Person;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("my.app")
public class AppProperties {

    private String              name = "app";
    private String              version;
    private Integer             build;
    private String              city;
    private String              street;
    private Person              owner;
    private String              country;
    private List<String>        otherNames;
    private List<Person>        personList;
    private Map<String, Person> personMap;
    private String              taskCron;

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public Integer getBuild() {
        return this.build;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public void setBuild(final Integer build) {
        this.build = build;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public void setOwner(final Person owner) {
        this.owner = owner;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String countryParam) {
        country = countryParam;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNamesParam) {
        otherNames = otherNamesParam;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personListParam) {
        personList = personListParam;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMapParam) {
        personMap = personMapParam;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
               "name='" + name + '\'' +
               ", version='" + version + '\'' +
               ", build=" + build +
               ", city='" + city + '\'' +
               ", street='" + street + '\'' +
               ", owner=" + owner +
               ", country='" + country + '\'' +
               ", otherNames=" + otherNames +
               ",\n personList=" + personList +
               ",\n personMap=" + personMap +
               '}';
    }

    public String getTaskCron() {
        return taskCron;
    }

    public void setTaskCron(String taskCronParam) {
        taskCron = taskCronParam;
    }
}
