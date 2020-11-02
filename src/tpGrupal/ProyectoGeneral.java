package tpGrupal;

import java.util.ArrayList;
import java.util.List;

public class ProyectoGeneral implements IProyecto {
	
	private List<IProyecto> proyectos = new ArrayList<IProyecto>() ;
	
	public ProyectoGeneral(ArrayList<IProyecto> proyectos ) {
		this.proyectos = proyectos ; 
	}
	
	public List<IProyecto> getProyectos() {
		return proyectos ; 
	}

	@Override
	public void finalizarProyecto() {
		for ( IProyecto p : proyectos ) {
			p.finalizarProyecto();
		}
	}

	@Override
	public Boolean esFinalizado() {
		Boolean ret = true ;
		for ( IProyecto p : proyectos ) {
			ret = ret && p.esFinalizado() ;
		}
		return ret ;
	}

}
