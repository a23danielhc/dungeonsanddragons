package dd.main;

import dd.core.GameController;
import dd.core.Personaje;

class DDApp{

    GameController juego;

    DDApp(){
        juego = new GameController();
        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera,\n" + //
                        "la partida formada por: [[Rey Arturo], [Lancelot], [Percival]]\n" + //
                        "hallándose en los frondosos bosques del sitio de Deorham, se topó con una\n" + //
                        "patrulla de 3 de esas sanguinarias e inhumanas criaturas popularmente\n" + //
                        "conocidas como trolls.[ " + juego.getPersonajes()[0].getNombre() + " " + juego.getPersonajes()[1].getNombre() + " " + juego.getPersonajes()[2].getNombre() + " ]");

    }

    private void turnoCaballeros(){
        System.out.println("Turno de los caballeros:");
        for (int x = 0; x < getCaballeros().length; x++){

            //Saltarse trolls muertos
            if (getCaballeros()[x] == null) {
                continue;
            }

            //Selecciona un caballero al azar y le ataca
            int trollAtacado = (int)(Math.random()*getTrolls().length);
            int danio = getCaballeros()[x].atacar(getTrolls()[trollAtacado]);
            System.out.println(getCaballeros()[x].toString() + " ataca a " + getTrolls()[trollAtacado].toString() + " (-" + danio + ")");
            if (getCaballeros()[x].getClass().getSimpleName().equals("Rey")){
                System.out.println(getCaballeros()[x].toString() + " ataca a " + getTrolls()[trollAtacado].toString() + " (-" + danio + ")");
                System.out.println(getCaballeros()[x].toString() + " ataca a " + getTrolls()[trollAtacado].toString() + " (-" + danio + ")");
            } else {
                System.out.println(getCaballeros()[x].toString() + " ataca a " + getTrolls()[trollAtacado].toString() + " (-" + danio + ")");
            }
            //Eliminar caballero muerto
            if (getTrolls()[trollAtacado].getSalud() <= 0){
                System.out.println("El troll " + getTrolls()[trollAtacado].getNombre() + " ha muerto");
                juego.eliminarTroll(trollAtacado);
            }
            for (Personaje p : getTrolls()){
                if (p == null){
                    System.out.println("Los caballeros han ganado la partida");
                    System.exit(0);
                }
            }
        }
        turnoTrolls();
    }

    private void turnoTrolls(){
        System.out.println("Turno de los trolls:");
        for (int x = 0; x < getTrolls().length; x++){

            //Saltarse trolls muertos
            if (getTrolls()[x] == null) {
                continue;
            }

            //Selecciona un caballero al azar y le ataca
            int caballeroAtacado = (int)(Math.random()*getCaballeros().length);
            int danio = getTrolls()[x].atacar(getCaballeros()[caballeroAtacado]);
            System.out.println(getTrolls()[x].toString() + " ataca a " + getCaballeros()[caballeroAtacado].toString() + " (-" + danio + ")");

            //Eliminar caballero muerto
            if (getCaballeros()[caballeroAtacado].getSalud() <= 0){
                System.out.println("El caballero " + getCaballeros()[caballeroAtacado].getNombre() + " ha muerto");
                juego.eliminarCaballero(caballeroAtacado);
            }
            for (Personaje p : getCaballeros()){
                if (p == null){
                    System.out.println("Los trolls han ganado la partida");
                    System.exit(0);
                }
            }
        }
        turnoCaballeros();

    }

    private Personaje[] getCaballeros(){
        return juego.getPersonajes();
    }

    private Personaje[] getTrolls(){
        return juego.getTrolls();
    }

    public static void main(String[] args) {
        DDApp base = new DDApp();
        base.turnoCaballeros();
        base.turnoTrolls();
    }
}