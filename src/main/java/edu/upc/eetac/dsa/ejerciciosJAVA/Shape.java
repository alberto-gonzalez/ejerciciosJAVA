package edu.upc.eetac.dsa.ejerciciosJAVA;

public abstract class Shape {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "I'm a " + type;
    }

	public double area() {
		return 0;
	}
	
    
 
    
}