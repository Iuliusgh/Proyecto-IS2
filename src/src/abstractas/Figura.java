package abstractas;

public abstract class Figura {
	// centro de la figura
	protected double x;
	protected double y;

	public Figura() {
		this.x = 0;
		this.y = 0;
	}

	public Figura(double xx, double yy) {
		this.x = xx;
		this.y = yy;
	}

	abstract public double area();

	abstract public void drawFigura();
}
