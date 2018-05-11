package Millonario;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class QQSM extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
	Preguntas[] arr = new Preguntas[8];
	private static final int WIN_WIDTH = 1024;
	private static final int WIN_HEIGHT = 600;
	int Puntos = 0;
	int posicion = 0;
	Preguntas pregunta = nextPregunta();
	GLabel pr;
	GLabel pra;
	GLabel prb;
	GLabel prc;
	GLabel prd;
	GLabel punt;
	JButton A = new JButton("A");
	JButton B = new JButton("B");
	JButton C = new JButton("C");
	JButton D = new JButton("D");
	GRect Ar = new GRect(212, 250, 200, 80);
	GRect Br = new GRect(612, 250, 200, 80);
	GRect Cr = new GRect(212, 380, 200, 80);
	GRect Dr = new GRect(612, 380, 200, 80);
	Color Col = new Color(200, 200, 200);
	Color ColA = new Color(200, 200, 200);
	Color ColB = new Color(200, 200, 200);
	Color ColC = new Color(200, 200, 200);
	Color ColD = new Color(200, 200, 200);
	public Preguntas nextPregunta() {
		RandomGenerator r = new RandomGenerator();
		switch (r.nextInt(1, 8)) {
		case 1:
			return Preguntas.primera;
		case 2:
			return Preguntas.segunda;
		case 3:
			return Preguntas.tercera;
		case 4:
			return Preguntas.cuarta;
		case 5:
			return Preguntas.quinta;
		case 6:
			return Preguntas.sexta;
		case 7:
			return Preguntas.septima;
		case 8:
			return Preguntas.octava;
		default:
			return new Preguntas();
		}
	}
	public void init() {
		setSize(WIN_WIDTH , WIN_HEIGHT);
		setBackground(Col);
		add(new GRect(212, 50, 600, 80));
		add(new GRect(20, 50, 150, 410));
		Ar.setFilled(true);
		Ar.setFillColor(ColA);
		Br.setFilled(true);
		Br.setFillColor(ColB);
		Cr.setFilled(true);
		Cr.setFillColor(ColC);
		Dr.setFilled(true);
		Dr.setFillColor(ColD);
		add(Ar);
		add(Br);
		add(Cr);
		add(Dr);
		add(A, SOUTH);
		add(B, SOUTH);
		add(C, SOUTH);
		add(D, SOUTH);
		punt = new GLabel(Integer.toString(Puntos), 95, 255);
		add(new GLabel("A: ", 217, 290));
		add(new GLabel("B: ", 617, 290));
		add(new GLabel("C: ", 217, 420));
		add(new GLabel("D: ", 617, 420));
		pra = new GLabel("" ,232 , 290);
		prc = new GLabel("" ,232 , 420);
		prd = new GLabel("" ,632 , 420);
		prb = new GLabel("" ,632 , 290);
		pr = new GLabel("" ,222 , 90);
		pra.sendToFront();
		prb.sendToFront();
		prc.sendToFront();
		prd.sendToFront();
		add(punt);
		add(pr);
		add(pra);
		add(prb);
		add(prc);
		add(prd);
		addActionListeners();
	}
	public void run() {
		while (true) {
			if (posicion == arr.length) {
				pause(1000);
				GRect cuadrado = new GRect(WIN_WIDTH, WIN_HEIGHT);
				cuadrado.setColor(Color.GREEN);
				cuadrado.setFilled(true);
				cuadrado.sendToFront();
				remove(A);
				remove(B);
				remove(C);
				remove(D);
				add(cuadrado);
				add(new GLabel("Tuviste "+Puntos+" respuestas correctas", (WIN_WIDTH/2)-60, (WIN_HEIGHT/2)));
				break;
			}
			if (!(verificar(pregunta))) {
				pause(1000);
				Ar.setFillColor(Col);
				Br.setFillColor(Col);
				Cr.setFillColor(Col);
				Dr.setFillColor(Col);
				pr.setLabel(pregunta.getPregunta());
				pra.setLabel(pregunta.getRespuestaA());
				prc.setLabel(pregunta.getRespuestaC());
				prd.setLabel(pregunta.getRespuestaD());
				prb.setLabel(pregunta.getRespuestaB());
			}
			else {
				pregunta = nextPregunta();
			}
		}
		GLabel tiempo = new GLabel("El programa se cerrara en 10 segundos", (WIN_WIDTH/2)-80, (WIN_HEIGHT/2)-30);
		add(tiempo);
		for(int i = 10; i >= 1; i--) {
			tiempo.setLabel("El programa se cerrara en "+i+" segundos");
			pause(1000);
		}
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		if (posicion < arr.length) {
			arr[posicion] = pregunta;
			posicion ++;
			if (e.getActionCommand().equals(pregunta.getCorrecta())) {
				Puntos ++;
				if (e.getActionCommand().equals("A")) {
					Ar.setFillColor(Color.GREEN);
				}
				else if (e.getActionCommand().equals("B")) {
					Br.setFillColor(Color.GREEN);
				}
				else if (e.getActionCommand().equals("C")) {
					Cr.setFillColor(Color.GREEN);
				}
				else if (e.getActionCommand().equals("D")) {
					Dr.setFillColor(Color.GREEN);
				}
				punt.setLabel(Integer.toString(Puntos));
				pregunta = nextPregunta();
			}
			else {
				switch (pregunta.getCorrecta()) {
				case "A":
					Ar.setFillColor(Color.GREEN);
					break;
				case "B":
					Br.setFillColor(Color.GREEN);
					break;
				case "C":
					Cr.setFillColor(Color.GREEN);
					break;
				case "D":
					Dr.setFillColor(Color.GREEN);
					break;
				}
				switch (e.getActionCommand()) {
				case "A":
					Ar.setFillColor(Color.RED);
					break;
				case "B":
					Br.setFillColor(Color.RED);
					break;
				case "C":
					Cr.setFillColor(Color.RED);
					break;
				case "D":
					Dr.setFillColor(Color.RED);
					break;
				}
				pregunta = nextPregunta();
			}
		}
	}
	public boolean verificar(Preguntas p) {
		for (int i = 0; i < arr.length ; i++) {
			if (p.equals(arr[i])) {
				return true;
			}
		}
		return false;
	}
}