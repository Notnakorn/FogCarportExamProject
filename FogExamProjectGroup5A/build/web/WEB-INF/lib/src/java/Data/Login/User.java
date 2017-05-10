
package Data.Login;


public class User {
    
    private String username;
    private String adress;
    private String phone;
    private String email;
    private String password;
    private double balance;
    
   
    public User(String username, String adress, String phone, String email,String password, double balance){
        this.username = username;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
       
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
