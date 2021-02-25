package recycling;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class Wezel {
    static ArrayList<Wezel> polaczenie = new ArrayList<>();
    static TreeMap<Wezel, Boolean> polaczenie_tree = new TreeMap<>();
    static HashMap<Wezel, Boolean> polaczenie_hash = new HashMap<>();

    public void dodajPolaczenie(Wezel w){
        polaczenie.add(w);
    }

    //Podpunkt 13
    public void hashPolaczenie(Wezel w){
        polaczenie_hash.put(w,true);
    }

    public void treePolaczenie(Wezel w){
        polaczenie_tree.put(w,true);
    }


    @Deprecated
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizowanie obiektu ");
        super.finalize();
    }
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        for (int i = 0; i <= 1000000; i++){
            // new Wezel();
            Wezel w1 = new Wezel();
            Wezel w2 = new Wezel();
            w1.dodajPolaczenie(w2);
            w2.dodajPolaczenie(w1);
            // System.out.println(polaczenie); 

        }
        s.nextLine();
        s.close();
    }
}

/*
Odpowiedź do podpunktu 5
Aby poprawnie skompilował się plik w Windows 10 oraz JDK 15 w VSCode trzeba było dodać --enable-preview (java --enable-preview -jar RecyclingJava.jar).
Na konsoli nie został wypisany tekst "Finalizowanie obiektu".
*/

/*
Odpowiedź do podpunktu 7
Po uruchomieniu na konsoli cały czas pojawiał się napis "Finalizowanie obiektu". Chwilę trwało zanim wszystkie iteracje to wypisały.
Odśmiecanie pamięci (ang. garbage collection) - jedna z metod automatycznego zarządzania dynamicznie przydzielaną pamięcią, w której za proces jej zwalniania odpowiedzialny 
jest nie programista, lecz programowy zarządca noszący nazwę garbage collector.
Metoda finalize() aktywuje się dopiero po pewnej ilości iteracji, ale przed odśmiecaniem pamięci i ręcznie pozbywa się zasobów systemu, dokouje czyszczenia i minimalizuje wycieki pamięci.
https://www.javatpoint.com/java-object-finalize-method
*/

/*
Odpowiedź do podpunktu 11
Garbage Collector w pierwszym kroku identyfikuje i oznacza obiekty do których nie istnieją odwołania jako gotowe do garbage collection. W drugim kroku te obiekty zostają usunięte.
Garbage Collector w Javie jest niederministyczny i nie można pzewidzieć kiedy dokładnie wystąpi. 
Metoda finalize() jest metodą protected and non-static. Jest używana do wykonania jakichś końcowych operacji na obiekcie zanim zostanie on usunięty z pamięci. Może być wywołana tylko raz dla danego obiektu.
Możemy nadpisać tę metodę wg własnych potrzeb. Garbage collector zawsze wywołuję tę metodę przed usunięciem obiektu.
Jeśli chcemy zatrzymać obiekt pomimo braku odwołań do niego, możemy 1) zwiększyć rozmiar Heap-Eden 2) stworzyć klasę Singleton z odwołaniem static 
3) nadpisać metodę finalize() i nigdy nie pozwolić obiektowi na dereferencje.
https://javaconceptoftheday.com/garbage-collection-finalize-method-java/
https://stackoverflow.com/questions/1329926/how-to-prevent-an-object-from-getting-garbage-collected
*/

/*
Odpowiedź do podpunktu 12
W tradycyjnej tablicy nie możemy modyfikować elementów oraz musimy wcześniej określić jej rozmiar. 
Tworząc ArrayList, albo nie musimy wspominać o jej rozmiarze, albo możemy go potem zmodyfikować.
Tradycyjna tablica w Javie może zawierać zarówno typy proste (ang. primitive types) jak i wystąpienia obiektów. Aby użyć typów prostych w ArrayList musimy użyć wrapper class, 
bo jest przedewszystkim przeznaczona do wystąpień obiektów.
*/