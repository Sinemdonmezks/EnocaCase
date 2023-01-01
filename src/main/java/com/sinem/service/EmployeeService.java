package com.sinem.service;

import com.sinem.dto.request.DeleteEmployeRequestDto;
import com.sinem.dto.request.SaveRequestDto;
import com.sinem.dto.request.UpdateEmployeeRequestDto;
import com.sinem.dto.response.GetAllEmployeesResponseDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ManagerException;
import com.sinem.repository.IEmployeeRepository;
import com.sinem.repository.entity.Employee;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {

    private final IEmployeeRepository employeeRepository;
    private  final CompanyService companyService;

    public EmployeeService(IEmployeeRepository employeeRepository,CompanyService companyService){
        super(employeeRepository);
        this.employeeRepository=employeeRepository;
        this.companyService=companyService;
    }
    public boolean saveEmployee(SaveRequestDto dto) {
        try{
            Employee employee=save(Employee.builder()
                            .name(dto.getName())
                            .surname(dto.getSurname())
                            .age(dto.getAge())
                            .address(dto.getAddress())
                            .email(dto.getEmail())
                            .position(dto.getPosition())
                            .gender(dto.getGender())
                            .company(companyService.findById(dto.getCompanyId()).get())
                            .build());
            return true;
         }catch (Exception e) {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_CREATED);
         }
    }
    public boolean updateEmployee(UpdateEmployeeRequestDto dto) {
        try {
            Optional<Employee> employee = findById(dto.getId());

            if (employee.isPresent()) {
                employee.get().setName(dto.getName());
                employee.get().setSurname(dto.getSurname());
                employee.get().setAge(dto.getAge());
                employee.get().setAddress(dto.getAddress());
                employee.get().setEmail(dto.getEmail());
                employee.get().setPosition(dto.getPosition());
                employee.get().setGender(dto.getGender());
                employee.get().setCompany(companyService.findById(dto.getCompanyId()).get());
                save(employee.get());
                return true;
        }else{
                throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
            }
        }catch (Exception e) {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_UPDATED);
        }
    }

    public boolean deleteEmployee(DeleteEmployeRequestDto dto) {
        Optional<Employee> employee=employeeRepository.findById(dto.getId());
        if(employee.isPresent()){
            deleteById(employee.get().getId());
            return true;
        }else {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
        }
    }

    public List<GetAllEmployeesResponseDto> findAllEmployees() {
        List<Employee> employees=findAll();
        return employees.stream().map(x-> GetAllEmployeesResponseDto.builder().id(x.getId()).name(x.getName()).surname(x.getSurname()).address(x.getAddress()).gender(x.getGender())
                .email(x.getEmail()).age(x.getAge()).position(x.getPosition()).companyId(x.getCompany().getId()).companyName(x.getCompany().getName()).build()
        ).collect(Collectors.toList());
    }


}

