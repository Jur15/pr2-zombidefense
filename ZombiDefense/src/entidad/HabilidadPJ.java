package entidad;

/**
 *
 * @author moral
 */
public enum HabilidadPJ {
    //Generales - Habilidad 1
    Explorador, //Puede moverse mas casillas de lo normal
    Cazador, //Puede atacar desde más lejos
    Medico, //Aumenta el efecto de objetos de curacion
    Veterano, //Aumenta el efecto de objetos de experiencia
    Saludable, //Mayor vida base

    //Ninja
    Sigiloso, //Reduce el ruido hecho al atacar - Hab 2
    Retirada, //Aumenta el rango de movimiento al tener poca salud - Hab 3
    //Nigromante
    Toxico, //Al ser atacado el atacante recibe parte del daño - Hab 2
    Necromancia, //Recupera salud al dañar al enemigo - Hab 3
    //Caballero
    Tanque, //Mayor defensa - Hab 1
    Demoledor, //Reduce la defensa de su objetivo - Hab 2
    Furioso //Aumenta el ataque al tener poca salud - Hab 3
}
