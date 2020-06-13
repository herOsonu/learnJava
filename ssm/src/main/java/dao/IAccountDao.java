package dao;

import domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAccountDao {

    @Select("select * from account where username=#{username} and password=#{password}")
     Account login(Account account);

    @Insert("insert into account(username,password) values (#{username},#{password})")
    void register(Account account);

    @Update("update account set password=#{password} where username=#{username}")
    void infoModify(Account account);
}
