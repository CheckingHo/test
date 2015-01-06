package main;

class A {
	
}


class B extends A{
	
}

public class Test {

	public static void main(String[] args) {
		A a = new B() ;
		System.out.println(a.getClass().getCanonicalName());
	}
	
	
}
