package tpGrupal;

public class DatosDePregunta {
	
		private Pregunta pregunta;
		private Respuesta respuesta;
		private Encuesta encuesta;
		
		public DatosDePregunta(Pregunta preguntaP, Respuesta respuestaP, Encuesta encuestaP) {
			setPregunta(preguntaP);
			setRespuesta(respuestaP);
			setEncuesta(encuestaP);
		}

		public Pregunta getPregunta() {
			return pregunta;
		}

		public void setPregunta(Pregunta pregunta) {
			this.pregunta = pregunta;
		}

		public Respuesta getRespuesta() {
			return respuesta;
		}

		public void setRespuesta(Respuesta respuesta) {
			this.respuesta = respuesta;
		}

		public Encuesta getEncuesta() {
			return encuesta;
		}

		public void setEncuesta(Encuesta encuesta) {
			this.encuesta = encuesta;
		}
}
