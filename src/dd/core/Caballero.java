package dd.core;

class Caballero extends Personaje{

    private static int numeroCaballero = 0;

    Caballero() {
        this.salud = 1200;
        if (numeroCaballero == 0){
            this.nombre = "Lancelot";
            this.ataque = new AtaqueEspada();
            numeroCaballero++;
        } else if (numeroCaballero == 1) {
            this.nombre = "Perceval";
            this.ataque = new AtaqueArco();
        }
    }
    
    public int atacar(Personaje atacado){
        return this.ataque.atacar(atacado);
    }
}
