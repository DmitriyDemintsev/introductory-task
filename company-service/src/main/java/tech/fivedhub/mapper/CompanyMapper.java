package tech.fivedhub.mapper;

import org.mapstruct.Mapper;
import tech.fivedhub.dto.CompanyDto;
import tech.fivedhub.model.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toCompanyDto(Company company);
}
