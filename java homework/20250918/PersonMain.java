package ch4;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {

	public static void main(String[] args) {

		// 🎀 배열 말고 리스트를 쓰셨네요👍 실제 개발할 때도 배열보단 리스트를 더 많이 쓰는 것 같아요.
		List<PersonData> personList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			personList.add(new PersonData());
		}

		/* 🎀
		* 만약 솔쨩의 마을이 재개발되어 인구가 50명으로 늘어난다면 어떻게 될까요?
		* setName(), setAge()를 50번이나 직접 호출해 줘야 하는 아주 귀찮은 상황이 발생할 수도 있습니다 🫢
		* 이럴 때를 대비해서, 이름과 나이를 배열이나 리스트에 쫙 담고 위 for문에서 같이 초기화해 보는 건 어떨까요?
		* 나중에 시간 있을 때 고민해 주셔도 됩니다 ㅎㅎ
		*/
		personList.get(0).setName("기무라");
		personList.get(0).setAge(22);
		
		personList.get(1).setName("스쿠나");
		personList.get(1).setAge(19);
		
		personList.get(2).setName("짱구");
		personList.get(2).setAge(10);
		
		personList.get(3).setName("탄지로");
		personList.get(3).setAge(16);
		
		personList.get(4).setName("에렌");
		personList.get(4).setAge(20);
		
		
		System.out.println("--- 현재 저장된 주민 정보 ---");
		for (int i = 0; i < personList.size(); i++) {
			PersonData person = personList.get(i);
			System.out.println("주민 " + (i+1) + ":" + " 이름: " + person.getName()+ " /" + " 나이: " + person.getAge());

			
		}
	}
	
}
