/**
 *Copyright [2019] [Cristina Abdul Massih, Javier Linares]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.pr2.domain;
import java.util.*;
/**
 * Clase Asignatura.
 *
 * Cualquier asignatura tiene un identificador, un nombre, el número de
 *semestre en que se imparte y el número de créditos ECTS.
 *
 * @author Mariano Fernández López
 * @author Javier Linares Castrillón
 * @author Cristina Abdul Massih
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

    public String toString()
    {
	    return "Nombre: " + nombre + " , Identificador: " + identificador + ", ects: " + ects + ", semestre: " + semestre;
    }
}    
