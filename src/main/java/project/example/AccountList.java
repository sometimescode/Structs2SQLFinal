package project.example;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import project.example.model.Account;

import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountList extends ActionSupport {
    ArrayList<Account> accounts = new ArrayList<Account>();

    public ArrayList<Account> getAccounts() {  
        return accounts;  
    }  
    public void setAccountList(ArrayList<Account> accounts) {  
        this.accounts = accounts;  
    }  

    public String execute() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT first_name, last_name, email FROM accounts";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Account account = new Account();
                    account.setFirstName(rs.getString(1));
                    account.setLastName(rs.getString(2));
                    account.setEmail(rs.getString(3));
                    accounts.add(account);  
                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }
}