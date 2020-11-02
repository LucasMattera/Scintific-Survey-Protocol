package tpGrupal;

import java.util.ArrayList;


public abstract class Criterio {

	public abstract ArrayList<Encuesta> devolverEncuestasPorCriterio(Investigador i);
	
	public ArrayList<Encuesta> getTodasLasEncuestasDeUnInvestigador(Investigador i){
		ArrayList<Encuesta> lsRet = new ArrayList<Encuesta>();
		for(Proyecto p : i.getProyectos()){
			lsRet.addAll(p.getEncuestas());
		}
		return lsRet; 
	}
	
	public ArrayList<Encuesta> addHastaNEncuestas(ArrayList<Encuesta> lsEnc, Integer n){
		ArrayList<Encuesta> lsRet2 = new ArrayList<Encuesta>();
		for(int i = 0; i<n ; i++) {
			lsRet2.add(lsEnc.get(i));
		}
		return lsRet2;
	}
}
