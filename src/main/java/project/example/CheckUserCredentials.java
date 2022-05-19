package project.example;

import project.example.model.Account;

import java.sql.PreparedStatement;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class CheckUserCredentials  extends ActionSupport {
    private Account accountBean;
    private Account fetchedAccount;
    private String error = "";
    private String validationString = "";

    public String execute() throws SQLException {
        accountBean = getAccountBean();

        if(accountBean.getUsername().isBlank() ||
        accountBean.getPassword().isBlank()) {
            return INPUT;
        } else {
            if(fetchFromDB()) {
                if(fetchedAccount == null) {
                    validationString = "Username or password is invalid.";
                    return INPUT;
                }
                else {
                    return SUCCESS;
                }
            } else {
                return ERROR;
            }
        }
    }

    public boolean fetchFromDB() throws SQLException  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT first_name, last_name, email FROM ACCOUNTS WHERE username = '" + accountBean.getUsername() + "' AND password = '" + accountBean.getPassword() + "'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){  
                    fetchedAccount = new Account();
                    fetchedAccount.setFirstName(rs.getString(1)); 
                    fetchedAccount.setLastName(rs.getString(2));
                    fetchedAccount.setEmail(rs.getString(3));
                }
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
            error = e.toString();
            return false;
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public Account getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(Account accountBean) {
        this.accountBean = accountBean;
    }

    public Account getFetchedAccount() {
        return fetchedAccount;
    }

    public void setFetchedAccount(Account fetchedAccount) {
        this.fetchedAccount = fetchedAccount;
    }

    public String getError() {
        return error;
    }

    public String getValidationString() {
        return validationString;
    }
}
