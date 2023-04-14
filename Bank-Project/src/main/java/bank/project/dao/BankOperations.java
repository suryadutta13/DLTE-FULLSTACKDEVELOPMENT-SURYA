package bank.project.dao;

import java.util.List;
import java.util.Optional;

public interface BankOperations {

    public Customer getByUsername(String username);
    public List<Customer> listCustomers();
    public void incrementFailedAttempts(int id);
    public int getAttempts(int id);
    public void decreaseAttempts(int id);
    public void updateStatus();
    public List<Account> ListAccounts(String user);
    public List<Account> ListSpecificAccounts(String Status);
    public List<Account>ListActiveAccounts(String user);
    public List<Account>ListSuspendedAccounts(String user);
}
