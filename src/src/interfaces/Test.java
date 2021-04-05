package interfaces;

public class Test {
	
	public static void main(String[] args) {

		Perro p = new Perro();
		Gato g = new Gato();
		Vaca v = new Vaca();
		Animal granja1[] = new Animal[3];
        granja1[0] = p; 
		granja1[1] = g; 
		granja1[2] = v;
		Bestia granja2[] = new Bestia[3];
		granja2[0] = p; 
		granja2[1] = g; 
		granja2[2] = v;
		for (int i = 0; i < 3; i++) {
			System.out.print("Granja 1 -> ");
			granja1[i].habla(); // Se ejecuta el método del tipo dinámico 
			((Bestia) granja1[i]).grita();
			System.out.print("Granja 2 -> ");
			// granja2[i].habla(); // Error. Método habla() no definido en Bestia
			((Animal) granja2[i]).habla();
			System.out.print("Granja 2 -> ");
			granja2[i].grita(); // Se ejecuta el método del tipo dinámico    
		}
		Animal burro = new Burro();
		((Bestia) burro).grita();

    } // main
	
} // Test
