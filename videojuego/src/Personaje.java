public class Personaje implements Comparable <Personaje>{

    private String name;
    private int attackPoints;
    private int defenPoints;
    private int healthPoints;

    //getter setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAttackPoints() {
        return attackPoints;
    }
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
    public int getDefenPoints() {
        return defenPoints;
    }
    public void setDefenPoints(int defenPoints) {
        this.defenPoints = defenPoints;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    //constructor
    public Personaje(String name, int attackPoints, int defenPoints, int healthPoints) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defenPoints = defenPoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString(){
        String str = "Nombre: "+ this.name + " \nAtaque : "+ this.attackPoints + " \nDefensa : "+ this.defenPoints + " \nSalud : "+ this.healthPoints +" ";
        return str;
    }

    @Override
    public int compareTo(Personaje o) {
        if(this.name.compareTo(o.getName())>0){
            return +1;
        }else if(this.name.compareTo(o.getName())<0){
            return -1;
        }else return 0;
    }
    
}
