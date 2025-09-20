package ch4;

public class VehicleSpeed {

	public static void main(String[] args) {

		Vehicle z1 = new Car(60);
		Vehicle z2 = new Bicycle(50);
		
		z1.move();
		z2.move();
	}

}
