package item;

/**
 *
 * @author moral
 * @desc Medallas de EXP
 */
public class ObjetoEXP extends Objeto{
    
    public int montoEXP;

    public ObjetoEXP(String nombre, String descripcion, int montoEXP) {
        super(nombre, descripcion);
        this.montoEXP = montoEXP;
    }
}
