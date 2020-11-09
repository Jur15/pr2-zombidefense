package entidad;

import arma.Arma;
import control.Constantes;
import item.Objeto;
import java.util.*;

/**
 *
 * @author moral
 */
public class Personaje extends Entidad {

    public String nombre;
    public double nivel, experiencia;
    public Arma armaEquipada;
    public List<HabilidadPJ> habilidades;
    public ArrayList<Objeto> inventario;
    public boolean habRetiradaActiva, habFuriosoActiva;

    //Constructor
    public Personaje(String nombre, List<HabilidadPJ> habil) {
        this.nombre = nombre;
        this.habilidades = habil;
        this.vidaMax = Constantes.PJ_HPBase;
        //Validacion Habilidad Saludable
        if (habilidades.get(0) == HabilidadPJ.Saludable) {
            vidaMax += vidaMax * Constantes.PJ_HabSaludable_Valor;
        }
        this.vidaActual = vidaMax;
        this.ataque = Constantes.PJ_AttBase;
        this.defensa = Constantes.PJ_DefBase;
        //Validacion Habilidad Tanque
        if (habilidades.get(0) == HabilidadPJ.Tanque) {
            defensa += defensa * Constantes.PJ_HabTanque_Valor;
        }
        this.rangoMovimiento = Constantes.PJ_MovBase;
        //Validacion Habilidad Explorador
        if (habilidades.get(0) == HabilidadPJ.Explorador) {
            rangoMovimiento += Constantes.PJ_HabExplorador_Valor;
        }
        this.rangoAtaque = Constantes.PJ_AlcBase;
        //Validacion Habilidad Cazador
        if (habilidades.get(0) == HabilidadPJ.Cazador) {
            rangoAtaque += Constantes.PJ_HabCazador_Valor;
        }
        this.nivel = 1;
        this.experiencia = 0;
        this.armaEquipada = null;
        this.inventario = new ArrayList<>();
        this.habRetiradaActiva = false;
        this.habFuriosoActiva = false;
    }

    @Override
    public double recibirDano(double dano) {
        double total = dano - defensa;
        this.vidaActual -= total;
        //Si el personaje muere termina la accion
        if (vidaActual <= 0) {
            vidaActual = 0;
            return 0;
        }
        //Validacion Habilidad Retirada
        if (isHabDesbloqueada(HabilidadPJ.Retirada) && vidaActual / vidaMax <= Constantes.PJ_HabRetirada_Activacion && !habRetiradaActiva) {
            habRetiradaActiva = true;
            rangoMovimiento += Constantes.PJ_HabRetirada_Valor;
        }
        //Validacion Habilidad Furioso
        if (isHabDesbloqueada(HabilidadPJ.Furioso) && vidaActual / vidaMax <= Constantes.PJ_HabFurioso_Activacion && !habFuriosoActiva) {
            habFuriosoActiva = true;
            ataque += Constantes.PJ_HabFurioso_Valor;
        }
        //Validacion Habilidad Toxico
        if (isHabDesbloqueada(HabilidadPJ.Toxico)) {
            return total * Constantes.PJ_HabToxico_Valor;
        } else {
            return 0;
        }
    }

    //Funcion utilizada cuando se recibe daño que no puede ser defendido o devuelto
    private void recibirDanoMenor(double dano) {
        this.vidaActual -= dano;
        //Si el personaje muere termina la accion
        if (vidaActual <= 0) {
            vidaActual = 0;
            return;
        }
        //Validacion Habilidad Retirada
        if (isHabDesbloqueada(HabilidadPJ.Retirada) && vidaActual / vidaMax <= Constantes.PJ_HabRetirada_Activacion && !habRetiradaActiva) {
            habRetiradaActiva = true;
            rangoMovimiento += Constantes.PJ_HabRetirada_Valor;
        }
        //Validacion Habilidad Furioso
        if (isHabDesbloqueada(HabilidadPJ.Furioso) && vidaActual / vidaMax <= Constantes.PJ_HabFurioso_Activacion && !habFuriosoActiva) {
            habFuriosoActiva = true;
            ataque += Constantes.PJ_HabFurioso_Valor;
        }
    }

    public double atacar(Entidad ent) {
        //Validacion Habilidad Demoledor
        if (isHabDesbloqueada(HabilidadPJ.Demoledor)) {
            ent.defensa -= Constantes.PJ_HabDemoledor_Valor;
            //La defensa no puede ser menor a 0
            if(ent.defensa < 0) {
                ent.defensa = 0;
            }
        }
        //Ataca al objetivo
        double danoRegresado = ent.recibirDano(calcularDano());
        //Validacion Habilidad Necromancia
        if (isHabDesbloqueada(HabilidadPJ.Necromancia)) {
            recuperarHP(Constantes.PJ_HabNecromancia_Valor);
        }
        //Procesa el dano regresado
        recibirDanoMenor(danoRegresado);

        //Ruido
        double ruido = 0;
        if (armaEquipada != null) {
            ruido = armaEquipada.ruido;
        }
        //Validacion Habilidad Sigiloso
        if (isHabDesbloqueada(HabilidadPJ.Sigiloso)) {
            ruido -= ruido * Constantes.PJ_HabSigiloso_Valor;
        }
        return ruido;
    }

