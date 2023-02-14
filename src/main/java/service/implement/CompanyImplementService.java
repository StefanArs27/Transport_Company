package service.implement;

import company.Company;
import dao.CompanyDAO;
import service.CompanyService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyImplementService implements CompanyService {

    private Scanner scanner;

    public CompanyImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addCompany() {
        Company company = new Company();

        System.out.println("\nEnter name of company: ");
        company.setName(scanner.nextLine());

        System.out.println("Enter initial earnings: ");
        company.setEarnings(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        CompanyDAO.saveCompany(company);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void modifyCompany() {
        System.out.println("\nEnter id of company:");
        Company company = CompanyDAO.getCompany(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose what to modify:");
        System.out.println("1 -> name");
        System.out.println("2 -> initial earnings");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                company.setName(scanner.nextLine());
                break;
            case 2:
                company.setEarnings(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
                break;
            default:
                break;
        }

        CompanyDAO.saveOrUpdateCompany(company);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void selectCompany() {
        System.out.println("\nEnter id of company:");
        Company company = CompanyDAO.getCompany(Long.parseLong(scanner.nextLine()));
        System.out.println("Company" + company.getId() + " was chosen -> " + company);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void readCompanies() {
        List<Company> companyList = CompanyDAO.readCompanies();

        System.out.println("\nList of Companies: ");
        companyList.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }


    @Override
    public void sortCompaniesByName() {
        List<Company> companies = new ArrayList<>();

        System.out.println("\nChoose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                companies = CompanyDAO.companiesByNameAsc();
                break;
            case 2:
                companies = CompanyDAO.companiesByNameDesc();
                break;
            default:
                System.out.println("Nothing will be done to the company table.");
                break;
        }

        System.out.println("Company list sorted: ");
        companies.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void sortCompaniesByEarnings() {
        List<Company> companies = new ArrayList<>();

        System.out.println("\nChoose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                companies = CompanyDAO.companiesByEarningsAsc();
                break;
            case 2:
                companies = CompanyDAO.companiesByEarningsDesc();
                break;
            default:
                System.out.println("Nothing will be done to the company table.");
                break;
        }

        System.out.println("Company list sorted: ");
        companies.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void removeCompany() {
        System.out.println("\nEnter id of the company you want to remove: ");
        Company company = CompanyDAO.getCompany(Long.parseLong(scanner.nextLine()));
        CompanyDAO.deleteCompany(company);
        System.out.println("Company -> " + company.getId() + " " + company.getName() + " is removed.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }
}
