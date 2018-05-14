package Buscaminas;
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Contenido extends ConsoleProgram{
	private static final long serialVersionUID = 1L;
	
	private static final RandomGenerator rg = new RandomGenerator();
	private boolean In(int[][] arr, int key1, int key2) {
		if (arr[key1][key2] == 9) {
			return true;
		}
		return false;
	}
	public int Numero(int[][] arr, int index1, int index2) {
		int num = 0;
		for (int p = -1; p < 2; p++) {
			for (int q = -1; q < 2; q++) {
				if((index1+p >= 0) && (index2+q >= 0) && (index1+p < 10) && (index2+q < 18)) {
					if (arr[index1+p][index2+q] == 9) {
						num ++;
				}
			}
		}
	}
		return num;
}
	public int[][] Armar() {
		int[][] arreglo = new int[10][18];
		int ran1;
		int ran2;
		for (int i = 0; i < 36; i++) {
			ran1 = rg.nextInt(0, 17);
			ran2 = rg.nextInt(0, 9);
			while (true) {
				if (!In(arreglo, ran2, ran1)) {
					arreglo[ran2][ran1] = 9;
					break;
				}
				else {
					ran1 = rg.nextInt(0, 17);
					ran2 = rg.nextInt(0, 9);
				}
			}
		}
		for (int a = 0; a < arreglo.length; a ++) {
			for (int b = 0; b < arreglo[a].length; b++) {
				if (arreglo[a][b] != 9) {
					arreglo[a][b] = Numero(arreglo, a, b);
				}
			}
		}
		return arreglo;
	}
	public void run() {
		int[][] p = Armar();
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				print(p[i][j]+" ");
			}
			println();
		}
	}
}