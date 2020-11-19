package entidad;

/**
 *
 * @author moral
 */
public abstract class Entidad {

    public String nombre,urlIcono;
    public double vidaMax, vidaActual, ataque, defensa;
    public int rangoMovimiento, rangoAtaque;
    public int posFila, posCol;

    //Funcion usada cuando una entidad es atacada
    //Disminuye la vida. Puede retornar daño en caso de habilidades
    public abstract double recibirDano(double dano);
    
    //Funcion usada para cambiar la posicion de la entidad
    public abstract void mover(int f, int c);
}
