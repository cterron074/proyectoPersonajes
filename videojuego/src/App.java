import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class App {

    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        ArrayList<Item> bolsaItems = new ArrayList<>();
        Item it1 =new Item("Escudo", 10, Tipo.ARMADURA, 10, 5, 50);
        Item it2 =new Item("Pocima", 10, Tipo.CURATIVO, 0, 0, 500);

        //ejercicio1 crea 5 personajes protagonistas y 2 enemigos
        Personaje p = new Personaje("Rodrigo", 100, 100, 100);
        Personaje p1 = new Personaje("Carmen", 100, 100, 100);
        Personaje p2 = new Personaje("Tony", 100, 100, 100);
        Personaje p3 = new Personaje("Hugo", 100, 100, 100);
        Personaje p4 = new Personaje("Angelo", 100, 100, 100);
        Personaje ePersonaje = new Personaje("Carlos_dataBase", 1000, 10, 40);
        Personaje ePersonaje2 = new Personaje("Gaby_Jr", 10, 1000, 100);
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(p);
        personajes.add(p1);
        personajes.add(p2);
        personajes.add(p3);
        personajes.add(p4);

  //metodo mostrar personaje orden alfabetico
        mostrarPersonaje(personajes);

        //PROTAGONISTAS
        ArrayList<Protagonista> protagonistas = new ArrayList<>();
        Protagonista prota = new Protagonista(p, null, 0, bolsaItems);
        Protagonista prota2 = new Protagonista(p1, null, 0, bolsaItems);
        Protagonista prota3 = new Protagonista(p2, null, 0, bolsaItems);
        Protagonista prota4 = new Protagonista(p3, null, 0, bolsaItems);
        Protagonista prota5 = new Protagonista(p4, null, 0, bolsaItems);



        // arrayList de enemigos
        ArrayList<Enemigo> enemigos = new ArrayList<>();

        Enemigo e = new Enemigo(10 , 1000, ePersonaje);
        Enemigo e1 = new Enemigo(5, 23, ePersonaje2);
    


        SC.close();
    }

    //metodo mostrar personajes atk sup a 10 ordenados alfabéticamente
    public static void mostrarPersonaje(ArrayList<Personaje> p){
        Collections.sort(p);
        for(int i =0;i < p.size();i++){
            if(p.get(i).getAttackPoints() > 10){
                System.out.println("Personaje: "+(i+1));
                System.out.println(p.get(i).toString());
            }

        }
    }
    //mostrar protas
        public static void mostrarProtagonistas(ArrayList<Protagonista> p){      
        for(int i =0;i < p.size();i++){
            if(p.get(i).getArmadura()!=null){
                System.out.println("Personaje: "+(i+1));
                System.out.println(p.get(i).toString());
            }

        }
    }
    //mostrar adversarios
        public static void mostrarEnemigos(ArrayList<Enemigo> p){
        for(int i =0;i < p.size();i++){           
                System.out.println("Personaje: "+(i+1));
                System.out.println(p.get(i).toString());
        }
    }
}
