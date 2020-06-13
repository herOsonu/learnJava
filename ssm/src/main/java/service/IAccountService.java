package service;

import domain.Account;

public interface IAccountService {
    Account login(Account account);
    void register(Account account);
    void infoModify(Account account);
}
