package cst8284.shape;

public class Square extends BasicShape implements ShapeComparator, ShapeConstants {

	public Square(double width) {
		super(width);
	}
	
	public Square() {
		this(minValue);
	}
	
	public Square(Square square) {
		this(square.getWidth());
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
		if(getWidth() >((Square) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSmallerThan(Object o) {
		if(getWidth() <((Square) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public double getArea() {
		return Math.pow(getWidth(),2);
	}

	@Override
	public double getPerimeter() {
		return 4*getWidth();
	}
	@Override
	public String toString() {
		return("Square extends "+super.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Square&&super.equals(o)) {
			return true;
		}
		return false;
	}

}
