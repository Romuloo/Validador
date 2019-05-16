package org.pr2.dominio;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

/**
 * @author Mariano Fernández López
 *
 * AVISO: si el estudiante detecta código no válido, deberá
 * modificarlo para que lo sea.
 *
 * Esta clase se utiliza para probar el funcionamiento del validador de
 * doble máster. 
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
        dobleMasterCorrectoSinMappings = new DobleMaster(1, 
            "Doble Máster Correcto Sin Mappings", arrayMaster);
        for (int i = 1; i <= 10; i++){
            Asignatura asignatura11 = new Asignatura(i, 
                        "Asignatura-" + i + "máster-1", 6, i % 2 + 1);
            Asignatura asignatura12 = new Asignatura(i, 
                        "Asignatura-" + 10 + i + "máster-2", 6, i % 2 + 1);
            arrayMaster[0].annadirAsignatura(asignatura11);
            arrayMaster[1].annadirAsignatura(asignatura12);
            dobleMasterCorrectoSinMappings.annadirAsignatura(asignatura11);
            dobleMasterCorrectoSinMappings.annadirAsignatura(asignatura12); 

	}	
	System.out.println(dobleMasterCorrectoSinMappings.obtenerMaster());	
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
     * Este test comprueba si las asignaturas de cada máster están en
     * en el doble máster. Se asume que hay <i>mappings</i>.  
     */
    @Test
    public void coberturaCadaMasterEnElDobleMasterConMappings()
    {
        assertTrue( true );
    }

    /**
     * Este test comprueba si las asignaturas del doble máster están en
     * alguno de los dos máster. Se asume que hay <i>mappings</i>.  
     */
    @Test 
    public void precisionDobleMasterConMappings()
    {
        assertTrue( true );
    }

    @Test
    public void dobleMasterValido()
    {
	    assertTrue(dobleMasterCorrectoSinMappings.valido());
    }
}
