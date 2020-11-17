package control;

import entidad.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Casilla;
import vista.TableroVista;

/**
 *
 * @author moral
 */
public class Tablero {

    Personaje pers1, pers2, pers3;
    ArrayList<Zombi> zombis;
    ArrayList<ArrayList<Casilla>> casillas;
    TableroVista ventana;

    public Tablero(Personaje pers1, Personaje pers2, Personaje pers3, TableroVista ventana) {
        this.pers1 = pers1;
        this.pers2 = pers2;
        this.pers3 = pers3;
        this.ventana = ventana;
        casillas = new ArrayList<>();
        zombis = new ArrayList<>();
    }

    public void inicializar(String urlMapa) {
        try {
            cargarMapa(urlMapa);
            inicializarVista();
        } catch (FileNotFoundException ex) {
            //Detiene la ejecucion si no se puede cargar el mapa
            System.out.println("Error al cargar el mapa.");
            System.exit(1);
        }
    }

    public void cargarMapa(String archivo) throws FileNotFoundException {
        ArrayList<ArrayList<Casilla>> mapa = new ArrayList<>();
        File arch = new File(archivo);
        Scanner lector = new Scanner(arch);
        while(lector.hasNextLine()) {
            String linea = lector.nextLine();
            String[] casillas = linea.split(" ");
            ArrayList<Casilla> fila = new ArrayList<>();
            for(String cas : casillas) {
                fila.add(FabricaCasillas.crearCasilla(cas));
            }
            mapa.add(fila); 
        }
        casillas = mapa;
    }

    private void inicializarVista() {
        //Agregar casillas
        for (ArrayList<Casilla> fila : casillas) {
            for (Casilla c : fila) {
                ventana.getPanelTablero().add(c);
            }
        }
        //Hacer visible
        ventana.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear personajes
        Personaje p1 = new Personaje("Ninja", Arrays.asList(HabilidadPJ.Cazador, HabilidadPJ.Sigiloso, HabilidadPJ.Retirada));
        Personaje p2 = new Personaje("Caballero", Arrays.asList(HabilidadPJ.Tanque, HabilidadPJ.Demoledor, HabilidadPJ.Furioso));
        Personaje p3 = new Personaje("Nigromante", Arrays.asList(HabilidadPJ.Medico, HabilidadPJ.Toxico, HabilidadPJ.Necromancia));
        //Crear ventana
        TableroVista ventana = new TableroVista();

        //Iniciar programa
        Tablero tablero = new Tablero(p1, p2, p3, ventana);
        tablero.inicializar("maps/MapaBase.txt");
    }

}
