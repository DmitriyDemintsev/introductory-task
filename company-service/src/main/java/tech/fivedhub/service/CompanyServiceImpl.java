package tech.fivedhub.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.fivedhub.exception.CompanyNotFoundException;
import tech.fivedhub.model.Company;
import tech.fivedhub.repository.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
    }

    @Override
    public Company getCompanyByName(String nameCompany) {
        return companyRepository.findByNameCompany(nameCompany)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
    }
}
