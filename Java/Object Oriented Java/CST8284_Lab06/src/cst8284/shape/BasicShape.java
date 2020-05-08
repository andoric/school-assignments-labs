package cst8284.shape;

public abstract class BasicShape implements ShapeConstants {

	private double width;

	protected BasicShape(double width) {
		if (width > maxValue)
			setWidth(maxValue);
		setWidth(width);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return ("BasicShape extends " + super.toString());
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	@Override
	public boolean equals(Object o) {
		if (((BasicShape) o).getWidth() == getWidth()) {
			return true;
		}
		return false;
	}

}
