package entidad;

import control.Constantes;

/**
 *
 * @author moral
 */
public class Zombi extends Entidad {

    public int rangoVision;
    public HabilidadZO habilidad;

    public Zombi(HabilidadZO hab) {
        this.nombre = "Zombi";
        this.habilidad = hab;
        this.vidaMax = Constantes.ZO_HPBase;
        //Validacion Habilidad Saludable
        if(habilidad == HabilidadZO.Saludable) {
            vidaMax += vidaMax * Constantes.ZO_HabSaludable_Valor;
        }
        this.vidaActual = vidaMax;
        this.ataque = Constantes.ZO_AttBase;
        //Validacion Habilidad Bruto
        if(habilidad == HabilidadZO.Bruto) {
            ataque += Constantes.ZO_HabBruto_Valor;
        }
        this.defensa = Constantes.ZO_DefBase;
        //Validacion Habilidad Tanque
        if(habilidad == HabilidadZO.Tanque) {
            defensa += defensa * Constantes.ZO_HabTanque_Valor;
        }
        this.rangoMovimiento = Constantes.ZO_MovBase;
        this.rangoAtaque = Constantes.ZO_AlcBase;
        this.rangoVision = Constantes.ZO_VisBase;
    }
    
    @Override
    public double recibirDano(double dano) {
        double total = dano - defensa;
        this.vidaActual -= total;
        //Si el zombi muere termina la accion
        if(vidaActual <= 0) {
            vidaActual = 0;
            return 0;
        }
        //Validacion Habilidad Espinas
        if (habilidad == HabilidadZO.Espinas) {
            return total * Constantes.ZO_HabEspinas_Valor;
        } else {
            return 0;
        }
    }

    public void atacar(Entidad ent) {
        double danoRegresado = ent.recibirDano(ataque);
        //Validacion Habilidad Vampirismo
        if (habilidad == HabilidadZO.Vampirismo) {
            vidaActual += ataque * Constantes.ZO_HabVampirismo_Valor;
        }
        //Procesa el daño regresado
        vidaActual -= danoRegresado;
        //La vida no puede ser menor a 0
        if(vidaActual <= 0) {
            vidaActual = 0;
        }
    }
}
