package project.example;

import project.example.model.Account;

import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddUserToDB extends ActionSupport {

    private Account accountBean;
    private String error = "";


    public String execute() throws SQLException {
        accountBean = getAccountBean();
        
        if(accountBean.getUsername().isBlank() ||
            accountBean.getPassword().isBlank() ||
            accountBean.getFirstName().isBlank() ||
            accountBean.getLastName().isBlank() ||
            accountBean.getEmail().isBlank()) {
                return INPUT;
        } else {
            if(saveToDB()) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        }
    }

    public boolean saveToDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if(connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO ACCOUNTS(username, password, first_name, last_name, email) " +
                    "VALUES('"+accountBean.getUsername()+"','"+accountBean.getPassword()+"','"+
                    accountBean.getFirstName()+"','"+accountBean.getLastName()+"','" +
                    accountBean.getEmail()+"')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public String getError() {
        return error;
    }
    
    public Account getAccountBean() {
        return accountBean;
    }
    
    public void setAccountBean(Account account) {
        accountBean = account;
    }
}
