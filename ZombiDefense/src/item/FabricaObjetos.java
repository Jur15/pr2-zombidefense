package item;

/**
 *
 * @author moral
 */
public class FabricaObjetos {

    public static ObjetoCuracion crearVendas() {
        int monto = 20;
        return new ObjetoCuracion("Vendas", "Recupera " + monto + " puntos de vida.", monto);
    }

    public static ObjetoCuracion crearBotiquin() {
        int monto = 50;
        return new ObjetoCuracion("Botiquin", "Recupera " + monto + " puntos de vida.", monto);
    }

    public static ObjetoEXP crearMedallaBronce() {
        int bonusEXP = 15;
        return new ObjetoEXP("Medalla de Bronce", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP);
    }

    public static ObjetoEXP crearMedallaPlata() {
        int bonusEXP = 30;
        return new ObjetoEXP("Medalla de Plata", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP);
    }

    public static ObjetoEXP crearMedallaOro() {
        int bonusEXP = 50;
        return new ObjetoEXP("Medalla de Oro", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP);
    }

    public static ObjetoBoost crearTonicoAtaque() {
        int bonus = 10;
        return new ObjetoBoost("Tonico de Ataque", "Aumenta el ataque en un " + bonus + "%.", bonus);
    }

    public static ObjetoBoost crearTonicoDefensa() {
        int bonus = 10;
        return new ObjetoBoost("Tonico de Defensa", "Aumenta la defensa en un " + bonus + "%.", bonus);
    }

    public static ObjetoBoost crearBotas() {
        int bonus = 2;
        return new ObjetoBoost("Botas Aladas", "Permite moverse " + bonus + " casillas más.", bonus);
    }

    public static ObjetoBoost crearMira() {
        int bonus = 2;
        return new ObjetoBoost("Mira", "Aumenta el alcance del siguiente ataque en " + bonus + " casillas.", bonus);
    }
}
