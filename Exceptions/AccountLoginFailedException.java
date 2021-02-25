public class AccountLoginFailedException extends Exception{
    static final long serialVersionUID = 1L;
    private int password;
    private String login;
    private int accountNumber;
    private Customer owner;
    
    AccountLoginFailedException(){}
    AccountLoginFailedException(String errorMsg, String s, int passwd){
        super(errorMsg);
        login = s;
        password = passwd;
    }


    int getPassword(){
        return(password);
    }
    
    String getLogin(){
        return(login);
    }

    int getAccountNumber(){
        return(accountNumber);
    }

    Customer getOwner(){
        return(owner);
    }
}
    

