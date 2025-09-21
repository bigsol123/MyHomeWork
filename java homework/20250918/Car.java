package ch4;

public class Car implements Vehicle {

	private int speed;

	
	public Car(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
		public void move() {
			System.out.println("이 차량의 속도는" + getSpeed() + "km 입니다." );
		}
}
