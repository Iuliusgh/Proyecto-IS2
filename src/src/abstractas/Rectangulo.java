package abstractas;

public class Rectangulo extends Figura {
	private double base;
	private double altura;

	public Rectangulo(double xx, double yy, double b, double a) {
		super(xx, yy);
		this.base = b;
		this.altura = a;
	}

	public double area() {
		return this.base * this.altura;
	}

	public void drawFigura() {/* ... */
	}
}
