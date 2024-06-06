package dd.core;

public class GameController {
    
    Personaje[] reyCaballeros;
    Personaje[] trolls;

    public GameController() {
        reyCaballeros = new Personaje[3];
        reyCaballeros[0] = Rey.getInstance();
        reyCaballeros[1] = new Caballero();
        reyCaballeros[2] = new Caballero();
        int trollsNumber = (int)(Math.random()*10);
        if (trollsNumber <= 2){
            trollsNumber = 2;
        }
        trolls = new Troll[trollsNumber];
        for (int i = 0; i < trollsNumber; i++){
            trolls[i] = new Troll();
        }
    }

    public Personaje[] getPersonajes(){
        return reyCaballeros;
    }

    public Personaje[] getTrolls(){
        return trolls;
    }

    public void eliminarCaballero(int muerto){
        reyCaballeros[muerto] = null;
        if (reyCaballeros.length == 1) {
            System.out.println("Los trolls han ganado la partida");
            System.out.print("Han sobrevivido: " + getTrolls());
            System.exit(0);
        } else {
            renovarLista();
        }
    }

    public void eliminarTroll(int muerto){
        trolls[muerto] = null;
        if (trolls.length == 1) {
            System.out.println("Los caballeros han ganado la partida");
            System.out.print("Han sobrevivido: ");
            
            System.exit(0);
        } else {
            renovarListaTrolls();
        }
    }

    private void renovarLista(){
        Personaje[] aux = new Personaje[reyCaballeros.length-1];
        int i = 0;
        for (Personaje x: reyCaballeros){
            if (x != null){
                aux[i++] = x;
            }
        }
        reyCaballeros = aux;
    }

    public void renovarListaTrolls(){
        Personaje[] aux = new Personaje[trolls.length-1];
        int i = 0;
        for (Personaje x: trolls){
            if (x != null){
                aux[i++] = x;
            }
        }
        trolls = aux;
    }
}
