package com.petriv.companiesmanager.dao;

import com.petriv.companiesmanager.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CompanyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(company);
        logger.info("company added" + company);
    }

    @Override
    public void updateCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(company);
        logger.info("company updated" + company);
    }

    @Override
    public void removeCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company company = (Company) session.load(Company.class, new Integer(id));
        if (company != null) {
            session.delete(company);
        }
        logger.info("Company removed.Company details" + company);
    }

            @Override
            public Company getCompanyById (int id){
                Session session = this.sessionFactory.getCurrentSession();
                Company company = (Company) session.load(Company.class, new Integer(id));
                logger.info("Company loaded.Company details:" +company);
            return company;
            }



            @Override
            @SuppressWarnings("unchecked")
            public List<Company> listCompanies () {
                Session session = this.sessionFactory.getCurrentSession();
                List<Company> companyList = session.createQuery("from Company").list();

                for (Company company: companyList){
                    logger.info("Company list:" +company);
                }
                return companyList;
            }
        }
