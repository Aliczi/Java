public class CustomerNotFoundException extends Exception{
    static final long serialVersionUID = 1L;
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
