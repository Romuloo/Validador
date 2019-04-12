package org.pr2.dominio;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Mariano Fernández López
 * 
 * AVISO: si el estudiante detecta código no válido, deberá
 * modificarlo para que lo sea.
 *
 * Cualquier máster tiene un identificador, un nombre y un cojunto de
 * asignaturas.
 *
 */
public class Master{
    private int identificador;
    private String nombre;
    private Set<Asignatura> cjtoAsignaturas = new TreeSet<>();

    /**
     * Obtiene el identificador del máster.
     * @return el identificador.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Obtiene el nombre del máster.
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }
   
    /**
     * Añade una asignatura al máster.
     * @param asignatura asignatura que se añade.
     */
    public void annadirAsignatura(Asignatura asignatura){
        cjtoAsignaturas.add(asignatura);
    }

    /**
     * Construye un máster a partir de su identificador y su nombre.
     * @param identificador identificador del máster.
     * @param nombre nombre del máster.
     */
    public Master(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public Set<Asignatura> getCjtoAsignaturas() {
        return cjtoAsignaturas;
    }
} 
