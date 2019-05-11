package org.pr2.dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeSet;
import java.util.Set;

/**
 * @author Mariano Fernández López
 * @author Javier Linares Castrillón
 *
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
 * <ol>
 * <li><b>Cobertura de cada máster</b>: para toda asignatura de cada máster, 
 * bien pertence el conjunto de asignaturas del doble máster, bien
 * tiene una equivalencia con alguna asignatura del doble máster.</li>
 * <li><b>Precisión del doble máster</b>: para toda asignatura del doble
 * máster, bien pertenece al máster 1 bien pertenece al máster 2.</li>
 * <li><b>Secuenciación correcta</b>: no se da el caso de que una
 * asignatura aparezca en distinto semestre en un máster simple y en el
 * máster doble.</li>
 * </ol>
 */
public class DobleMaster extends Master{
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
     * del máster 2.
     *@param asignatura1 asignatura del máster 1.
     *@param asignatura2 asignatura del máster 2.
     */
    public void annadirConvalidacion(Asignatura asignatura1, Asignatura asignatura2){
        mapping.put(asignatura1, asignatura2); 
    }

    /**
     * <b>Cobertura de cada máster</b>: para toda asignatura de cada máster,
     * bien pertence el conjunto de asignaturas del doble máster, bien
     * tiene una equivalencia con alguna asignatura del doble máster. 
     */
    public boolean coberturaCadaMaster(){
       
       Set<Asignatura> todas = new TreeSet<>();
       for(int i = 0; i <= 1; i++) todas.addAll(arrayMaster[i].getCjtoAsignaturas());
        
       return todas.stream().
           filter(a -> !this.getCjtoAsignaturas().contains(a)).
                   collect(Collectors.toSet()).isEmpty();
    }

    /**
     * <li><b>Precisión del doble máster</b>: para toda asignatura del doble
     * máster, bien pertenece al máster 1 bien pertenece al máster 2.</li>
     */

    public boolean precisionDobleMaster(){
	boolean preciso = true;

        for(Asignatura a : this.getCjtoAsignaturas()){
	
       if(!(arrayMaster[0].getCjtoAsignaturas().contains(a)) || !arrayMaster[1].getCjtoAsignaturas().contains(a)) {
                        preciso = false;
                        break;
                }
	}return preciso ;
    }

 /**
  * <li><b>Secuenciación correcta</b>: no se da el caso de que una
  * asignatura aparezca en distinto semestre en un máster simple y en el
  * máster doble.</li>
  */
   public boolean secuenciacionCorrecta()
   {
	   boolean secuencia = true;

	   Set<Asignatura> todasPrimerSemestre = new TreeSet<>();
	   Set<Asignatura> todasSegundoSemestre = new TreeSet<>();

	   for(int i = 0; i <= 1; i++) todasPrimerSemestre.addAll(arrayMaster[i].getCjtoAsignaturasSemestre(1));
	   for(int i = 0; i <= 1; i++) todasSegundoSemestre.addAll(arrayMaster[i].getCjtoAsignaturasSemestre(2));
	
	return secuencia = this.getCjtoAsignaturasSemestre(1).contains(todasPrimerSemestre) && this.getCjtoAsignaturasSemestre(2).contains(todasSegundoSemestre);
   }
 
   public boolean valido()
   {
	   return coberturaCadaMaster() && precisionDobleMaster();
   }
}
