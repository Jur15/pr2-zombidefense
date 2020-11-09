package item;

/**
 *
 * @author moral
 */
public class Objeto {
    public String nombre, descripcion;
    public double bonus;
    public TipoObjeto tipo;

    public Objeto(String nombre, String descripcion, double bonus, TipoObjeto tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bonus = bonus;
        this.tipo =  tipo;
    }
}
