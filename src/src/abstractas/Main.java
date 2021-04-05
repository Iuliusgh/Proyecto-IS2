package abstractas;

public class Main {
	public static void main(String[] args) {
		//Puedo hacer las siguientes cosas
		Figura f1 = new Rectangulo(3.0,4.0,1.7724,1.7724);
		Figura f2 = new Circulo(2.0,3.0, 1.0);
		
		//Si quito la declaraci�n abstract de Figura del m�todo area()
		//las 2 siguientes l�neas no compilan por no haber m�todo en Figura
		
		System.out.println(f1.area());
		System.out.println(f2.area());
		
		System.out.println("-------------------");
		
		Figura[] figs = {new Rectangulo(3, 4, 3, 2), new Circulo(2, 3, 1)};
		double suma = sumaAreas(figs);
		System.out.println("Suma de las Areas de los objetos del array = "
				+ suma);
		
	} // main

	private static double sumaAreas(Figura[] f) {
		double suma = 0.0;
		for (int i = 0; i < f.length; i++) {
			suma += f[i].area();
			System.out.println("Area de la figura " + (i + 1) + ":  " + f[i].area()
					+ " que es de la clase: " + f[i].getClass());
		}
		return suma;
	} // sumaAreas
} // Main
