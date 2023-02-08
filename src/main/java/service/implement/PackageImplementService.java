package service.implement;

import company.Package;
import company.TypeOfPackage;
import dao.PackageDAO;
import dao.VehicleDAO;
import service.PackageService;

import java.math.BigDecimal;
import java.util.Scanner;

public class PackageImplementService implements PackageService {
    private Scanner scanner;

    public PackageImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addPackage() {
        Package pac = new Package();

        System.out.println("Enter name of package:");
        pac.setName(scanner.nextLine());

        System.out.println("Enter type of package:");
        System.out.println("1 -> NORMAL");
        System.out.println("2 -> FRAGILE");
        System.out.println("3 -> SPECIAL");
        System.out.println("0 -> EXIT");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                pac.setTypeOfPackage(TypeOfPackage.NORMAL);
                break;
            case 2:
                pac.setTypeOfPackage(TypeOfPackage.FRAGILE);
                break;
            case 3:
                pac.setTypeOfPackage(TypeOfPackage.SPECIAL);
                break;
            default:
                System.out.println("Nothing was chosen.");
                break;
        }

        System.out.println("Enter weight of package:");
        pac.setPackageWeight(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        System.out.println("Enter price of package:");
        pac.setPackagePrice(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        System.out.println("Enter id of vehicle where package will be");
        pac.setVehicle(VehicleDAO.getVehicle(Long.parseLong(scanner.nextLine())));

        PackageDAO.savePackage(pac);
        System.out.println("Package -> " + pac.getId() + " " + pac.getName() + " was successfully added.");
    }

    @Override
    public void modifyPackage() {
        System.out.println("Enter id of package:");
        Package pac = PackageDAO.getAPackage(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose what to modify:");
        System.out.println("1 -> name");
        System.out.println("2 -> type of package");
        System.out.println("3 -> wight of package");
        System.out.println("4 -> price of package");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                pac.setName(scanner.nextLine());
                break;
            case 2:
                System.out.println("Choose type of package:");
                System.out.println("1 -> NORMAL");
                System.out.println("2 -> FRAGILE");
                System.out.println("3 -> SPECIAL");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        pac.setTypeOfPackage(TypeOfPackage.NORMAL);
                        break;
                    case 2:
                        pac.setTypeOfPackage(TypeOfPackage.FRAGILE);
                        break;
                    case 3:
                        pac.setTypeOfPackage(TypeOfPackage.SPECIAL);
                        break;
                }
                break;
            case 3:
                pac.setPackageWeight(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
                break;
            case 4:
                pac.setPackagePrice(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
                break;
            default:
                break;
        }
        PackageDAO.saveOrUpdatePackage(pac);

    }

    @Override
    public void selectPackage() {
        System.out.println("Enter package id:");
        PackageDAO.getAPackage(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public void removePackage() {
        System.out.println("Enter package id:");
        Package pac = PackageDAO.getAPackage(Long.parseLong(scanner.nextLine()));
        PackageDAO.deletePackage(pac);
        System.out.println("Package -> " + pac.getId() + " " + pac.getName() + " was successfully removed.");
    }
}
