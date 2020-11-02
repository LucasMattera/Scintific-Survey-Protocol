package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;


public class VeinticincoMasUsadas extends Criterio {

	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i) {
		ArrayList<Encuesta> todasLasEncuestas = this.getTodasLasEncuestasDeUnInvestigador( i) ;	
		
		Collections.sort(todasLasEncuestas,(e1, e2) -> e2.getCantidadDeUsos().compareTo(e1.getCantidadDeUsos()));
			
		ArrayList<Encuesta> lsRet = this.addHastaNEncuestas(todasLasEncuestas, 25);
			
		return lsRet; 
	}

}
