package menu;

import service.implement.*;

import java.util.Scanner;

public class Menu {
    private ClientImplementService clientImplementService;
    private CompanyImplementService companyImplementService;
    private DriverImplementService driverImplementService;
    private EmployeeImplementService employeeImplementService;
    private PackageImplementService packageImplementService;
    private VehicleImplementService vehicleImplementService;

    private Scanner scanner;

    public Menu() {
        this.clientImplementService = new ClientImplementService();
        this.companyImplementService = new CompanyImplementService();
        this.driverImplementService = new DriverImplementService();
        this.employeeImplementService = new EmployeeImplementService();
        this.packageImplementService = new PackageImplementService();
        this.vehicleImplementService = new VehicleImplementService();
        this.scanner = new Scanner(System.in);
    }

    public void startMenu() {
        do {
            System.out.println("Options for transport company:");
            System.out.println("1 -> Company");
            System.out.println("2 -> Package");
            System.out.println("3 -> Vehicle");
            System.out.println("4 -> Employee");
            System.out.println("5 -> Driver");
            System.out.println("6 -> Client");
            System.out.println("0 -> Exit");

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("Options for company: ");
                    System.out.println("1 -> create company");
                    System.out.println("2 -> select company");
                    System.out.println("3 -> modify company");
                    System.out.println("4 -> sort companies by name");
                    System.out.println("5 -> sort companies by earnings");
                    System.out.println("6 -> delete company");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            companyImplementService.addCompany();
                            break;
                        case 2:
                            companyImplementService.selectCompany();
                            break;
                        case 3:
                            companyImplementService.modifyCompany();
                            break;
                        case 4:
                            companyImplementService.sortCompaniesByName();
                            break;
                        case 5:
                            companyImplementService.sortCompaniesByEarnings();
                            break;
                        case 6:
                            companyImplementService.removeCompany();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Options for package: ");
                    System.out.println("1 -> create package");
                    System.out.println("2 -> select package");
                    System.out.println("3 -> modify package");
                    System.out.println("4 -> delete package");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            packageImplementService.addPackage();
                            break;
                        case 2:
                            packageImplementService.selectPackage();
                            break;
                        case 3:
                            packageImplementService.modifyPackage();
                            break;
                        case 4:
                            packageImplementService.removePackage();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Options for vehicle: ");
                    System.out.println("1 -> create vehicle");
                    System.out.println("2 -> select vehicle");
                    System.out.println("3 -> modify vehicle");
                    System.out.println("4 -> sort vehicles by distance");
                    System.out.println("5 -> delete vehicle");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            vehicleImplementService.addVehicle();
                            break;
                        case 2:
                            vehicleImplementService.selectVehicle();
                            break;
                        case 4:
                            vehicleImplementService.sortVehiclesByDistance();
                            break;
                        case 5:
                            vehicleImplementService.removeVehicle();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Options for employee: ");
                    System.out.println("1 -> create employee");
                    System.out.println("2 -> select employee");
                    System.out.println("3 -> sort employee by salary");
                    System.out.println("4 -> delete employee");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            employeeImplementService.addEmployee();
                            break;
                        case 2:
                            employeeImplementService.selectEmployee();
                            break;
                        case 3:
                            employeeImplementService.sortEmployeesBySalary();
                            break;
                        case 4:
                            employeeImplementService.fireEmployee();
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Options for driver: ");
                    System.out.println("1 -> create driver");
                    System.out.println("2 -> select driver");
                    System.out.println("3 -> sort driver by qualification");
                    System.out.println("4 -> sort driver by salary");
                    System.out.println("5 -> delete driver");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            driverImplementService.addDriver();
                            break;
                        case 2:
                            driverImplementService.selectDriver();
                            break;
                        case 3:
                            driverImplementService.sortDriversByQualification();
                            break;
                        case 4:
                            driverImplementService.sortDriversBySalary();
                            break;
                        case 5:
                            driverImplementService.fireDriver();
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Options for client: ");
                    System.out.println("1 -> create client");
                    System.out.println("2 -> select client");
                    System.out.println("3 -> modify client");
                    System.out.println("4 -> delete client");
                    System.out.println("0 -> return");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            clientImplementService.addClient();
                            break;
                        case 2:
                            clientImplementService.selectClient();
                            break;
                        case 3:
                            clientImplementService.modifyClient();
                            break;
                        case 4:
                            clientImplementService.removeClient();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.exit(0);
            }
        } while (true);
    }
}
