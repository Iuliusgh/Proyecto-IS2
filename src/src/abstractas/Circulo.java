package abstractas;

public class Circulo extends Figura {
	private double radio;

	public Circulo(double xx, double yy, double r) {
		super(xx, yy);
		this.radio = r;
	}

	public double area() {
		return Math.PI * this.radio * this.radio;
	}

	public void drawFigura() {/* ... */
	}
}