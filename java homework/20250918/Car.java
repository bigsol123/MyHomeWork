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

	/* 🎀
	* 인터페이스의 메서드를 구현할 때, @Override 어노테이션을 붙여주는 게 좋습니다.
	* 개발자의 실수로 오타가 발생한 경우 컴파일러 에러를 발생시켜, 바로 감지할 수 있기 때문입니다.
	* 또한, 다른 팀원 개발자에게도 "이 메서드는 부모/인터페이스 메서드를 오버라이딩한 것이다"를 명확히 알릴 수 있어요.
	 */
	// @Override // << 주석 풀어주시면 됩니당(Bicycle도 마찬가지)
	public void move() {
			System.out.println("이 차량의 속도는" + getSpeed() + "km 입니다." );
		}
}
