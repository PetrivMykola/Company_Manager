package com.petriv.companiesmanager.controller;


import com.petriv.companiesmanager.model.Company;
import com.petriv.companiesmanager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
    private CompanyService companyService;


    @Autowired(required = true)
    @Qualifier(value = "companyService")
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String listCompanies(Model model){
        model.addAttribute("company", new Company());
        model.addAttribute("listCompanies", this.companyService);

        return "companies";
    }

    @RequestMapping(value = "/companies/add", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute("company") Company company){
        if(company.getId() == 0){
            this.companyService.addCompany(company);
        }else{
            this.companyService.updateCompany(company);
        }
        return "redirect:/companies";
    }

    @RequestMapping("/remove/{id}")
    public String removeCompany (@PathVariable("id") int id){
        this.companyService.removeCompany(id);
        return "redirect:/companies";
    }

    @RequestMapping("/edit/{id}")
    public String editCompanies(@PathVariable("id") int id, Model model){
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        return "companies";
    }

    @RequestMapping("/companydata/{id}")
    public String companyData(@PathVariable("id") int id, Model model){
        model.addAttribute("company", this.companyService.getCompanyById(id));
        return "companydata";
    }
}

