package com.sinem.utility;

import com.sinem.repository.entity.Company;
import com.sinem.repository.entity.Employee;
import com.sinem.repository.enums.EGender;
import com.sinem.service.CompanyService;
import com.sinem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private  final EmployeeService employeeService;
    private final CompanyService companyService;
    @PostConstruct
    private  void create(){
        saveImplToDatabase();
    }

    private void saveImplToDatabase() {

        Company company1=Company.builder()
                .name("Twitter")
                .type("Technology")
                .address("Newyork")
                .country("USA")
                .build();
        companyService.save(company1);

        Company company2=Company.builder()
                .name("Meta")
                .type("Technology")
                .address("San Francisco")
                .country("USA")
                .build();
        companyService.save(company2);

        Company company3=Company.builder()
                .name("ENOCA")
                .type("Technology")
                .address("Istanbul")
                .country("Turkey")
                .build();
        companyService.save(company3);


        Employee employee1=Employee.builder()
                .name("sezer")
                .surname("Turkmen")
                .email("sezerlucianturkmen@gmail.com")
                .company(company3)
                .gender(EGender.MALE)
                .position("Full Stack Java Developer")
                .address("Istanbul")
                .age(30)
                .build();
        employeeService.save(employee1);

        Employee employee2=Employee.builder()
                .name("John")
                .surname("Smith")
                .email("john@gmail.com")
                .company(company1)
                .gender(EGender.MALE)
                .position("Business Analyst")
                .address("Los Angeles")
                .age(50)
                .build();
        employeeService.save(employee2);

        Employee employee3=Employee.builder()
                .name("Roberta")
                .surname("Ferrari")
                .email("ferrari@gmail.com")
                .company(company1)
                .gender(EGender.FEMALE)
                .position("UX Designer")
                .age(25)
                .address("Roma")
                .build();
        employeeService.save(employee3);

        Employee employee4=Employee.builder()
                .name("Aylin")
                .surname("Yol")
                .email("yolyol@gmail.com")
                .company(company2)
                .gender(EGender.FEMALE)
                .position("BackEnd Developer")
                .age(27)
                .address("Istanbul")
                .build();
        employeeService.save(employee4);

        Employee employee5=Employee.builder()
                .name("Mustafa")
                .surname("Can")
                .email("canmustafa@gmail.com")
                .company(company3)
                .gender(EGender.MALE)
                .position("FrontEnd Developer")
                .age(34)
                .address("Izmir")
                .build();
        employeeService.save(employee5);

    }


}
