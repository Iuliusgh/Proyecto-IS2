package empresa.entidades;

import java.util.GregorianCalendar;

public class ELabor extends Empleado {
	
	// Los empleados que cobran por labor realizada tinen un salario de 130.00 por cada cliente captado
	private int clientesCaptados;
    public static final double salarioL = 130.00;

    public ELabor() {
        super();
        clientesCaptados = 0;
    }

	public ELabor(String dni, String nombre, String apellidos, GregorianCalendar fechaIngreso, int clientesCaptados) {
        super(dni, nombre, apellidos, fechaIngreso);
        this.clientesCaptados = clientesCaptados;
    }
	
	public int getClientesCaptados() {
        return clientesCaptados;
    }
	
	public void setClientesCaptados(int clientesCaptados) {
        this.clientesCaptados = clientesCaptados;        
    }

    public double getSalario() {
        return salarioL * clientesCaptados;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + getSalario();
    }

} // ELabor
