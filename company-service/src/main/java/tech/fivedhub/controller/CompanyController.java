package tech.fivedhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.fivedhub.dto.CompanyDto;
import tech.fivedhub.mapper.CompanyMapper;
import tech.fivedhub.service.CompanyService;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping("/{id}")
    public CompanyDto getCompanyDtoById(@PathVariable Long companyId) {
        return companyMapper.toCompanyDto(companyService.getCompanyById(companyId));
    }

    @GetMapping("/{nameCompany}")
    public CompanyDto getCompanyDtoByName(@PathVariable String nameCompany) {
        return companyMapper.toCompanyDto(companyService.getCompanyByName(nameCompany));
    }
}
