package entidad;

import java.util.Random;

/**
 *
 * @author moral
 */
public class FabricaZombis {

    //Funcion que retorna un zombi con una habilidad aleatoria
    public static Zombi generarZombi() {
        HabilidadZO hab;
        Random r = new Random();
        int opcion = r.nextInt(10); //Genera un numero entre 0 y 9 (10 numeros = 100%)
        if (opcion < 3) {
            //(0,1,2) -> 30% de probabilidad de un Zombi Saludable
            hab = HabilidadZO.Saludable;
        } else if (opcion < 6) {
            //(3,4,5) -> 30% de probabilidad de un Zombi Tanque
            hab = HabilidadZO.Tanque;
        } else if (opcion < 8) {
            //(6,7) -> 20% de probabilidad de un Zombi Bruto
            hab = HabilidadZO.Bruto;
        } else if (opcion == 8) {
            //(8) -> 10% de probabilidad de un Zombi Vampiro
            hab = HabilidadZO.Vampirismo;
        } else {
            //(9) -> 10% de probabilidad de un Zombi Espinoso
            hab = HabilidadZO.Espinas;
        }
        return new Zombi(hab);
    }

    public static Zombi generarZombiSaludable() {
        return new Zombi(HabilidadZO.Saludable);
    }
}
