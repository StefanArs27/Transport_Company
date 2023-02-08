package service.implement;

import company.Company;
import dao.ClientDAO;
import dao.CompanyDAO;
import people.Client;
import service.ClientService;

import java.util.Objects;
import java.util.Scanner;

public class ClientImplementService implements ClientService {

    private Scanner scanner;

    public ClientImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addClient() {
        Client client = new Client();

        System.out.println("Enter full name: ");
        if (!Objects.equals(scanner.nextLine(), "")) client.setFullName(scanner.nextLine());

        System.out.println("Enter age: ");
        if (!Objects.equals(scanner.nextLine(), "")) client.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter phone number: ");
        if (!Objects.equals(scanner.nextLine(), "")) client.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter id of the company client will work with:");
        if (!Objects.equals(scanner.nextLine(), ""))
            client.setCompany(CompanyDAO.getCompany(Integer.parseInt(scanner.nextLine())));

        ClientDAO.saveClient(client);
        System.out.println("Client -> " + client.getId() + " " + client.getFullName() + " was successfully added.");
    }

    @Override
    public void modifyClient() {
        System.out.println("Enter id of client:");
        Client client = ClientDAO.getClient(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose what to modify:");
        System.out.println("1 -> name");
        System.out.println("2 -> age");
        System.out.println("3 -> phone number");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                client.setFullName(scanner.nextLine());
                break;
            case 2:
                client.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                client.setPhoneNumber(scanner.nextLine());
                break;
            default:
                break;
        }

        ClientDAO.saveOrUpdateClient(client);
    }

    @Override
    public Client selectClient() {
        System.out.println("Enter id of client:");
        System.out.println(ClientDAO.getClient(Long.parseLong(scanner.nextLine())) + " was selected.");
        return ClientDAO.getClient(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public void removeClient() {
        System.out.println("Select client id: ");
        Client client = ClientDAO.getClient(Integer.parseInt(scanner.nextLine()));
        ClientDAO.deleteClient(client);
        System.out.println("Client -> " + client.getId() + " " + client.getFullName() + " is removed.");
    }
}
