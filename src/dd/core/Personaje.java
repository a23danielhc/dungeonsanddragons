package dd.core;

interface Ataque{
    int atacar(Personaje atacado);
}

class AtaqueEspada implements Ataque{
    public int atacar(Personaje atacado){
        int danoBase = 100;
        int acierto = (int)(Math.random()*2);
        double factor = Math.random()*1;
        int danoTotal = (int)(danoBase * acierto * factor);
        atacado.restarSalud(danoTotal);
        return danoTotal;
    }
}

class AtaqueArco implements Ataque{
    public int atacar(Personaje atacado){
        int danoBase = 50;
        int acierto = (int)(Math.random()*2);
        double factor = Math.random()*1;
        int danoTotal = (int)(danoBase * acierto * factor);
        atacado.restarSalud(danoTotal);
        return danoTotal;
    }
}

class AtaqueCuchillo implements Ataque{
    public int atacar(Personaje atacado){
        int danoBase = 25;
        int acierto = (int)(Math.random()*2);
        double factor = Math.random()*1;
        int danoTotal = (int)(danoBase * acierto * factor);
        atacado.restarSalud(danoTotal);
        return danoTotal;
    }
}

public abstract class Personaje {
    
    int salud;
    String nombre;
    Ataque ataque;

    @Override
    public String toString(){
        return "[ " + nombre + ": " + salud + " ]";
    }

    public abstract int atacar(Personaje troll);

    public int getSalud() {
        return salud;
    }

    public String getNombre(){
        return "[ " + nombre + " ]";
    }

    public void restarSalud (int resta){
        this.salud -= resta;
    }

}
