/**
 *Copyright [2020] [Javier Linares Castrillón]
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
package org.pr2.dominio;

import org.pr2.domain.*;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;

/**
 * Clase DobleMasterTest.
 *
 * Esta clase se utiliza para probar el funcionamiento del validador de
 * doble máster. 
 *
 * @author Javier Linares Castrillón
 * @author Mariano Fernández López
 *
 *  
 */
public class DobleMasterTest 
{
    private DobleMaster dobleMasterCorrectoSinMappings; 
    private DobleMaster dobleMasterCorrectoConMappings;
    private DobleMaster dobleMasterFaltaDeCoberturaSinMappings;
    private DobleMaster dobleMasterFaltaDeCoberturaConMappings;
    private DobleMaster dobleMasterFaltaDeExactitudSinMappings;
    private DobleMaster dobleMasterFaltaDeExactitudConMappings;
    
    @Before
    public void setUp(){
        
	Master[] arrayMaster = new Master[2];
        arrayMaster[0] = new Master(1, "Master 1");
        arrayMaster[1] = new Master(2, "Master 2");
        

	Asignatura a1 = new Asignatura(1, "INI", 6, 1);
	Asignatura a2 = new Asignatura(2, "PR1", 6, 1);
	Asignatura a3 = new Asignatura(3, "Matemáticas 1", 6, 1);
	Asignatura a4 = new Asignatura(4, "FOT", 6, 1);

	Asignatura a5 = new Asignatura(5, "Informática", 6, 1);
	Asignatura a6 = new Asignatura(6, "Matemáticas de la empresa", 6, 1);
	Asignatura a7 = new Asignatura(7, "FGE", 6, 1);

	Asignatura a8 = new Asignatura(8, "Historia", 6, 1);

	arrayMaster[0].annadirAsignatura(a1);
	arrayMaster[0].annadirAsignatura(a2);
	arrayMaster[0].annadirAsignatura(a3);
	arrayMaster[0].annadirAsignatura(a4);

	arrayMaster[1].annadirAsignatura(a5);
	arrayMaster[1].annadirAsignatura(a6);
	arrayMaster[1].annadirAsignatura(a7);

	//---------------------------------------------------
	dobleMasterCorrectoSinMappings = new DobleMaster(1, 
            "Doble Máster Correcto Sin Mappings", arrayMaster);
	for(int i = 0; i <= 1; i++)
		for(Asignatura a : arrayMaster[i].getCjtoAsignaturas()) 
			dobleMasterCorrectoSinMappings.annadirAsignatura(a);
        
	 //---------------------------------------------------
	dobleMasterFaltaDeCoberturaSinMappings = new DobleMaster(2, "Doble Máster Falta De Cobertura Sin Mappings", arrayMaster);
	for(Asignatura a : arrayMaster[0].getCjtoAsignaturas())
			dobleMasterFaltaDeCoberturaSinMappings.annadirAsignatura(a);

	//---------------------------------------------------
	dobleMasterFaltaDeExactitudSinMappings = new DobleMaster(3, "Doble Máster Falta De Precision Sin Mappings",arrayMaster);
	dobleMasterFaltaDeExactitudSinMappings.annadirAsignatura(a8);
	//---------------------------------------------------
	dobleMasterCorrectoConMappings = new DobleMaster(4, "Doble Máster Correcto Con Mappings", arrayMaster);

	for(Asignatura a : arrayMaster[0].getCjtoAsignaturas())dobleMasterCorrectoConMappings.annadirAsignatura(a);

	dobleMasterCorrectoConMappings.annadirConvalidacion(a1, a5);
	dobleMasterCorrectoConMappings.annadirConvalidacion(a2, a6);
       	dobleMasterCorrectoConMappings.annadirConvalidacion(a3, a7);
	//---------------------------------------------------
	dobleMasterFaltaDeCoberturaConMappings = new DobleMaster(5, "Doble Máster Falta de Cobertura Con Mappings", arrayMaster);

	dobleMasterFaltaDeCoberturaConMappings.annadirAsignatura(a1);
	dobleMasterFaltaDeCoberturaConMappings.annadirConvalidacion(a1, a5);
	//---------------------------------------------------
	dobleMasterFaltaDeExactitudConMappings = new DobleMaster(6, "Doble Máster Falta de Precision Sin Mappings",
arrayMaster);

	dobleMasterFaltaDeExactitudConMappings.annadirAsignatura(a4);
	dobleMasterFaltaDeExactitudConMappings.annadirConvalidacion(a4, a8);
	
		
    }
    
