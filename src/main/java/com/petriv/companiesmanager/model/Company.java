package com.petriv.companiesmanager.model;

import javax.persistence.*;

@Entity
@Table(name= "companies")
public class Company {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_EARNINGS")
    private int companyEarnings;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyEarnings() {
        return companyEarnings;
    }

    public void setCompanyEarnings(int companyEarnings) {
        this.companyEarnings = companyEarnings;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyEarnings=" + companyEarnings +
                '}';
    }


}
