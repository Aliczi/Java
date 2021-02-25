package hello;

import java.util.Scanner ;

public class World {
    public static void main ( String [] args ) {
        Scanner s = new Scanner ( System.in ) ;
        String fellow = "World" ;
        System.out.printf ( "Hello %s \n", fellow ) ;
        while ( !"exit".equals(fellow) ) {
            System.out.printf( "Introduce yourself: ");
            fellow = s.nextLine() ;
            System.out.printf ("Hello %s\n", fellow) ;
        }
        s.close() ;
    }
}


/* 
8. Czy program działa zgodnie z oczekiwaniem? Na czym polega problem?
Program nie działa zgodnie z oczekiwaniem. Nie można go zakończyć poprzez wpisanie "exit".
Przyczyną problemu było niewłaściwe porównywanie zmiennej i stałej, rozwiązało go użycie funkcji equals.
*/