    /**
     * Este test comprueba si las asignaturas de cada máster están en
     * en el doble máster. Se asume que no hay <i>mappings</i>.  
     */
    @Test 
    public void coberturaCadaMasterEnElDobleMasterSinMappings()
    {
        assertTrue(dobleMasterCorrectoSinMappings.coberturaCadaMaster());
    }


    /**
     * Este test comprueba si las asignaturas del doble máster están en
     * alguno de los dos máster. Se asume que no hay <i>mappings</i>.  
     */
    @Test
    public void precisionDobleMasterSinMappings()
    {
        assertTrue(dobleMasterCorrectoSinMappings.precisionDobleMaster());
    }
    

    /**
     * Este test comprueba que si el doble máster no engloba todas las asignaturas
     * de los dos máster, la cobertura es falta y el máster no válido.
     * Se asume que no hay <i>mappings</i>.
     */
    @Test
    public void faltaDeCoberturaSinMappings()
    {
	    assertFalse(dobleMasterFaltaDeCoberturaSinMappings.coberturaCadaMaster());
    }


    /**
     * Este test comprueba que si el doble Máster tiene alguna asignatura que no esté en
     * alguno de los dos másters, el doble Máster no es preciso.
     * Se asume que no hay <i>mappings<i>.
     */
    @Test
    public void faltaDePrecisionSinMappings()
    {
	assertFalse(dobleMasterFaltaDeExactitudSinMappings.precisionDobleMaster());
    }
    /**
     * Este test comprueba si las asignaturas de cada máster están en
     * en el doble máster. Se asume que hay <i>mappings</i>.  
     */
    @Test
    public void coberturaCadaMasterEnElDobleMasterConMappings()
    {
        assertTrue(dobleMasterCorrectoConMappings.coberturaCadaMaster());
    }

    /**
     * Este test comprueba si las asignaturas del doble máster están en
     * alguno de los dos máster. Se asume que hay <i>mappings</i>.  
     */
    @Test 
    public void precisionDobleMasterConMappings()
    {
        assertTrue(dobleMasterCorrectoConMappings.precisionDobleMaster());
    }


    /**
     * Este test comprueba que si el doble máster no engloba todas las asignaturas
     * de los dos máster, la cobertura es falta y el máster no válido.
     * Se asume que hay <i>mappings</i>.
     */
     @Test
    public void faltaDeCoberturaConMappings()
    {
        assertFalse(dobleMasterFaltaDeCoberturaConMappings.coberturaCadaMaster());
    }


    /**
     * Este test comprueba que si el doble Máster tiene alguna asignatura que no esté en
     * alguno de los dos másters, el doble Máster no es preciso.
     * Se asume que hay <i>mappings<i>.
     */
     @Test
    public void faltaDePrecisionConMappings()
    {
        assertFalse(dobleMasterFaltaDeExactitudConMappings.precisionDobleMaster());
    }

    
    /**
     * Este test comprueba que no se pueden convalidar asignaturas con distinto númeor de créditos
     * o distinto semestre
     */
      @Test
    public void noTeLaLlevasDeErasmus()
    {	
	assertFalse(dobleMasterCorrectoConMappings.annadirConvalidacion(new Asignatura(10, "IA", 6, 1),new Asignatura(11, "AI", 5, 2)));
    } 

}
