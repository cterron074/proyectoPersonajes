import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
 
        ArrayList<Item> bolsaItems = new ArrayList<>();
        // Nombre, Precio, Tipo, Atk, Def, HP
        Item it1 = new Item("Escudo de Madera", 15, Tipo.ARMADURA, 0, 5, 0);
        Item it2 = new Item("Poción Pequeña", 10, Tipo.CURATIVO, 0, 0, 20);
        Item it3 = new Item("Café Cargado", 25, Tipo.CURATIVO, 5, 0, 40);
        Item it4 = new Item("Cota de Malla", 50, Tipo.ARMADURA, 0, 15, 0);
        Item it5 = new Item("Bocadillo Vital", 15, Tipo.CURATIVO, 0, 0, 50);
        Item it6 = new Item("Armadura de Dragón", 200, Tipo.ARMADURA, 10, 50, 20);
        
        bolsaItems.add(it1);
        bolsaItems.add(it2);
        bolsaItems.add(it3);
        bolsaItems.add(it4); 
        bolsaItems.add(it5); 
        bolsaItems.add(it6); 

        // Protagonistas: Nombre, Atk, Def, HP
        Personaje p = new Personaje("Rodrigo", 20, 10, 100);
        Personaje p1 = new Personaje("Carmen", 25, 5, 90);
        Personaje p2 = new Personaje("Tony", 15, 15, 120);
        Personaje p3 = new Personaje("Hugo", 30, 2, 80);
        Personaje p4 = new Personaje("Angelo", 18, 12, 110);
        
        // Enemigos: Ajustados para que el combate sea justo
        Personaje ePersonaje = new Personaje("Slime Malvado", 10, 2, 40);
        Personaje ePersonaje2 = new Personaje("Orco Guerrero", 15, 8, 80);
        
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(p);
        personajes.add(p1);
        personajes.add(p2);
        personajes.add(p3);
        personajes.add(p4);

        mostrarPersonajes(personajes);

        // PROTAGONISTAS: Se inicializan con bolsa propia (vacía para que la tienda tenga sentido)
        ArrayList<Protagonista> protagonistas = new ArrayList<>();
        Protagonista prota = new Protagonista(p, null, 10, new ArrayList<>());
        Protagonista prota2 = new Protagonista(p1, null, 10, new ArrayList<>());
        Protagonista prota3 = new Protagonista(p2, null, 10, new ArrayList<>());
        Protagonista prota4 = new Protagonista(p3, null, 10, new ArrayList<>());
        Protagonista prota5 = new Protagonista(p4, null, 10, new ArrayList<>());

        protagonistas.add(prota);
        protagonistas.add(prota2);
        protagonistas.add(prota3);
        protagonistas.add(prota4);
        protagonistas.add(prota5);

        // ENEMIGOS: VecesDerrotado, OroProporcionado, Personaje
        ArrayList<Enemigo> enemigos = new ArrayList<>();
        Enemigo e = new Enemigo(0, 30, ePersonaje);
        Enemigo e1 = new Enemigo(0, 60, ePersonaje2);
        
        enemigos.add(e);
        enemigos.add(e1);

        //creo mis arays auxiliares por Tipo y facilitarnos la existencia XD
        ArrayList<Item> bolsaCurativos =new ArrayList<>();
        ArrayList<Item> bolsaArmadura = new ArrayList<>();
        for (int i = 0; i < bolsaItems.size(); i++) {
            if (bolsaItems.get(i).getTipoItem()==Tipo.CURATIVO) {
                bolsaCurativos.add(bolsaItems.get(i));
            }
            if (bolsaItems.get(i).getTipoItem()==Tipo.ARMADURA) {
                bolsaArmadura.add(bolsaItems.get(i));
            }
        }

        //menu Inicial

        boolean salir = false;

        while ( salir == false) {

         System.out.println("--------------");
         System.out.println("----Menu------");
         System.out.println("--------------");
         System.out.println("1.Editar Lista de Personajes");
         System.out.println("2.Editar Lista de Objetos ");
         System.out.println("3.Crear Personaje Custom");
         System.out.println("4.Crear Item Custom");
         System.out.println("5.Jugar");
         System.out.println("6.Salir.");
         System.out.println("--------------");
         System.out.println("Elige una opcion" );
         int opcion = SC.nextInt();
         SC.nextLine();



         switch (opcion) {
                    case 1:
                    //editar arrayList de personajes
                    System.out.println("Estos son tus personajes:");
                    mostrarPersonajes(personajes);
                    System.out.println("¿Qué personaje te gustaria cambiar?");
                    String personaje=SC.nextLine();
                    boolean perEncontrado=false;
                    for(int i=0; i<personajes.size();i++){
                            if(personajes.get(i).getName().equals(personaje)){
                                perEncontrado=true;
                                editarPersonaje(personajes,personaje);
                            }
                        }
                        if (perEncontrado==false) {
                            System.out.println("Personaje no encontrado");
                        }
                                
                        /* 
                        private String name;
                        private int attackPoints;
                        private int defenPoints;
                        private int healthPoints;*/
                    break;

                    case 2:
                    System.out.println("Estos son tus objetos:");
                    mostrarObjetos(bolsaItems);
                    System.out.println("¿Qué objeto te gustaria cambiar?");
                    String objeto=SC.nextLine();
                    boolean objEncontrado=false;
                    for(int i=0; i<bolsaItems.size();i++){
                        if(bolsaItems.get(i).getNombre().equals(objeto)){
                                objEncontrado=true;
                                editarObjeto(bolsaItems,objeto);
                            }
                        }
                        if (objEncontrado==false) {
                            System.out.println("Objeto no encontrado");
                        }
                    //Editar Lista de Objetos
                    break;

                    case 3:
                    //3. Crear Personaje Custom --- Dará la opción de crear un personaje, enemigo o protagonista al usuario. 
                    // (Sin armadura ni ítems en el caso de protagonista) y lo añadirá al juego.
                    System.out.println("que personaje te gustaria crear enemigo o protagonista");
                    String custom = SC.nextLine();
                    crearPersonaje(custom, personajes,enemigos,protagonistas,bolsaCurativos,bolsaArmadura);


                    break;
                    case 4:
                    //Crear Item Custom --- Dara la opción de crear un Item, ya sea armadura o curativo, y lo añadirá al juego.
                    System.out.println("Dame el nombre del item que quieres crear :");
                    String nomItemNuevo = SC.nextLine();
                    boolean repetido=false;
                    for (int i = 0; i < bolsaItems.size(); i++) {
                        if (bolsaItems.get(i).getNombre().equals(nomItemNuevo)) {
                            System.out.println("Escribe otro nombre, el objeto ya está insertado");
                            nomItemNuevo=SC.nextLine();
                            repetido=true;
                        }
                    }
                    if (repetido==false) {
                        crearItem(bolsaItems, nomItemNuevo);
                    }


                    break;
                    case 5: // JUGAR
                        System.out.println("Tus protagonistas: ");
                        mostrarProtagonistas(protagonistas);
                        
                        Protagonista auxProta = null;
                        System.out.println("1. Elegir / 2. Aleatorio");
                        int el = SC.nextInt(); SC.nextLine();
                        
                        if (el == 1) {
                            System.out.println("Nombre:");
                            String nombre = SC.nextLine();
                            for (int i =0;i<protagonistas.size();i++) {
                                if (protagonistas.get(i).getProtagonista().getName().equalsIgnoreCase(nombre)==true){
                                    auxProta=protagonistas.get(i);
                                }
                            }
                        } else {
                            auxProta = protagonistas.get((int) (Math.random() * protagonistas.size()));
                        }
                            System.out.println("Nivel: 1.Fácil / 2.Difícil");
                            int nivel = SC.nextInt(); SC.nextLine();
                            //Configuración según el nivel elegido
                            switch (nivel) {
                                case 1:
                                    PrepararJuegoFacil(auxProta, bolsaCurativos, bolsaArmadura, bolsaArmadura);
                                    jugarJuego(auxProta, enemigos, bolsaItems, 1);
                                break;
                                case 2:
                                PrepararJuegoDificil(auxProta,bolsaCurativos,bolsaArmadura,bolsaItems);
                                jugarJuego(auxProta, enemigos, bolsaItems, 2);
                                    break;
                                default:
                                break;
                            }
                            
                        
                       break; 
                        case 6:
                            salir = true;
                        break;
                    }
                  
       
        }
         SC.close();
    }
         

    //metodo mostrar personajes atk sup a 10 ordenados alfabéticamente

    public static void mostrarPersonajes(ArrayList<Personaje> p){
        Collections.sort(p);
        for(int i =0;i < p.size();i++){
            if(p.get(i).getAttackPoints() > 0){
                System.out.println("Personaje: "+(i+1));
                System.out.println(p.get(i).toString());
            }
        }
    }
    //editar personaje
    public static void editarPersonaje(ArrayList<Personaje>personajes,String personaje){
        boolean seguirEditando=true;
        
        while (seguirEditando==true) {
            System.out.println("¿Qué atributo del personaje te gustaria cambiar?");
            System.out.println("1.Nombre de personaje");
            System.out.println("2.Puntos de Ataque");
            System.out.println("3.Puntos de defensa");
            System.out.println("4.Puntos de Vida");
            System.out.println("Si no quieres cambiar nada mas pulsa 0");
            int eleccion=SC.nextInt();
            SC.nextLine();
            switch (eleccion) {
                case 1:
                    System.out.println("Introdce un nuevo nombre");
                    String nuevoNombre = SC.nextLine();
                        for (int i = 0; i < personajes.size(); i++) {
                        if (personajes.get(i).getName().equals(personaje)==true) {
                            personajes.get(i).setName(nuevoNombre);
                            System.out.println("Nombre cambiado");
                            System.out.println("Información actualizada");
                            System.out.println(personajes.get(i).toString());                         
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduce los nuevos puntos de ataque");
                    int nuevosPuntosATQ=SC.nextInt();
                    SC.nextLine();
                    for (int i = 0; i < personajes.size(); i++) {
                        if(personajes.get(i).getName().equals(personaje)==true){
                            personajes.get(i).setAttackPoints(nuevosPuntosATQ);
                            System.out.println("Información actualizada");
                            System.out.println(personajes.get(i).toString());
                        }
                        
                    }
                    break;
                case 3:
                    System.out.println("Introduce los puntos de defensa");
                    int nuevosPuntosDFS=SC.nextInt();
                    SC.nextLine();
                    for (int i = 0; i < personajes.size(); i++) {
                        if(personajes.get(i).getName().equals(personaje)==true){
                        personajes.get(i).setDefenPoints(nuevosPuntosDFS);
                        System.out.println("Información actualizada");
                        System.out.println(personajes.get(i).toString());
                        }
                        
                    }
                    break;
                case 4:
                    System.out.println("Introduce los nuevos puntos de Vida");
                    int nuevosPuntoVD=SC.nextInt();
                    SC.nextLine();
                     for (int i = 0; i < personajes.size(); i++) {
                        if(personajes.get(i).getName().equals(personaje)==true){
                        personajes.get(i).setDefenPoints(nuevosPuntoVD);
                        System.out.println("Información actualizada");
                        System.out.println(personajes.get(i).toString());
                        }
                        
                    }
                    break;   
                case 0:
                seguirEditando=false;
                    break;
            }
        }
    }

    //editar objeto 
    public static void editarObjeto(ArrayList<Item>bolsaItems,String nnomItem){
        boolean seguirEditando=true;
        
        while (seguirEditando==true) {
            System.out.println("¿Qué atributo del objeto te gustaria cambiar?");
            System.out.println("1.Nombre de objeto");
            System.out.println("2.Puntos de Ataque");
            System.out.println("3.Puntos de defensa");
            System.out.println("4.Puntos de Vida");
            System.out.println("5.Precio");
            System.out.println("6.tipo de Item");
            System.out.println("Si no quieres cambiar nada mas pulsa 0");
            int eleccion=SC.nextInt();
            SC.nextLine();
            switch (eleccion) {
                case 1:
                    System.out.println("Introdce un nuevo nombre");
                    String nuevoNombre = SC.nextLine();
                        for (int i = 0; i < bolsaItems.size(); i++) {
                        if (bolsaItems.get(i).getNombre().equals(nnomItem)==true) {
                            bolsaItems.get(i).setNombre(nuevoNombre);
                            System.out.println("Nombre cambiado");
                            System.out.println("Información actualizada");
                            System.out.println(bolsaItems.get(i).toString());                         
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduce los nuevos puntos de ataque");
                    int nuevosPuntosATQ=SC.nextInt();
                    SC.nextLine();
                    for (int i = 0; i < bolsaItems.size(); i++) {
                        if(bolsaItems.get(i).getNombre().equals(nnomItem)==true){
                            bolsaItems.get(i).setAttackPoints(nuevosPuntosATQ);
                           System.out.println("Información actualizada");
                            System.out.println(bolsaItems.get(i).toString());
                        }
                        
                    }
                    break;
                case 3:
                    System.out.println("Introduce los puntos de defensa");
                    int nuevosPuntosDFS=SC.nextInt();
                    SC.nextLine();
                    for (int i = 0; i < bolsaItems.size(); i++) {
                        if(bolsaItems.get(i).getNombre().equals(nnomItem)==true){
                        bolsaItems.get(i).setDefenPoints(nuevosPuntosDFS);
                        System.out.println("Información actualizada");
                        System.out.println(bolsaItems.get(i).toString());
                        }
                        
                    }
                    break;
                case 4:
                    System.out.println("Introduce los nuevos puntos de Vida");
                    int nuevosPuntoVD=SC.nextInt();
                    SC.nextLine();
                     for (int i = 0; i < bolsaItems.size(); i++) {
                        if(bolsaItems.get(i).getNombre().equals(nnomItem)==true){
                        bolsaItems.get(i).setDefenPoints(nuevosPuntoVD);
                        System.out.println("Información actualizada");
                        System.out.println(bolsaItems.get(i).toString());
                        }
                        
                    }
                    break;
            
                case 0:
                seguirEditando=false;
                    break;
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
    public static void mostrarItCurativos(ArrayList<Item> bolsa){
        for(int i =0;i < bolsa.size();i++){     
               if (bolsa.get(i).getTipoItem()==Tipo.CURATIVO) {
                System.out.print(bolsa.get(i).getNombre()+ " Puntos Curativos: "+bolsa.get(i).getHealthPoints());
               }
        }
    }
    public static void mostrarObjetos(ArrayList<Item> bolsa){
        for (int i = 0; i < bolsa.size(); i++) {
            System.out.println(bolsa.get(i).toString());
        }
    }

    public static void crearPersonaje(String custom, ArrayList<Personaje> personajes, ArrayList<Enemigo> enemigos, ArrayList<Protagonista> protagonistas,ArrayList<Item> bolsaCurativos, ArrayList<Item> bolsaArmadura){
        switch (custom) {
            case "enemigo":
                System.out.println("Dame nombre");
                String n = SC.nextLine();
                System.out.println("dame puntos de atake");
                int a = SC.nextInt();
                System.out.println("dame puntos de defensa");
                int d = SC.nextInt();
                System.out.println("dame puntos de vida");
                int v = SC.nextInt();
                SC.nextLine();


                System.out.println("Cuantas veces derrotado?");
                int lose = SC.nextInt();

                System.out.println("Cuantas oro derrotado?");
                int oro = SC.nextInt();

                Personaje nuevo = new Personaje(n,a,d,v);
                Enemigo nuevoenEnemigo = new Enemigo(lose, oro, nuevo);

                personajes.add(nuevo);
                enemigos.add(nuevoenEnemigo);


                break;
            case "protagonista":
                System.out.println("Dame nombre");
                String nom = SC.nextLine();
                System.out.println("dame puntos de atake");
                int attack = SC.nextInt();
                System.out.println("dame puntos de defensa");
                int def = SC.nextInt();
                System.out.println("dame puntos de vida");
                int vida = SC.nextInt();
                SC.nextLine();


                System.out.println("Dime el oro de tu prota?");
                int oroProta = SC.nextInt();

                Personaje perNuevo = new Personaje(nom,attack,def,vida);
                ArrayList <Item>protagonistaBolsa=new ArrayList<>();
                System.err.println("De estos Items de armadura: ");
                for (int i = 0; i < bolsaArmadura.size(); i++) {
                    System.out.println(bolsaArmadura.get(i).toString());
                }
                System.out.println("Elige Uno Escribiendo su índice");
                int Indice=SC.nextInt();SC.nextLine();

                Item Armadura=bolsaArmadura.get(Indice);
                
                Protagonista nuevoProta= new Protagonista(perNuevo, Armadura, oroProta, protagonistaBolsa);
                personajes.add(perNuevo);
                protagonistas.add(nuevoProta);

            break;

            default:
                System.out.println("DIME PROTA O ENEMIGO");
            
        }
    }
   
    public static void crearItem(ArrayList<Item> bolsaActual,String nombre){
                System.out.println("dame puntos de ataque del item");
                int a = SC.nextInt();
                System.out.println("dame puntos de defensa del item");
                int d = SC.nextInt();
                System.out.println("dame puntos de vida del item");
                int v = SC.nextInt();
                SC.nextLine();

    
                System.out.println("Dime el precio de tu Item?");
                int precioItem = SC.nextInt(); SC.nextLine();

                System.out.println("¿Es tipo  CURATIVO o tipo ARMADURA?. Escribe en mayusculas");
                String tipoItem=SC.nextLine().toUpperCase();
                

            Tipo tipo = Tipo.valueOf(tipoItem);

                Item ItNuevo = new Item(nombre,precioItem,tipo,a,d,v);
            
                bolsaActual.add(ItNuevo);
                System.out.println("Te muestro tu nueva bolsa");
                mostrarObjetos(bolsaActual);
            
            
        }
    public static  void  PrepararJuegoFacil(Protagonista auxProta,ArrayList<Item> bolsaCurativos,ArrayList<Item> bolsaArmadItems,ArrayList<Item> itemsDefault){
                    ArrayList<Item> Itemsiniciales = new ArrayList<>();
                    auxProta.setOro(20);
                    //(Math.random() * (max - min + 1) + min);
                    int indiceItCura1= (int)(Math.random()*(bolsaCurativos.size()));
                    Itemsiniciales.add(itemsDefault.get(indiceItCura1));
                    int indiceItCura2= (int)(Math.random()*(bolsaCurativos.size()));
                    Itemsiniciales.add(itemsDefault.get(indiceItCura2));
                    auxProta.setBolsa(Itemsiniciales);
                    System.out.println("Modo Fácil activado. Recibes oro, armadura y 2 pociones.");
    }
    public static  void  PrepararJuegoDificil(Protagonista auxProta,ArrayList<Item> bolsaCurativos,ArrayList<Item> bolsaArmadItems,ArrayList<Item> itemsDefault){
                    ArrayList<Item> ItemsinicialesDificil = new ArrayList<>();
                    auxProta.setOro(0);
                    auxProta.setArmadura(null);
                    auxProta.setBolsa(ItemsinicialesDificil); // Bolsa vacía
                    System.out.println("Modo Difícil. Empiezas sin nada.");
    }
       
public static void jugarJuego(Protagonista prota, ArrayList<Enemigo> enemigos, ArrayList<Item> todosLosItems, int dificultad) {
        int derrotados = 0;
        boolean jugando = true;

        while (prota.getProtagonista().getHealthPoints() > 0 && jugando==true) {
            Enemigo e = enemigos.get((int) (Math.random() * enemigos.size()));
            int hpEnemigo = e.getPersonaje().getHealthPoints();
            System.out.println(e.toString());

            // Bucle de Combate
        while (hpEnemigo > 0 && prota.getProtagonista().getHealthPoints() > 0) {
            System.out.println("\nTU HP: " + prota.getProtagonista().getHealthPoints() + " | ORO: " + prota.getOro());
            System.out.println("Acciones disponibles: ATACAR, ITEM, SALIR");
            
            String entrada = SC.nextLine().toUpperCase();
            OPCION_JUGAR seleccion= OPCION_JUGAR.valueOf(entrada);

            switch (seleccion) {
                case ATACAR:
                    hpEnemigo =hpEnemigo - prota.getProtagonista().getAttackPoints();
                    System.out.println("¡Zas! Atacas. HP del " + e.getPersonaje().getName() + ": " + Math.max(0, hpEnemigo));
                    break;

                case ITEM:
                    usarItemEnCombate(prota);
                    // Nota: Usar un item también gasta el turno, por lo que el enemigo atacará después
                    break;

                case SALIR:
                    System.out.println("Huyes cobardemente del combate...");
                    jugando = false;
                    break;
            }

            // Turno del Enemigo (solo si sigue vivo y no hemos salido)
            if (hpEnemigo > 0 && jugando==true) {
                // Cálculo de defensa total (Base + Armadura)
                int defensaTotal = prota.getProtagonista().getDefenPoints();
                if (prota.getArmadura() != null) {
                    defensaTotal += prota.getArmadura().getDefenPoints();
                }

                int daño = Math.max(0, e.getPersonaje().getAttackPoints() - defensaTotal);
                prota.getProtagonista().setHealthPoints(prota.getProtagonista().getHealthPoints() - daño);
                
                System.out.println(e.getPersonaje().getName() + " contraataca y te quita " + daño + " de vida.");
            }
        }

        // Procesar victoria
        if (hpEnemigo <= 0 && prota.getProtagonista().getHealthPoints() > 0) {
            System.out.println("¡Has derrotado a " + e.getPersonaje().getName() + "!");
            derrotados++;
            e.setVecesDerrotado(e.getVecesDerrotado() + 1);
            prota.setOro(prota.getOro() + e.getOroDerrotado());
            
            // Abrir la tienda tras la victoria
            abrirTienda(prota, todosLosItems, dificultad);
        }
    }

    System.out.println("\n--- FIN DE LA AVENTURA ---");
    System.out.println("Puntuación Final: " + prota.getProtagonista().getName() + " - Enemigos derrotados: " + derrotados);
}
    

public static void usarItemEnCombate(Protagonista p) {
        ArrayList<Item> bolsa = p.getBolsa();
        if (bolsa == null || bolsa.isEmpty()) {
            System.out.println("No tienes items.");
            return;
        }
        System.out.println("Tus ITEMS curativos actuales son:");
        for (int i = 0; i < bolsa.size(); i++) {
            if (bolsa.get(i).getTipoItem() == Tipo.CURATIVO)
                System.out.println(i + ". " + bolsa.get(i).getNombre() + " (+" + bolsa.get(i).getHealthPoints() + " HP)");
        }
        System.out.println("¿Cual usas? (Número)");
        int cual = SC.nextInt(); SC.nextLine();
        if (cual >= 0 && cual < bolsa.size()) {
            Item it = bolsa.remove(cual);
            p.getProtagonista().setHealthPoints(p.getProtagonista().getHealthPoints() + it.getHealthPoints());
            System.out.println("Usado. HP actual: " + p.getProtagonista().getHealthPoints());
        }
    }

public static void abrirTienda(Protagonista auxProta, ArrayList<Item> todosMisItems, int dif) {
        System.out.println("\n--- TIENDA --- Oro: " + auxProta.getOro());
        ArrayList<Item> oferta = new ArrayList<>();

        // Lógica simplificada: 3 items al azar para la oferta
        for(int i=0; i<3; i++) {
            oferta.add(todosMisItems.get((int)(Math.random()*todosMisItems.size())));
        }
        boolean haComprado = false;
        for (int i = 0; i < oferta.size(); i++) {
            System.out.println(i + ". " + oferta.get(i).getNombre() + " (" + oferta.get(i).getPrize() + " oro)");
        }
        boolean tiendaAbierta = true; //sigoComprando? Sí, mientras que no se haya elegido el artículo a comprar
        boolean yaComproEnDificil = false; //compruebo si ha comprado en esta vuelta del juego
        while (tiendaAbierta==true &&yaComproEnDificil==false) {
            System.out.println("¿Qué quieres comprar? (0 para salir)");
            int comp = SC.nextInt(); SC.nextLine();
           if (comp == 0) {
                    tiendaAbierta = false;
                    System.out.println("Saliendo de la tienda...");
                } else if (comp > 0 && comp <= oferta.size()) {
                    // Solo entramos aquí si el número es válido para un objeto
                    Item it = oferta.get(comp - 1); // Usamos -1 porque los arrays empiezan en 0
                    
                    if (auxProta.getOro() >= it.getPrize()) {
                        // ... lógica de compra ...
                    }
                } else {
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
            Item it = oferta.get(comp);
            if (auxProta.getOro() >= it.getPrize()) {
                auxProta.setOro(auxProta.getOro() - it.getPrize());
                auxProta.getBolsa().add(it);
                System.out.println("Comprado: " + it.getNombre());
                if (dif == 2) {
                    yaComproEnDificil = true; // Esto hará que el bucle termine en la siguiente vuelta
                    System.out.println("Modo Difícil: Solo se permite una compra por vez abierta tienda.");
                }
            } else {
                System.out.println("No tienes suficiente oro.");
            }
        }


}
}
