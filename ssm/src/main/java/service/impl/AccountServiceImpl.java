package service.impl;

import dao.IAccountDao;
import domain.Account;
import org.springframework.stereotype.Service;
import service.IAccountService;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Resource
    private IAccountDao iAccountDao;
    @Override
    public Account login(Account account) {
        return iAccountDao.login(account);
    }
    @Override
    public void register(Account account){
        iAccountDao.register(account);
    }

    @Override
    public void infoModify(Account account) {
        iAccountDao.infoModify(account);
    }
}
