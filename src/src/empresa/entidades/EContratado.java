package empresa.entidades;

import java.util.GregorianCalendar; // Subclase de Calendar
import java.util.Calendar; // Clase abstracta con campos estáticos DAY_OF_MONTH, MONTH, YEAR

public class EContratado extends Empleado {
	
	private double salarioB;

    public EContratado() {
        super();
        salarioB = 0.0;
    }

    public EContratado(String dni, String nombre, String apellidos, GregorianCalendar fechaIngreso, float salarioB) {
        super(dni, nombre, apellidos, fechaIngreso);
        this.salarioB = salarioB;
    }
	
	public double getSalario() {
		// Cálculo porcentaje adicional según años trabajados: 5% (de 0 a 3 años), 10% (de 4 a 7 años), 
		// 15% (de 8 a 15 años) y 20% (más de 15 años)
        GregorianCalendar actual = new GregorianCalendar();
        int anyos = actual.get(Calendar.YEAR) - fechaIngreso.get(Calendar.YEAR);
        if (fechaIngreso.get(Calendar.MONTH) > actual.get(Calendar.MONTH)
            || fechaIngreso.get(Calendar.MONTH) == actual.get(Calendar.MONTH)
            && fechaIngreso.get(Calendar.DAY_OF_MONTH) > actual.get(Calendar.DAY_OF_MONTH)) 
		    anyos--;
        switch(anyos)
        {
            case 0: // break;
            case 1:
            case 2:
            case 3: return 1.05 * salarioB;
            case 4: 
            case 5:
            case 6:
            case 7: return 1.10 * salarioB;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15: return 1.15 * salarioB;
            default: return 1.20 * salarioB;
        }
    }

	public void setSalario(float salarioB) {
        this.salarioB = salarioB;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + getSalario();
    }

} // EContratado
