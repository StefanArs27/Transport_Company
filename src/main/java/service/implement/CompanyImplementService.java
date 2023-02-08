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

        System.out.println("Enter name of company: ");
        company.setName(scanner.nextLine());

        System.out.println("Enter initial earnings: ");
        company.setEarnings(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        CompanyDAO.saveCompany(company);
    }

    @Override
    public void modifyCompany() {
        System.out.println("Enter id of company:");
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

    }

    @Override
    public Company selectCompany() {
        System.out.println("Enter id of company:");
        System.out.println(CompanyDAO.getCompany(Long.parseLong(scanner.nextLine())) + " was chosen.");
        return CompanyDAO.getCompany(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public List<Company> sortCompaniesByName() {
        List<Company> companies = new ArrayList<>();

        System.out.println("Choose options: ");
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
        return companies;
    }

    @Override
    public List<Company> sortCompaniesByEarnings() {
        List<Company> companies = new ArrayList<>();

        System.out.println("Choose options: ");
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
        return companies;
    }

    @Override
    public void removeCompany() {
        System.out.println("Enter id of the company you want to remove: ");
        Company company = CompanyDAO.getCompany(Long.parseLong(scanner.nextLine()));
        CompanyDAO.deleteCompany(company);
        System.out.println("Company -> " + company.getId() + " " + company.getName() + " is removed.");
    }
}
