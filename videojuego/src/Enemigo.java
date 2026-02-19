public class Enemigo {
    private int vecesDerrotado;
    private int oroDerrotado;
    private Personaje personaje;

    public Enemigo(int vecesDerrotado, int oroDerrotado, Personaje personaje) {
        this.vecesDerrotado = vecesDerrotado;
        this.oroDerrotado = oroDerrotado;
        this.personaje = personaje;
    }

    public int getVecesDerrotado() {
        return vecesDerrotado;
    }
    public void setVecesDerrotado(int vecesDerrotado) {
        this.vecesDerrotado = vecesDerrotado;
    }
    public int getOroDerrotado() {
        return oroDerrotado;
    }
    public void setOroDerrotado(int oroDerrotado) {
        this.oroDerrotado = oroDerrotado;
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
}
