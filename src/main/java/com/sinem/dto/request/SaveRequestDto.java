package com.sinem.dto.request;

import com.sinem.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveRequestDto {
    private String name;
    private String surname;
    private String position;
    private int age;
    @Email(message = "E mail formata uygun deðil")
    @NotBlank
    private String email;
    private String address;
    private Long companyId;
    private EGender gender;
}
