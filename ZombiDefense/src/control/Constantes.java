package control;

/**
 *
 * @author moral
 */
public final class Constantes {

    //Personajes
    //  Stats base
    public static final double PJ_HPBase = 100;
    public static final double PJ_AttBase = 25;
    public static final double PJ_DefBase = 10;
    public static final int PJ_MovBase = 3;
    public static final int PJ_AlcBase = 2;
    //  Niveles Exp
    public static final double PJ_TotalNivel = 50;
    public static final int PJ_NivelHab2 = 3;
    public static final int PJ_NivelHab3 = 5;
    //  Stats subida nivel
    public static final double PJ_HPLevelUp = 25;
    public static final double PJ_AttLevelUp = 5;
    public static final double PJ_DefLevelUp = 3;
    //  Valores Habilidades
    public static final int PJ_HabExplorador_Valor = 2; //Casillas extra
    public static final int PJ_HabCazador_Valor = 2; //Casillas extra
    public static final double PJ_HabMedico_Valor = 1; //% de curacion extra recibida
    public static final double PJ_HabVeterano_Valor = 1; //% de exp extra recibida
    public static final double PJ_HabSaludable_Valor = 0.5; //% de vida extra
    public static final double PJ_HabSigiloso_Valor = 0.5; //% de reduccion de ruido
    public static final double PJ_HabRetirada_Activacion = 0.3; //% de salud restante
    public static final int PJ_HabRetirada_Valor = 3; //Casillas extra
    public static final double PJ_HabNecromancia_Valor = 20; //Puntos de salud recuperada
    public static final double PJ_HabToxico_Valor = 0.3; //% de daño regresado
    public static final double PJ_HabTanque_Valor = 0.5; //% de defensa extra
    public static final double PJ_HabDemoledor_Valor = 2; //Puntos de armadura disminuidos
    public static final double PJ_HabFurioso_Activacion = 0.3; //% de salud restante
    public static final double PJ_HabFurioso_Valor = 10; //Bonus de ataque

    //Zombis
    //  Stats base
    public static final double ZO_HPBase = 50;
    public static final double ZO_AttBase = 30;
    public static final double ZO_DefBase = 7;
    public static final int ZO_MovBase = 2;
    public static final int ZO_AlcBase = 2;
    public static final int ZO_VisBase = 6;
    //  Valores Habilidades
    public static final double ZO_HabSaludable_Valor = 1; //% de vida extra
    public static final double ZO_HabTanque_Valor = 1; //% de defensa extra
    public static final double ZO_HabVampirismo_Valor = 0.5; //% del daño convertido en vida
    public static final double ZO_HabEspinas_Valor = 0.4; //% de daño regresado

    //Objetos
    public static final double OBJ_Vendas_Bonus = 20;
    public static final double OBJ_Botiquin_Bonus = 50;
    public static final double OBJ_XPBronce_Bonus = 15;
    public static final double OBJ_XPPlata_Bonus = 30;
    public static final double OBJ_XPOro_Bonus = 50;
    public static final double OBJ_BoostAtt_Bonus = 10;
    public static final double OBJ_BoostDef_Bonus = 10;
    public static final double OBJ_Movim_Bonus = 1;
    public static final double OBJ_Alcance_Bonus = 1;

    private Constantes() {
    }
;
}
