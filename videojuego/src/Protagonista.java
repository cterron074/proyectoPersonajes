import java.util.ArrayList;

public class Protagonista {

    private Personaje protagonista;
    private Item armadura;
    private int oro;
    private ArrayList<Item> bolsa;
    public Personaje getProtagonista() {
        return protagonista;
    }
    public void setProtagonista(Personaje protagonista) {
        this.protagonista = protagonista;
    }
    public Item getArmadura() {
        return armadura;
    }
    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }
    public int getOro() {
        return oro;
    }
    public void setOro(int oro) {
        this.oro = oro;
    }
    public ArrayList<Item> getBolsa() {
        return bolsa;
    }
    public void setBolsa(ArrayList<Item> bolsa) {
        this.bolsa = bolsa;
    }
    public Protagonista(Personaje protagonista, Item armadura, int oro, ArrayList<Item> bolsa) {
        this.protagonista = protagonista;
        this.armadura = armadura;
        this.oro = oro;
        this.bolsa = bolsa;
    }
    
    
}
