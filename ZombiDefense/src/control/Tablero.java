package control;

import entidad.*;
import java.util.*;
import vista.TableroVista;



/**
 *
 * @author moral
 */
public class Tablero {

    Personaje pers1, pers2, pers3;
    ArrayList<Zombi> zombis;
    TableroVista ventana;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear personajes
        Personaje p1 = new Personaje("Ninja",Arrays.asList(HabilidadPJ.Cazador,HabilidadPJ.Sigiloso,HabilidadPJ.Retirada));
        Personaje p2 = new Personaje("Caballero",Arrays.asList(HabilidadPJ.Tanque,HabilidadPJ.Demoledor,HabilidadPJ.Furioso));
        Personaje p3 = new Personaje("Nigromante",Arrays.asList(HabilidadPJ.Medico,HabilidadPJ.Toxico,HabilidadPJ.Necromancia));
        //Crear ventana
        TableroVista ventana = new TableroVista();
        //Inicializar
        ventana.setVisible(true);
    }

}
