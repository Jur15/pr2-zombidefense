package item;

/**
 *
 * @author moral
 * @desc Infusiones de defensa o ataque, mayor rango de movimiento/ataque
 */
public class ObjetoBoost extends Objeto {

    public int bonus;

    public ObjetoBoost(String nombre, String descripcion, int bonus) {
        super(nombre, descripcion);
        this.bonus = bonus;
    }
}
