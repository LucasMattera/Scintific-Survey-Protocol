package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenadasPorProyectos  extends Criterio{

	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i){
		
		Collections.sort(i.getProyectos(),(o1, o2) -> o1.getDescripcion().compareTo(o2.getDescripcion()));
		
		ArrayList<Encuesta> lsRet = this.getTodasLasEncuestasDeUnInvestigador(i);
		
		return lsRet; 
	}
	
}
