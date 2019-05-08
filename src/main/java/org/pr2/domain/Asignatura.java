package org.pr2.dominio;

/**
 * @author Mariano Fernández López
 *
 * AVISO: si el estudiante detecta código no válido, deberá
 * modificarlo para que lo sea.
 *
 * Cualquier asignatura tiene un identificador, un nombre, el número de
 * semestre en que se imparte y el número de créditos ECTS.
 */
public class Asignatura implements Comparable<Asignatura>{
    private int identificador;
    private String nombre;
    private int ects;
    private int semestre;

    /**
     * Las asignaturas se ordenan de menor a mayor identificador.
     * @param asignatura asignatura con la que se realiza la
     * comparación.
     * @return Un número menor que cero si la asignatura que recibe el
     * mensaje es menor que la que va por parámetro. Un número mayor que
     * cero si la asignatura que recibe el mensaje es mayor que la que
     * va por parámetro. Cero si ambas son iguales.
     */
    public int compareTo(Asignatura asignatura){
        return this.identificador - asignatura.identificador;
    }

    public int hashCode()
    {
	return identificador;
    }
    /**
     * Obtiene el identificador de la asignatura.
     *
     * @return el identificador.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Obtiene el nombre de la asignatura.
     *
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los créditos ECTS de la asignatura.
     *
     * @return los ECTS.
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Obtiene el semestre de la asignatura.
     *
     * @return el semestre.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Construye una asignatura a partir de su identificador, su nombre,
     * sus créditos ECTS y su semestre (1 ó 2).
     *
     *
     */
    public Asignatura(int identificador, String nombre, int ects, int semestre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.ects = ects;
        this.semestre = semestre;
    }
}    
