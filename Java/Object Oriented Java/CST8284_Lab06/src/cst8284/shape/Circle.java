package cst8284.shape;
public class Circle extends BasicShape implements ShapeComparator, ShapeConstants {

	public Circle(double width) {
		super(width);

	}
	public Circle() {
		this(minValue);
	}
	public Circle(Circle circle) {
		this(circle.getWidth());
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
		if(getWidth() >((Circle) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSmallerThan(Object o) {
		if(getWidth() <((Circle) o).getWidth()) {
			return true;
		}
		return false;
	}

	@Override
	public double getArea() {
		return Math.PI*(Math.pow((getWidth()/2),2));
	}

	@Override
	public double getPerimeter() {
		return Math.PI*getWidth();
	}
	
	@Override
	public String toString() {
		return("Circle extends "+super.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle&&super.equals(o)) {
			return true;
		}
		return false;
	}

}
