public class Customer {
    private String name;
    private String pesel;
    private String adress;

    public Customer(){
        this.name = "Default name";
        this.adress = "Default adress";
        this.pesel = "12345678910";
    }
    public Customer(String s){
        this.name = s;
        this.adress = "Default adress";
        this.pesel = "12345678910";
    }
    public String getName(){
        return(name);
    }

    @Override       //Adnotacja override służy do nadpisania metody w nadklasie. Dzięki niej kompilator pomoże nam uniknąć pomyłek dotyczących deklaracji klasy.
    public boolean equals (Object c) {
        if (this.name == ((Customer) c).name){
            return true;
        } else {
            return false;
        }
    }
}