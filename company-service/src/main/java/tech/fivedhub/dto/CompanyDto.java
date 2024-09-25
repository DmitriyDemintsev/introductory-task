package tech.fivedhub.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {

    private Long companyId;
    private String nameCompany;
    private Long budget;
    private List<Long> employees;
}
