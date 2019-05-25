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

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeSet;
import java.util.Set;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.HashSet;

/**
 * Clase DobleMaster.
 *
 * Cualquier doble máster tiene un identificador, un nombre, un conjunto
 * de asignaturas, una relación con los dos máster que engloba, y una
 * serie de <i>mappings</i> entre sus asignaturas y las asignaturas de
 * los dos máster simples. Los atributos <i>identificador</i>,
 * <i>nombre</i> y <i>conjunto de asignaturas</i> son heredados de la
 * clase <i>Master</i>.
 * 
 * Esta clase incluye métodos para realizar las siguientes
 * comprobaciones:
 * 
 *
 * <li><b>Cobertura de cada máster</b>: para toda asignatura de cada máster, 
 * bien pertence el conjunto de asignaturas del doble máster, bien
 * tiene una equivalencia con alguna asignatura del doble máster.
 *
 * <li><b>Precisión del doble máster</b>: para toda asignatura del doble
 * máster, bien pertenece al máster 1 bien pertenece al máster 2.
 *
 * @author Mariano Fernández López
 * @author Javier Linares Castrillón
 * @author Cristina Abdul Massih

 */

public class DobleMaster extends Master
{
    private Master[] arrayMaster = new Master[2];
    private Map<Asignatura, Asignatura> mapping = new HashMap<>();

    /**
     * Construye un doble máster a partir de un identificador, un
     * nombre y dos máster.
     *@param identificador atributo heredado de la clase <i>Master</i>.
     *@param nombre atributo heredado de la clase <i>Master</i>.
     *@param arrayMaster los máster que engloba el doble máster.
     */
    public DobleMaster(int identificador, String nombre, Master[] arrayMaster) {
        super(identificador, nombre);
        this.arrayMaster = arrayMaster;
    }

    /**
     * Hace corresponder una asignatura del máster 1 con otra asignatura
     * del máster 2, si las asignaturas tienen distinto numero de ects o 
     * distinto semestre, no son convalidables.
     *
     *@param as1 asignatura del máster 1.
     *@param as2 asignatura del máster 2.
     *
     * @return si la asignatura ha sido convalidada o no.
     */
    public boolean  annadirConvalidacion(Asignatura as1, Asignatura as2){
    	
	    boolean convalidable = false;
	    
	if(as1.getEcts() == as2.getEcts() || as1.getSemestre() == as2.getSemestre()){
		convalidable = true;
		mapping.put(as1, as2);
	}
	return convalidable;
    }

    /**
     * <b>Cobertura de cada máster</b>: para toda asignatura de cada máster,
     * bien pertence el conjunto de asignaturas del doble máster, bien
     * tiene una equivalencia con alguna asignatura del doble máster. 
     *
     * @return si el doble máster cubre todos los créditos o no.
     */
    public boolean coberturaCadaMaster()
    {
	    boolean cubiertos = true;
	   
	   for(int i = 0; i<= 1; i++)
	cubiertos = cubiertos && arrayMaster[i].getCjtoAsignaturas().stream().filter(a -> !todas().contains(a))
              .collect(Collectors.toSet()).isEmpty();
	   
	   return cubiertos;
    }
    
    /**
     * <li><b>Precisión del doble máster</b>: para toda asignatura del doble
     * máster, bien pertenece al máster 1 bien pertenece al máster 2.</li>
     *
     * @return si el doble máster es preciso o no.
     */
    public boolean precisionDobleMaster()
    {
	Set<Asignatura> asignaturas = new HashSet<>();

	for(int i = 0; i <= 1;  i++) asignaturas.addAll(arrayMaster[i].getCjtoAsignaturas());
		
	return this.getCjtoAsignaturas().stream().filter(a -> !asignaturas.contains(a))
		.collect(Collectors.toSet()).isEmpty();
	
    }

    /**
     * Conjunto donde almacena todas las asignaturas del doble master y las convalidadas.
     *
     * @return conjunto con todas las asignaturas.
     */
      public Set<Asignatura> todas(){

         Set<Asignatura> asigs = getCjtoAsignaturas().stream().map(a -> mapping.get(a)).filter(a -> a !=null).collect(Collectors.toSet());
   asigs.addAll(getCjtoAsignaturas());
        return asigs;
        }

}

