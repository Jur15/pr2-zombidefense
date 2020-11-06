package item;

/**
 *
 * @author moral
 * @desc Vendas y botiquines
 */
public class ObjetoCuracion extends Objeto {

    public int montoCurar;

    public ObjetoCuracion(String nombre, String descripcion, int montoCurar) {
        super(nombre, descripcion);
        this.montoCurar = montoCurar;
    }
}