    //Funcion usada para calcular el daño total realizado por este personaje
    private double calcularDano() {
        double dano = this.ataque;
        if (armaEquipada != null) {
            dano += armaEquipada.ataque;
        }
        return dano;
    }

    public void usarObjeto(Objeto obj) {
        switch (obj.tipo) {
            case Vendas:
                recuperarHP_Objeto(obj.bonus);
                break;
            case Botiquin:
                recuperarHP_Objeto(obj.bonus);
                break;
            case XPBronce:
                ganarExp(obj.bonus);
                break;
            case XPPlata:
                ganarExp(obj.bonus);
                break;
            case XPOro:
                ganarExp(obj.bonus);
                break;
            case BoostAtt:
                ataque += obj.bonus;
                break;
            case BoostDef:
                defensa += obj.bonus;
                break;
            case Botas:
                rangoMovimiento += obj.bonus;
                break;
            case Mira:
                rangoAtaque += obj.bonus;
                break;
        }
    }

    public void ganarExp(double monto) {
        double total = monto;
        //Validacion Habilidad DuplicarExp
        if (isHabDesbloqueada(HabilidadPJ.Veterano)) {
            total += total * Constantes.PJ_HabVeterano_Valor;
        }
        //Agrega la experiencia
        experiencia += total;
        //Sube de nivel si es necesario
        if (experiencia >= Constantes.PJ_TotalNivel) {
            subirNivel();
        }
    }

    private void subirNivel() {
        //Sube el nivel y consume la exp necesaria
        nivel += 1;
        experiencia -= Constantes.PJ_TotalNivel;
        //Sube los stats
        vidaMax += Constantes.PJ_HPLevelUp;
        ataque += Constantes.PJ_AttLevelUp;
        defensa += Constantes.PJ_DefLevelUp;
        //Recupera la salud al maximo
        recuperarHP(vidaMax);
    }

    //Funcion llamada cuando se recupera salud al utilizar un objeto
    private void recuperarHP_Objeto(double monto) {
        double total = monto;
        //Validacion Habilidad DuplicarCura
        if (isHabDesbloqueada(HabilidadPJ.Medico)) {
            total += total * Constantes.PJ_HabMedico_Valor;
        }
        vidaActual += total;
        //La vida actual no puede sobrepasar la vida maxima
        if (vidaActual > vidaMax) {
            vidaActual = vidaMax;
        }
        recuperarAux_HabTemporales();
    }

    //Funcion llamada cuando se recupera salud de otras formas.
    private void recuperarHP(double monto) {
        vidaActual += monto;
        //La vida actual no puede sobrepasar la vida maxima
        if (vidaActual > vidaMax) {
            vidaActual = vidaMax;
        }
        recuperarAux_HabTemporales();
    }

    //Funcion auxiliar que desactiva las habilidades temporales si se sobrepasa el punto de activacion
    private void recuperarAux_HabTemporales() {
        //Validacion Habilidad Retirada
        if (isHabDesbloqueada(HabilidadPJ.Retirada) && habRetiradaActiva && vidaActual / vidaMax > Constantes.PJ_HabRetirada_Activacion) {
            habRetiradaActiva = false;
            rangoMovimiento -= Constantes.PJ_HabRetirada_Valor;
        }
        //Validacion Habilidad Furioso
        if (isHabDesbloqueada(HabilidadPJ.Furioso) && habFuriosoActiva && vidaActual / vidaMax > Constantes.PJ_HabFurioso_Activacion) {
            habFuriosoActiva = false;
            ataque -= Constantes.PJ_HabFurioso_Valor;
        }
    }

    //Funcion que indica si el personaje tiene una habilidad y está desbloqueada
    private boolean isHabDesbloqueada(HabilidadPJ hab) {
        int posHab = habilidades.indexOf(hab);
        //-1 = no esta, 0 = Hab 1, 1 = Hab 2, 2 = Hab 3
        switch (posHab) {
            case 0:
                return true; //Hab 1 siempre esta desbloqueada
            case 1:
                //Revisa si tiene el nivel necesario para usar la hab 2
                return nivel >= Constantes.PJ_NivelHab2;
            case 2:
                //Revisa si tiene el nivel necesario para usar la hab 3
                return nivel >= Constantes.PJ_NivelHab3;
            default:
                return false;
        }
    }
}
