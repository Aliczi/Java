public class AccountNotFoundException extends Exception{
    static final long serialVersionUID = 1L;
    public AccountNotFoundException(String msg){
        super(msg);
    }
}
