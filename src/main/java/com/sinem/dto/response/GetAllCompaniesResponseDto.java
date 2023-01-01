package com.sinem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllCompaniesResponseDto {
    private Long id;
    private String name;
    private String type;
    private String country;
    private String address;
}
