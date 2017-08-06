package com.petriv.companiesmanager.dao;

import com.petriv.companiesmanager.model.Company;

import java.util.List;

public interface CompanyDao {
    public void addCompany(Company company);
    public void updateCompany (Company company);
    public void removeCompany(int id);
    public Company getCompanyById(int id);
    public List<Company> listCompanies();

}
