package testbla;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tpGrupal.EncuestaFinalizada;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class testEncuestaFinalizada {

	@Test
	void testGetterDeProyectoDeEncuestaFianlizada() {
		List<PreguntaRespuesta> pr = new ArrayList<PreguntaRespuesta>();
		Proyecto p = mock(Proyecto.class);
		EncuestaFinalizada e = new EncuestaFinalizada(pr, p);
		assertEquals(e.getProyecto(), p);
	} 
	
	@Test
	void testGetterDePreguntasRespondidas() {
		List<PreguntaRespuesta> pr = new ArrayList<PreguntaRespuesta>();
		Proyecto p = mock(Proyecto.class);
		EncuestaFinalizada e = new EncuestaFinalizada(pr, p);
		assertEquals(e.getPreguntasRespondidas(), pr);
	}
	
}
