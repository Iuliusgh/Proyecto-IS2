package empresa.entidades;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Empleado {
	
    private String dni;
    private String nombre;
    private String apellidos;
    protected GregorianCalendar fechaIngreso;

	public Empleado() {
        dni = "00000000";
        nombre = "NN";
        apellidos = "NA";
        fechaIngreso = new GregorianCalendar(1800,0,1);
    }
	
    public Empleado(String dni, String nombre, String apellidos, GregorianCalendar fechaIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
    }
	
	public String getDni() {
        return dni;
    }
	
	public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

	public GregorianCalendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(GregorianCalendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

	@Override
    public String toString() {
        int dia, mes, anyo;
        dia = getFechaIngreso().get(Calendar.DAY_OF_MONTH);
        mes = getFechaIngreso().get(Calendar.MONTH) + 1;
        anyo = getFechaIngreso().get(Calendar.YEAR);
        return "DNI: " + getDni() + "\nNombre y Apellidos: " + getNombre() + 
               " " + getApellidos() + "\nFecha de ingreso: " + 
               (dia <= 9 ? "0" + dia : dia) + "/" + (mes <= 9 ? "0" + mes : mes) + "/" + anyo;
    }

} // Empleado
