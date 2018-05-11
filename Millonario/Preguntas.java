package Millonario;
import Excepciones.LetterException;

public class Preguntas {
	private String pregunta;
	private String a;
	private String b;
	private String c;
	private String d;
	private String correcta;
	public Preguntas(){
		pregunta = "";
		a = "";
		b = "";
		c = "";
		d = "";
		correcta = "A";
	}
	public Preguntas(String pregunta , String a , String b , String c , String d , String correcta){
		this.pregunta = pregunta;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.correcta = correcta;
	}
	public void setPregunta(String pr) {
		pregunta = pr;
	}
	public void setA(String a) {
		this.a = a;
	}
	public void setB(String b) {
		this.b = b;
	}
	public void setC(String c) {
		this.c = c;
	}
	public void setD(String d) {
		this.d = d;
	}
	public void setCorrecta(String crr) {
		if ((crr.equals("A")) || (crr.equals("B")) || (crr.equals("C")) || (crr.equals("D"))) {
			correcta = crr;
		}
		else {
			throw new LetterException();
		}
	}
	public String getPregunta() {
		return pregunta;
	}
	public String getRespuestaA() {
		return a;
	}
	public String getRespuestaB() {
		return b;
	}
	public String getRespuestaC() {
		return c;
	}
	public String getRespuestaD() {
		return d;
	}
	public String getCorrecta() {
		return correcta;
	}
	static Preguntas primera = new Preguntas("Son las membranas movibles cubiertas de piel que resguardan los ojos:", "Cejas" , "Pupilas", "Parpados", "Anteojos", "C");
	static Preguntas segunda = new Preguntas("Según el refran, quien es ciego?", "La Esperanza", "El Amor", "El Odio", "La Envidia", "B");
	static Preguntas tercera = new Preguntas("Con que material esculpió Miguel Angel \"La Piedad\" ubicada en el Vaticano?", "Bronce", "Marmol", "Madera", "Yeso", "B");
	static Preguntas cuarta = new Preguntas("Cual de los siguientes países limita con Francia?", "Holanda", "Suecia", "Dinamarca", "Belgica", "D");
	static Preguntas quinta = new Preguntas("La hormiga es un:", "Mamifero", "Ave", "Insecto", "Reptil", "C");
	static Preguntas sexta = new Preguntas("Qué unidad cientifica lleva el nombre de un noble italiano?", "Voltio", "Ohm", "Hertz", "Pascal", "A");
	static Preguntas septima = new Preguntas("Que elemento químico es representado por el simbolo \"P\"", "Bromo", "Boro", "Rubidio", "Fosforo", "D");
	static Preguntas octava = new Preguntas("De donde se extrae el alcohol metílico?", "Madera", "Animales", "Huesos", "Aluminio", "A");
}