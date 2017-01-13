package com.tistory.luahius;

public class Math {
	public int MyMath(int x, int y){
		return x+y;
		
	}
	
	public static void main(String[] args){
		Math m = new Math();
		System.out.println(m.MyMath(10,10)==20);
	}
}

class testCode {
	testCode(){
		Math m = new Math();
		System.out.println(m.MyMath(10,10)==20);
	}
}

