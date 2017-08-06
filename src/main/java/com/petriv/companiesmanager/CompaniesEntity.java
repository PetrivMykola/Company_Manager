package com.petriv.companiesmanager;

import javax.persistence.*;

@Entity
@Table(name = "companies", schema = "companymanager", catalog = "")
public class CompaniesEntity {
    private int id;
    private String companyName;
    private int companyEarnings;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "COMPANY_EARNINGS")
    public int getCompanyEarnings() {
        return companyEarnings;
    }

    public void setCompanyEarnings(int companyEarnings) {
        this.companyEarnings = companyEarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniesEntity that = (CompaniesEntity) o;

        if (id != that.id) return false;
        if (companyEarnings != that.companyEarnings) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + companyEarnings;
        return result;
    }
}
