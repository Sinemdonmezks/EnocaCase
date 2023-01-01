package com.sinem.mapper;


import com.sinem.dto.request.SaveRequestDto;
import com.sinem.dto.response.GetAllEmployeesResponseDto;
import com.sinem.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;



@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IEmployeeMapper {


    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);


    Employee toEmployee(final SaveRequestDto dto);
    GetAllEmployeesResponseDto toGetAllEmployeesResponseDto(final Employee employee);




}