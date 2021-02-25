import java.util.*;


public class Bank implements SearchAccounts, SearchCustomers{
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Account> accounts = new ArrayList<Account>();

    @Override
    public Customer findByName(String n) throws CustomerNotFoundException{
        for(Customer cu : customers)
            if (cu.getName().equals(n)) return cu;
        throw new CustomerNotFoundException("Brak klienta o podanym nazwisku.");
    }

    @Override
    public Account findByNumber(int num) throws AccountNotFoundException{
        for(Account ac: accounts)
            if (ac.getNumber() == num) return ac;
        throw new AccountNotFoundException("Brak konta o podanym numerze.");
    }

    @Override
    public ArrayList<Account> findAllCustomerAccounts(Customer cust) throws AccountNotFoundException{
        ArrayList<Account> allAc = new ArrayList<Account>();
        for (Account acc : accounts)
            if(acc.getCustomer().equals(cust)) allAc.add(acc);
        if (allAc.isEmpty()) throw new AccountNotFoundException("Klient nie posiada konta.");
        return allAc;
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }
    public void addAccount(int n, Customer c, int passwd, String l){
        Account acc = new Account(n,c,passwd,l);
        accounts.add(acc);
    }

    public static void main(String[] args) throws CustomerNotFoundException{
        Bank b = new Bank();
        Customer cust = new Customer("Jan Kowalski");
        Customer sec_cust = new Customer("Max Mutterman");
        b.addCustomer(cust);
        b.addAccount(553311, cust, 1111, "jankowal");
        b.addAccount(113377, sec_cust, 2222, "maxmut");
        b.addAccount(443311, cust, 2222, "janski");
        
        try{
            b.findByNumber(443311);
        } catch (AccountNotFoundException e){
            System.err.print(e);
        }

        try{
            b.findByName("Jana Kowalski");
        } catch (CustomerNotFoundException e){
            System.err.print(e);
            e.printStackTrace();
            System.out.println("");
            e.fillInStackTrace();
            throw e;
        }

        try{
            b.findAllCustomerAccounts(cust);
        } catch (AccountNotFoundException e){
            System.err.print(e);
        }

        Account konto = new Account(1234,cust,4321,"login");
        try{
            konto.login("login", 4321);
        } catch(AccountLoginFailedException e){
            System.err.print(e);
        }
        
    }
}

/*
Podpunkt 9
Intefejsy w Javie są używane, aby osiągnąć abstrakcję. 
Pozwalają oddzielić definicję metody od hierarchii dziedziczenia.
Pomagają osiągnąć loose coupling, czyli łączenie komponentów systemu albo sieci tak żeby polegały na sobie w jak najmniejszym. praktycznym stopniu.
*/
    
// https://www.codejava.net/java-core/exception/how-to-create-custom-exceptions-in-java

/*
Podpunkt 11
Ślady stosu wypisane w bloku catch i przez maszynę wirtualną w chwili przerwania programu są takie same:

CustomerNotFoundException: Brak klienta o podanym nazwisku.CustomerNotFoundException: Brak klienta o podanym nazwisku.
        at Bank.findByName(Bank.java:12)
        at Bank.main(Bank.java:55)

Exception in thread "main" CustomerNotFoundException: Brak klienta o podanym nazwisku.
        at Bank.findByName(Bank.java:12)
        at Bank.main(Bank.java:55)

Ponowne zgłoszenie nie zmienia zapamiętanego śladu wywołań. Nie jest on wypełniany w chwili zgłoszenia wyjątku, ale w chwili jego utworzenia.
*/

/*
Podpunkt 12
Te ślady nie są takie same.

CustomerNotFoundException: Brak klienta o podanym nazwisku.CustomerNotFoundException: Brak klienta o podanym nazwisku.
        at Bank.findByName(Bank.java:12)
        at Bank.main(Bank.java:55)

Exception in thread "main" CustomerNotFoundException: Brak klienta o podanym nazwisku.
        at Bank.main(Bank.java:60)

Przy pomocy metody fillInStackTrace() możemy podmienić ślad na aktualny ślad stosu wywołań w ponownie zgłaszanym wyjątku.
*/
