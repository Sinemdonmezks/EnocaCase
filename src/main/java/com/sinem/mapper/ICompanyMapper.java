package com.sinem.mapper;

import com.sinem.dto.request.CreateCompanyRequestDto;
import com.sinem.dto.response.CreateCompanyResponseDto;
import com.sinem.dto.response.GetAllCompaniesResponseDto;
import com.sinem.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICompanyMapper {


    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompany (final CreateCompanyRequestDto dto);
    CreateCompanyResponseDto toCreateCompanyResponseDto(final Company company);
    GetAllCompaniesResponseDto toGetAllCompaniesResponseDto(final Company company);






}