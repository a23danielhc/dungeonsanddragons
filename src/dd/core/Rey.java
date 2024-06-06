package dd.core;

class Rey extends Personaje{
    
    private static Rey instance;

    public static Rey getInstance(){
        if (instance == null){
            instance = new Rey();
        }
        return instance;
    }

    private Rey() {
        this.salud = 2000;
        this.nombre = "Arturo";
        this.ataque = new AtaqueEspada();
    }

    public int atacar(Personaje atacado){
        return this.ataque.atacar(atacado);
    }
}
