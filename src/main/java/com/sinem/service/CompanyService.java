package com.sinem.service;

import com.sinem.dto.request.CreateCompanyRequestDto;
import com.sinem.dto.request.DeleteCompanyRequestDto;
import com.sinem.dto.request.UpdateCompanyRequestDto;
import com.sinem.dto.response.CreateCompanyResponseDto;
import com.sinem.dto.response.GetAllCompaniesResponseDto;
import com.sinem.exception.ErrorType;
import com.sinem.exception.ManagerException;
import com.sinem.mapper.ICompanyMapper;
import com.sinem.repository.ICompanyRepository;
import com.sinem.repository.entity.Company;
import com.sinem.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService extends ServiceManager<Company,Long> {

    private final ICompanyRepository companyRepository;


    public CompanyService(ICompanyRepository companyRepository){
        super(companyRepository);
        this.companyRepository=companyRepository;

    }
    public CreateCompanyResponseDto createCompany(CreateCompanyRequestDto dto) {
        try{
            Company company= companyRepository.save(ICompanyMapper.INSTANCE.toCompany(dto));
            return ICompanyMapper.INSTANCE.toCreateCompanyResponseDto(company);
        }catch (Exception e) {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_CREATED);
        }
    }
    public boolean updateCompany(UpdateCompanyRequestDto dto) {
        try{
           Optional<Company> company=companyRepository.findById(dto.getId());
           if(company.isPresent()) {
               company.get().setName(dto.getName());
               company.get().setAddress(dto.getAddress());
               company.get().setType(dto.getType());
               company.get().setCountry(dto.getCountry());
               save(company.get());
               return true;
           }else {
               throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
           }
        }catch (Exception e) {
            throw new ManagerException(ErrorType.COMPANY_NOT_UPDATED);
        }
    }
    public boolean deleteEmployee(DeleteCompanyRequestDto dto) {
        Optional<Company> company=companyRepository.findById(dto.getId());
        if(company.isPresent()){
            deleteById(company.get().getId());

            return true;
        }else {
            throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }
    public List<GetAllCompaniesResponseDto> findAllCompanies() {
        List<Company> companies=findAll();
        return companies.stream().map(x-> ICompanyMapper.INSTANCE.toGetAllCompaniesResponseDto(x)).collect(Collectors.toList());
    }
}
