package cst8284.shape;

public class Triangle extends BasicShape implements ShapeComparator, ShapeConstants {

	public Triangle(double width) {
		super(width);
	}
	public Triangle() {
		this(minValue);
	}
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}

	@Override
	public boolean isIdenticalTo(Object o) {
		if (equals(o)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isGreaterThan(Object o) {
		if(getWidth() >((Triangle) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSmallerThan(Object o) {
		if(getWidth() <((Triangle) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public double getArea() {
		return Math.sqrt(3)/4*(Math.pow(getWidth(),2));
	}

	@Override
	public double getPerimeter() {
		return 3*getWidth();
	}
	@Override
	public String toString() {
		return("Triangle extends "+super.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Triangle&&super.equals(o)) {
			return true;
		}
		return false;
	}

}
