package ch4;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {

	public static void main(String[] args) {
	
		List<PersonData> personList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			personList.add(new PersonData());
		}
		
		
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
