package gson;

import java.util.List;

public class People {

	String name ;
	
	String age ;
	
	List<Hobby> hobbies ;
	
	String wife ;
	
	public People(String name , String age , List<Hobby> hobbies) {
		this.name = name ; 
		this.age = age ;
		this.hobbies = hobbies ;
	}
	
	
}
