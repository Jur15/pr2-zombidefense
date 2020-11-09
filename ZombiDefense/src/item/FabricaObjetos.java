package item;

import control.Constantes;

/**
 *
 * @author moral
 */
public class FabricaObjetos {

    public static Objeto crearVendas() {
        double monto = Constantes.OBJ_Vendas_Bonus;
        return new Objeto("Vendas", "Recupera " + monto + " puntos de vida.", monto, TipoObjeto.Vendas);
    }

    public static Objeto crearBotiquin() {
        double monto = Constantes.OBJ_Botiquin_Bonus;
        return new Objeto("Botiquin", "Recupera " + monto + " puntos de vida.", monto, TipoObjeto.Botiquin);
    }

    public static Objeto crearMedallaBronce() {
        double bonusEXP = Constantes.OBJ_XPBronce_Bonus;
        return new Objeto("Medalla de Bronce", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP, TipoObjeto.XPBronce);
    }

    public static Objeto crearMedallaPlata() {
        double bonusEXP = Constantes.OBJ_XPPlata_Bonus;
        return new Objeto("Medalla de Plata", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP, TipoObjeto.XPPlata);
    }

    public static Objeto crearMedallaOro() {
        double bonusEXP = Constantes.OBJ_XPOro_Bonus;
        return new Objeto("Medalla de Oro", "Otorga " + bonusEXP + " puntos de experiencia.", bonusEXP, TipoObjeto.XPOro);
    }

    public static Objeto crearTonicoAtaque() {
        double bonus = Constantes.OBJ_BoostAtt_Bonus;
        return new Objeto("Tonico de Ataque", "Aumenta el ataque en " + bonus + "puntos.", bonus, TipoObjeto.BoostAtt);
    }

    public static Objeto crearTonicoDefensa() {
        double bonus = Constantes.OBJ_BoostDef_Bonus;
        return new Objeto("Tonico de Defensa", "Aumenta la defensa en un " + bonus + ".", bonus, TipoObjeto.BoostDef);
    }

    public static Objeto crearBotas() {
        double bonus = Constantes.OBJ_Movim_Bonus;
        return new Objeto("Botas Aladas", "Permite moverse " + bonus + " casillas más lejos.", bonus, TipoObjeto.Botas);
    }

    public static Objeto crearMira() {
        double bonus = Constantes.OBJ_Alcance_Bonus;
        return new Objeto("Mira", "Aumenta el alcance de los ataques en " + bonus + " casillas.", bonus, TipoObjeto.Mira);
    }
}
