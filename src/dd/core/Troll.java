package dd.core;

class Troll extends Personaje{

    private static int numeroTroll = 0;

    Troll(){
        this.salud = 1000;
        this.nombre = "Troll " + Integer.toString(numeroTroll);
        numeroTroll++;
        int estrategiaAtaque = (int)(Math.random()*2);
        if (estrategiaAtaque == 0){
            this.ataque = new AtaqueEspada();
        } else if (estrategiaAtaque == 1){
            this.ataque = new AtaqueArco();
        } else {
            this.ataque = new AtaqueCuchillo();
        }
    }

    public int atacar(Personaje atacado){
        return this.ataque.atacar(atacado);
    }
}
