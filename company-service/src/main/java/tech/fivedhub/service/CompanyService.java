package tech.fivedhub.service;

import tech.fivedhub.model.Company;

public interface CompanyService {

    Company getCompanyById(Long companyId);

    Company getCompanyByName(String nameCompany);
}
