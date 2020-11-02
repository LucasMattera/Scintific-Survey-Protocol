package tpGrupal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class VeinteCreadasUltimamente  extends Criterio {


	@Override
	public ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i) {
		ArrayList<Encuesta> lsRet = this.getTodasLasEncuestasDeUnInvestigador( i);
		
		Collections.sort(lsRet, (e1, e2) -> e2.getAñoCreacion().compareTo(e1.getAñoCreacion()));
		
		ArrayList<Encuesta> lsRet2 = this.addHastaNEncuestas(lsRet, 20);
		
		return lsRet2;
	}
}
