package control;

import vista.Casilla;

/**
 *
 * @author moral
 */
public class FabricaCasillas {

    public static Casilla crearCasilla(String caracter) {
        switch (caracter) {
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
            //Casilla vacia
            default:
                return new Casilla(false, false, false, false);
        }
    }
}
