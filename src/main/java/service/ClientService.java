package service;

import people.Client;

public interface ClientService {

    void addClient();
    void modifyClient();
    Client selectClient();
    void removeClient();

}
