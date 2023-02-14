package service.implement;

import dao.ClientDAO;
import dao.CompanyDAO;
import people.Client;
import service.ClientService;

import java.util.List;
import java.util.Scanner;

public class ClientImplementService implements ClientService {

    private Scanner scanner;

    public ClientImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addClient() {
        Client client = new Client();

        System.out.println("\nEnter full name: ");
        client.setFullName(scanner.nextLine());

        System.out.println("Enter age: ");
        client.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter phone number: ");
        client.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter id of the company client will work with:");
        client.setCompany(CompanyDAO.getCompany(Integer.parseInt(scanner.nextLine())));

        ClientDAO.saveClient(client);
        System.out.println("Client -> " + client.getId() + " " + client.getFullName() + " was successfully added.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void modifyClient() {
        System.out.println("\nEnter id of client:");
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
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void selectClient() {
        System.out.println("\nEnter id of client:");
        System.out.println(ClientDAO.getClient(Long.parseLong(scanner.nextLine())) + " was selected.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void readClients() {
        List<Client> clientList = ClientDAO.readClients();
        System.out.println("\nList of clients: ");
        clientList.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void removeClient() {
        System.out.println("\nSelect client id: ");
        Client client = ClientDAO.getClient(Integer.parseInt(scanner.nextLine()));
        ClientDAO.deleteClient(client);
        System.out.println("Client -> " + client.getId() + " " + client.getFullName() + " is removed.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }
}
