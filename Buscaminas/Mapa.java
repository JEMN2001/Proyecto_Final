<<<<<<< HEAD
package Buscaminas;

import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Mapa extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	public static int Size_W = 50;
	public static int Size_H = 50;
	GObject seleccionado;
	GPoint selected;
	GRect Tablero = new GRect(0, 0, Size_W*10, Size_H);
	Contenido cont = new Contenido();
	int [][] array = cont.Armar();
	public void BuildMap() {
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j < 10; j++) {
				GRect cuad = new GRect(j*Size_W, i*Size_H, Size_W, Size_H);
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
		add(Tablero);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				int num = array[i][j];
				GLabel number = new GLabel(num+"", (Size_W*j)+(Size_W/2)-10, (Size_H*i)+Size_H*1.7);
				number.setFont("OCRAExtendet-bold-20");
				if (num != 9) {
					number.setColor(Color.GREEN);
				}
				else {
					number.setColor(Color.RED);
					number.addMouseListener(this);
				}
				add(number);
			}
		}
		BuildMap();
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
=======
package Buscaminas;

import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Mapa extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	public static int Size_W = 50;
	public static int Size_H = 50;
	GObject seleccionado;
	GPoint selected;
	GRect Tablero = new GRect(0, 0, Size_W*10, Size_H);
	Contenido cont = new Contenido();
	int [][] array = cont.Armar();
	public void BuildMap() {
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j < 10; j++) {
				GRect cuad = new GRect(j*Size_W, i*Size_H, Size_W, Size_H);
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
		add(Tablero);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				int num = array[i][j];
				GLabel number = new GLabel(num+"", (Size_W*j)+(Size_W/2)-10, (Size_H*i)+Size_H*1.7);
				number.setFont("OCRAExtendet-bold-20");
				if (num != 9) {
					number.setColor(Color.GREEN);
				}
				else {
					number.setColor(Color.RED);
				}
				add(number);
			}
		}
		BuildMap();
	}
	public void run() {
	}
	public void mouseClicked (MouseEvent e) {
		selected = new GPoint(e.getPoint());
		seleccionado = getElementAt(selected);
		if (e.getButton() == 1) {
			if ((seleccionado != null) && (seleccionado != Tablero) && ((GRect) seleccionado).getFillColor().equals(Color.GRAY)) {
				remove(seleccionado);
			}
		}
		else if (e.getButton() == 3) {
			if ((seleccionado != null) && (seleccionado != Tablero)) {
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
>>>>>>> b8fbfb4193d194495cc3e5bc6a2dfb29561802b6
}