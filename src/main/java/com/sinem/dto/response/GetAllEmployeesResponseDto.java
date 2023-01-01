package com.sinem.dto.response;

import com.sinem.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllEmployeesResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String position;
    private int age;
    private String email;
    private String address;
    private EGender gender;
    private Long companyId;
    private String companyName;
}
