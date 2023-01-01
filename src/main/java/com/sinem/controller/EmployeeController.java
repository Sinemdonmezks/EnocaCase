package com.sinem.controller;

import com.sinem.dto.request.DeleteEmployeRequestDto;
import com.sinem.dto.request.SaveRequestDto;
import com.sinem.dto.request.UpdateEmployeeRequestDto;
import com.sinem.dto.response.GetAllEmployeesResponseDto;
import com.sinem.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import  static com.sinem.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping(SAVE)
    public ResponseEntity<Boolean> saveEmployee(@RequestBody @Valid SaveRequestDto dto){
            return ResponseEntity.ok(employeeService.saveEmployee(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateEmployee(@RequestBody @Valid UpdateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.updateEmployee(dto));
    }

    @DeleteMapping(DELETE)
    public  ResponseEntity<Boolean> delete(@RequestBody DeleteEmployeRequestDto dto) {
        return ResponseEntity.ok(employeeService.deleteEmployee(dto));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<GetAllEmployeesResponseDto>> findAll(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }


}
