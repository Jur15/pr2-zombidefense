package arma;

/**
 *
 * @author moral
 */
public abstract class Arma {

    public int ataque, ruido, rango;

    public Arma(int ataque, int ruido, int rango) {
        this.ataque = ataque;
        this.ruido = ruido;
        this.rango = rango;
    }

}
