package vista;

/**
 *
 * @author moral
 */
public class FabricaCasillas {

    public static Casilla crearCasilla(String codigo) {
        switch (codigo) {
            //Esquinas
            case "r":
                return new Casilla(true, false, true, false);
            case "q":
                return new Casilla(true, false, false, true);
            case "L":
                return new Casilla(false, true, true, false);
            case "J":
                return new Casilla(false, true, false, true);
            //Lados
            case "-":
                return new Casilla(true, false, false, false);
            case "_":
                return new Casilla(false, true, false, false);
            case "(":
                return new Casilla(false, false, true, false);
            case ")":
                return new Casilla(false, false, false, true);
            //Lados opuestos
            case "=":
                return new Casilla(true, true, false, false);
            case "H":
                return new Casilla(false, false, true, true);
            //3 lados
            case "<":
                return new Casilla(true, true, true, false);
            case ">":
                return new Casilla(true, true, false, true);
            case "^":
                return new Casilla(true, false, true, true);
            case "V":
                return new Casilla(false, true, true, true);
            //Castillo
            case "C":
                Casilla c = new Casilla();
                c.colocarCastillo();
                return c;
            //Spawner
            case "S":
                Casilla s = new Casilla();
                s.colocarSpawner();
                return s;
            //Casilla inaccesible
            case "X":
                Casilla i = new Casilla();
                i.hacerInaccesible();
                return i;
            //Casilla vacia
            default:
                return new Casilla();
        }
    }
}
