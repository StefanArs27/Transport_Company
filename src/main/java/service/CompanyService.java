package service;

import company.Company;

import java.util.List;

public interface CompanyService {

    void addCompany();

    void modifyCompany();
    Company selectCompany();
    List<Company> sortCompaniesByName();
    List<Company> sortCompaniesByEarnings();

    void removeCompany();

}
