package empresa.presentacion;

/*
 * Menu de opciones:
 * 1. Registrar empleados contratados
 * 2. Registrar empleados por labor realizada
 * 3. Mostrar salarios por empleado
 * 4. Salir
 */

import empresa.datos.ListaEmpleados;
import empresa.entidades.*;
import java.util.*;
 
public class Application {
	
	int opt;
    ListaEmpleados listaContratados = new ListaEmpleados();
    ListaEmpleados listaLabor = new ListaEmpleados();
    private static Scanner lector = new Scanner(System.in);
    public static final short CONTRATADO = 0;
    public static final short POR_LABOR = 1;

    private static String leer(String msje) {
        System.out.print(msje + ": ");
        return lector.nextLine();
    }

	private void leer(int type) {
        String dni = leer("Ingrese su DNI");
        String nombre = leer("Ingrese su nombre");
        String apellidos = leer("Ingrese sus apellidos");
        System.out.println("Ingrese fecha de ingreso:");
        int anyo = Integer.parseInt(leer("Anyo"));
        int mes = Integer.parseInt(leer("Mes (1-12)"));
        int dia = Integer.parseInt(leer("Día"));
        GregorianCalendar fechaIngreso = new GregorianCalendar(anyo, mes-1, dia);

        if (type == CONTRATADO) {
            int salarioB = Integer.parseInt(leer("Ingrese salario base"));
            listaContratados.addEmpleado(new EContratado(dni, nombre, apellidos, fechaIngreso, salarioB));
        } else {
            int clientesObtenidos = Integer.parseInt(leer("Ingrese clientes reclutados"));
            listaLabor.addEmpleado(new ELabor(dni, nombre, apellidos, fechaIngreso, clientesObtenidos));
        }
    }

	private void mostrarSalarios() {
        System.out.println("Salarios de los empleados contratados: ");
        for (int i = 0; i <= listaContratados.getPosicion(); ++i)
            System.out.println(listaContratados.getEmpleado(i));
        System.out.println("Salarios de los empleados por labor realizada: ");
        for (int i = 0; i <= listaLabor.getPosicion(); ++i)
            System.out.println(listaLabor.getEmpleado(i));
    }

    private int menu() {
        System.out.print(
          "\nMENU DE OPCIONES\n"
        + "---- -- --------\n"
        + "1. Registrar empleados contratados.\n"
        + "2. Registrar empleados por labor realizada.\n"
        + "3. Mostrar salarios por empleado.\n"
        + "4. Salir.\n");
        return Integer.parseInt(leer("Seleccione opcion"));
    }

    private void accionar(int opt) {
        switch(opt)
        {
            case 1:
                leer(CONTRATADO);
                break;
            case 2:
                leer(POR_LABOR);
                break;
            case 3:
                mostrarSalarios();
                break;
            case 4:
                System.out.println("Cerrando programa . . .");
                break;
            default:
                System.err.println("Por favor, ingresa una opcion valida ._.");
        }
    }
	
	public void ejecutar() {

        do {
            opt = menu();
            accionar(opt);
        } while (opt != 4);
    }

} // Application
