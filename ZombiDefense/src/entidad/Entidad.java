package entidad;

/**
 *
 * @author moral
 */
public abstract class Entidad {

    public double vidaMax, vidaActual, ataque, defensa;
    public int rangoMovimiento, rangoAtaque;

    //Funcion usada cuando una entidad es atacada
    //Disminuye la vida. Puede retornar daño en caso de habilidades
    public abstract double recibirDano(double dano);
}
