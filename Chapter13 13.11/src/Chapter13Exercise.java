
public class Chapter13Exercise {

	public static void main(String[] args) {
		
		Octagon oc1 = new Octagon(10);
        Octagon oc2 = (Octagon)oc1.clone();

        System.out.println("compareTo: " + (oc1.compareTo(oc2) == 0));
        System.out.println("equals: " + oc1.equals(oc2));
        System.out.println("Have the same reference? " + (oc1 == oc2));
    }

	}
class Octagon extends GeometricObject implements Cloneable {

        double side;


    public Octagon() {
        this(5);
    }

    public int compareTo(Octagon oc2) {
				return 0;
	}

	public Octagon(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2.0 + 4.0 / Math.sqrt(2) * side * side);
    }

    public double getPerimeter() {
        return side * 8;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return o;
    }

    public boolean equals(Object o) {
        return o instanceof Octagon && getArea() == ((Octagon)o).getArea();
    }
}



