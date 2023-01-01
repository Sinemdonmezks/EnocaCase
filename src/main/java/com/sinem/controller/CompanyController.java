package com.sinem.controller;

import com.sinem.dto.request.CreateCompanyRequestDto;
import com.sinem.dto.request.DeleteCompanyRequestDto;
import com.sinem.dto.request.UpdateCompanyRequestDto;
import com.sinem.dto.response.CreateCompanyResponseDto;
import com.sinem.dto.response.GetAllCompaniesResponseDto;
import com.sinem.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sinem.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;


    @PostMapping(SAVE)
    public ResponseEntity<CreateCompanyResponseDto> createCompany(@RequestBody CreateCompanyRequestDto dto){
            return ResponseEntity.ok(companyService.createCompany(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateCompany(@RequestBody UpdateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }

    @DeleteMapping(DELETE)
    public  ResponseEntity<Boolean> delete(@RequestBody DeleteCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.deleteEmployee(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<GetAllCompaniesResponseDto>> findAll(){
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

}
