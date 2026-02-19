public class Item {
     private String nombre;
     private int prize;
     private Tipo tipoItem;
     private int attackPoints;
     private int defenPoints;
     private int healthPoints;

     public String getNombre() {
          return nombre;
     }
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }
     public int getPrize() {
          return prize;
     }
     public void setPrize(int prize) {
          this.prize = prize;
     }
     public Tipo getTipoItem() {
          return tipoItem;
     }
     public void setTipoItem(Tipo tipoItem) {
          this.tipoItem = tipoItem;
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
     public Item(String nombre, int prize, Tipo tipoItem, int attackPoints, int defenPoints, int healthPoints) {
          this.nombre = nombre;
          this.prize = prize;
          this.tipoItem = tipoItem;
          this.attackPoints = attackPoints;
          this.defenPoints = defenPoints;
          this.healthPoints = healthPoints;
     }
     
     }
