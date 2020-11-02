package tpGrupal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Proyecto implements IProyecto{
	
	private String descripcion, proposito ;
	private List<Encuesta> encuestas; 
	private List<EncuestaFinalizada> encuestasFinalizadas;
	private List<Investigador> investigadoresInteresados = new ArrayList<Investigador>();
	
	
	public Proyecto (String descripcion, String proposito, ArrayList <Encuesta> encuestasP) {

		encuestasFinalizadas = new ArrayList<EncuestaFinalizada>() ;
		this.setDescripcion(descripcion);
		this.proposito = proposito;
		this.encuestas = encuestasP; 
		this.setProyectoParaEncuestas(encuestas); 
	}
	
	public void addInvestigadorInteresado(Investigador i) {
		this.investigadoresInteresados.add(i);
	}
	
	public List<Investigador> getInvestigadoresInteresados() {
		return investigadoresInteresados;
	}
	
	private void setProyectoParaEncuestas(List <Encuesta> encuestas) {
		for ( Encuesta e : encuestas) {
			e.setProyectoDePertenencia(this);
		}
	}

	public List<Encuesta> getEncuestas() {
		return encuestas ;
	} 
	
	public List<Encuesta> getEncuestasActivas() {
		ArrayList<Encuesta> lsRet = new ArrayList<Encuesta>();
		for(Encuesta e : this.encuestas) {
			if(e.puedeResponder()) {
				lsRet.add(e);
			}
		}
		return lsRet ;
	} 

	public List<EncuestaFinalizada> getEncuestasFinalizadas() {
		return encuestasFinalizadas;
	}

	public void agregarEncuestaFinalizada(EncuestaFinalizada eF) {
		encuestasFinalizadas.add(eF) ;
	} 

	public void desactivarEncuesta(Encuesta encuesta) { 
		encuesta.setEstado();
	}

	public void finalizarProyecto() {
		for ( Encuesta e : encuestas ) {
			this.desactivarEncuesta(e);
		}
	}
	
	public Boolean esFinalizado() {
		Boolean esFinalizado = true ;
		for ( Encuesta e : encuestas ) {
			esFinalizado = esFinalizado && (e.getEstado() instanceof Desactivada) ;
		}
		return esFinalizado ;
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Encuesta> getUltimasEncuestas(int fecha) {
		List<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		for ( Encuesta e : this.getEncuestas()) {
			if ( e.getAñoCreacion() == fecha ) {
				lsEncuestas.add(e) ;
			}
		}
		return lsEncuestas ;
	}
	
	public Integer compare(Proyecto p) {
		return new Integer(this.getDescripcion().compareTo(p.getDescripcion())) ;
	}

}
