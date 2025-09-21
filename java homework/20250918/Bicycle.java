package ch4;

public class Bicycle implements Vehicle {
		
	private int speed;

	public Bicycle(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override // 🎀 여기도 @Override 어노테이션을 달아주는 게 좋습니다.
	public void move() {
		System.out.println("이 차량의 속도는" + getSpeed() + "km입니다." );		
	}

	/* 🎀
	* 메서드는 보통 생성자 → 사용자 정의 메서드 → getter/setter → equals()/hashCode()/toString() 순으로
	* 배치하는 경우가 많은 것 같아요.
	* 꼭 지켜야 하는 것도 아니고 조직마다 컨벤션이 다르겠지만, 이러한 순서가 있다는 걸 알아 두면 협업할 때 도움될 거라 생각합니다.
	* 참고로, equals()/hashCode()/toString() 메서드들은 java.lang.Object 클래스에 정의된 메서드들이에요!
	* 도메인 클래스에서 오버라이딩해서 사용하는 경우가 많으니, 키워드 정도라도 가볍게 알아 두면 좋아요.
	*/
}
