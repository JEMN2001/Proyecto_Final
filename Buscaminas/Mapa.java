package Buscaminas;

import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Mapa extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	public static int Size_W = 35;
	public static int Size_H = 35;
	GObject seleccionado;
	GPoint selected;
	GRect Tablero = new GRect(0, 0, Size_W*10, Size_H);
	Contenido cont = new Contenido();
	int [][] array = cont.Armar();
	public void BuildMap() {
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j < 10; j++) {
				GRect cuad = new GRect(j*Size_W, i*Size_H, Size_W, Size_H);
				GLabel label = new GLabel(array[j][i-1]+"", j*Size_W+10, (i+1)*Size_H-(Size_H/2)+5);
				if (array[j][i-1] == 9) {
					label.setColor(Color.RED);
				}
				else {
					label.setColor(Color.GREEN);
				}
				label.setFont("OCRAExtendet-bold-20");
				add(label);
				cuad.setFillColor(Color.GRAY);
				cuad.setFilled(true);
				cuad.addMouseListener(this);
				add(cuad);
			}
		}
	}
	public void init() {
		setSize(Size_W*10+2, Size_H*19+2);
		setBackground(Color.LIGHT_GRAY);
		Tablero.setFillColor(Color.LIGHT_GRAY);
		Tablero.setFilled(true);
		BuildMap();
		add(Tablero);
	}
	public void mouseClicked (MouseEvent e) {
		selected = new GPoint(e.getPoint());
		seleccionado = getElementAt(selected);
		if (e.getButton() == 1) {
			if ((seleccionado != null) && (seleccionado != Tablero) && !(seleccionado.getClass().equals(GLabel.class))) {
				if(((GRect) seleccionado).getFillColor().equals(Color.GRAY)) {
					remove(seleccionado);
				}
			}
			if (array[(int) (seleccionado.getX()/Size_W)][(int) ((seleccionado.getY()/Size_H)-1)] == 9) {
				for (int i = 1; i <= 18; i++) {
					for (int j = 0; j < 10; j++) {
						
					}
				}
			}
		}
		else if (e.getButton() == 3) {
			if ((seleccionado != null) && (seleccionado != Tablero) && !(seleccionado.getClass().equals(GLabel.class))) {
				if (((GRect) seleccionado).getFillColor().equals(Color.GRAY)) {
					double X = seleccionado.getLocation().getX();
					double Y = seleccionado.getLocation().getY();
					GRect indicador = new GRect(X, Y, Size_W, Size_H);
					indicador.setFilled(true);
					add(indicador);
				}
				else if (((GRect) seleccionado).getFillColor().equals(Color.BLACK)) {
					remove(seleccionado);
				}
			}
		}
	}
}