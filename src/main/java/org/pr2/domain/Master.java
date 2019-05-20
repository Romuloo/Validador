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

import java.util.stream.Collectors; 
import java.util.Set;
import java.util.TreeSet;


/**
 * Clase Master.
 *
 *  Cualquier máster tiene un identificador, un nombre y un cojunto de
 * asignaturas.
 *
 * @author Mariano Fernández López
 * @author Cristina Abdul Massih
 * @author Javier Linares Castrillón
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

    /**
     * Devuelve el conjunto de Asignaturas.
     */
    public Set<Asignatura> getCjtoAsignaturas() {
        return cjtoAsignaturas;
    }

} 
