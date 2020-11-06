package arma;

/**
 *
 * @author moral
 */
public class Arma_LargoAlc extends Arma {

    public int rangoMax;

    public Arma_LargoAlc(int ataque, int ruido, int rango, int rangoMax) {
        super(ataque, ruido, rango);
        this.rangoMax = rangoMax;
    }

}
