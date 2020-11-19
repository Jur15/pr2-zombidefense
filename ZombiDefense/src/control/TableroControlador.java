package control;

import vista.FabricaCasillas;
import entidad.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JOptionPane;
import vista.Casilla;
import vista.TableroVista;

/**
 *
 * @author moral
 */
public class TableroControlador extends MouseAdapter {

    //Personajes
    List<Personaje> personajes;
    boolean[] accionesP1, accionesP2, accionesP3;
    //Zombis
    ArrayList<Zombi> zombis;
    //Vista
    TableroVista ventana;
    //Casillas del tablero
    ArrayList<ArrayList<Casilla>> casillas;
    ArrayList<Integer[]> posSpawner;
    int[] posCastillo;

    public TableroControlador(Personaje pers1, Personaje pers2, Personaje pers3, TableroVista ventana) {
        personajes = new ArrayList<>();
        personajes.add(pers1);
        accionesP1 = new boolean[]{true, true, true};
        personajes.add(pers2);
        accionesP2 = new boolean[]{true, true, true};
        personajes.add(pers3);
        accionesP3 = new boolean[]{true, true, true};
        this.ventana = ventana;
        casillas = new ArrayList<>();
        zombis = new ArrayList<>();
        posSpawner = new ArrayList<>();
    }

    //---------Inicializacion------------
    public void inicializar(String urlMapa) {
        try {
            cargarMapa(urlMapa);
            inicializarVista();
        } catch (FileNotFoundException ex) {
            //Detiene la ejecucion si no se puede cargar el mapa
            JOptionPane.showMessageDialog(null, "Error al cargar el mapa.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    //Funcion encargada de leer el archivo de texto con el mapa y crear el tablero
    private void cargarMapa(String archivo) throws FileNotFoundException {
        int posFil = 0, posCol;
        ArrayList<ArrayList<Casilla>> mapa = new ArrayList<>();
        File arch = new File(archivo);
        Scanner lector = new Scanner(arch);
        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            String[] casillas = linea.split(" ");
            ArrayList<Casilla> fila = new ArrayList<>();
            posCol = 0;
            for (String cas : casillas) {
                Casilla c = FabricaCasillas.crearCasilla(cas);
                c.setPosicion(posFil, posCol);
                c.addMouseListener(this);
                fila.add(c);
                //Si la casilla tiene una estructura guarda su posición
                if (c.castillo) {
                    this.posCastillo = new int[]{posFil, posCol};
                } else if (c.spawner) {
                    this.posSpawner.add(new Integer[]{posFil, posCol});
                }
                posCol++;
            }
            mapa.add(fila);
            posFil++;
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
        //Colocar personajes
        for (Personaje p : personajes) {
            Casilla casP = obtenerCasillaDisponible(casillas.get(posCastillo[0]).get(posCastillo[1]));
            if (casP != null) {
                casP.ocupar(p);
                p.mover(casP.posFila, casP.posCol);
            } else {
                JOptionPane.showMessageDialog(null, "El mapa no tiene espacio para los personajes.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        //Hacer visible
        ventana.setVisible(true);
    }

    //Funcion que obtiene la primera casilla disponible alrededor de otra casilla
    private Casilla obtenerCasillaDisponible(Casilla cas) {
        //Limites
        int filaMin = Math.max(0, cas.posFila - 1);
        int filaMax = Math.min(9, cas.posFila + 1);
        int colMin = Math.max(0, cas.posCol - 1);
        int colMax = Math.min(19, cas.posCol + 1);
        //Revisa las casillas cercanas 1 a 1
        for (int f = filaMin; f <= filaMax; f++) {
            for (int c = colMin; c <= colMax; c++) {
                Casilla r = casillas.get(f).get(c);
                //Si la casilla esta disponible la retorna
                if (!r.inaccesible && !r.ocupada) {
                    return r;
                }
            }
        }
        //No hay casillas disponibles
        return null;
    }

    //---------Logica del juego------------
    //Funcion llamada cuando se hace click en una casilla
    @Override
    public void mouseClicked(MouseEvent e) {
        Casilla c = (Casilla) e.getComponent();
        actualizarCasillaSelec(c);
    }
    
    //Actualiza los detalles de la vista
    private void actualizarCasillaSelec(Casilla c) {
        ventana.ocultarDetalles();
        //TODO:No cambiar detalles si se esta moviendo
        if (c.ocupante != null) {
            if (c.ocupante instanceof Personaje) {
                Personaje ocu = (Personaje) c.ocupante;
                //Hay un personaje en la casilla
                //Array de string de habilidades
                String[] habs = new String[3];
                for (int i = 0; i < 3; i++) {
                    habs[i] = ocu.habilidades.get(i).toString();
                }
                ventana.actulizarStats(ocu.nombre, String.valueOf(ocu.vidaActual), String.valueOf(ocu.defensa), String.valueOf(ocu.ataque), habs);
                ventana.actualizarInven(ocu.inventario);
                int numJug = personajes.indexOf(ocu);
                switch(numJug) {
                    case 0:
                        ventana.setAccionMover(accionesP1[0]);
                        ventana.setAccionAtacar(accionesP1[1]);
                        ventana.setAccionUsarObj(accionesP1[2]);
                        break;
                    case 1:
                        ventana.setAccionMover(accionesP2[0]);
                        ventana.setAccionAtacar(accionesP2[1]);
                        ventana.setAccionUsarObj(accionesP2[2]);
                        break;
                    case 2:
                        ventana.setAccionMover(accionesP3[0]);
                        ventana.setAccionAtacar(accionesP3[1]);
                        ventana.setAccionUsarObj(accionesP3[2]);
                        break;
                }
                
            } else {
                //Hay un zombi en la casilla
                Zombi ocu = (Zombi) c.ocupante;
                ventana.actulizarStats(ocu.nombre, String.valueOf(ocu.vidaActual), String.valueOf(ocu.defensa), String.valueOf(ocu.ataque), new String[]{ocu.habilidad.toString()});
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear personajes
        Personaje p1 = new Personaje("Ninja", Constantes.IMG_PJNinja, Arrays.asList(HabilidadPJ.Cazador, HabilidadPJ.Sigiloso, HabilidadPJ.Retirada));
        Personaje p2 = new Personaje("Caballero", Constantes.IMG_PJCaballero, Arrays.asList(HabilidadPJ.Tanque, HabilidadPJ.Demoledor, HabilidadPJ.Furioso));
        Personaje p3 = new Personaje("Nigromante", Constantes.IMG_PJNigromante, Arrays.asList(HabilidadPJ.Medico, HabilidadPJ.Toxico, HabilidadPJ.Necromancia));
        //Crear ventana
        TableroVista ventana = new TableroVista();

        //Iniciar programa
        TableroControlador tablero = new TableroControlador(p1, p2, p3, ventana);
        tablero.inicializar("maps/Mapa1.txt");
    }

}
