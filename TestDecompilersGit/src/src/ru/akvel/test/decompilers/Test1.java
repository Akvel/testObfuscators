package ru.akvel.test.decompilers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Akvel
 *
 */
public class Test1{
	private static int fInt = Integer.MIN_VALUE; 
	private static byte fByte = Byte.MIN_VALUE; 
	private static short fShort = Short.MIN_VALUE; 
	private static long fLong = Long.MIN_VALUE; 
	private static String fString = "Just test"; 
	public boolean b = false;
	private static Integer fIntC = Integer.MIN_VALUE; 
	private static Byte fByteC = Byte.MIN_VALUE; 
	@SuppressWarnings("unused")
	private static Short fShortC = Short.MIN_VALUE; 
	private static Long fLongC = Long.MIN_VALUE; 
	private static Boolean fBoolC = Boolean.FALSE;
	private final String a;
	
	protected Test1(){
		this.a = "passed";
	}
	private class TestClass{
		private long a;
		private int b;

		protected TestClass(){
			fByteC++;
			System.out.println("Here");
		}
		
		protected TestClass(int a, byte b){
			this();
			this.a = a;
			this.b = b;
		}
		
		@Deprecated
		private String Test(){
			return "" + (a+b);
		}
	}
	/**
	 * test anot
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		fInt = (int) (fByte ^ fShort | fLong * fIntC);
		//Цыклы
		for (int FInt = 0; FInt < 5; FInt++){
			System.out.print("Test " + fString + " " + args);
		}
		fByte = 0;
		while (fByte++ < 10){
			if (fByte > 11){
				throw new Exception("Test");
			}
		}
		//Условия
		if (fInt == 0){
			fInt += 12;
		}
		switch (fInt){
		case 1 : { break;}
		case  3 : { break;}
		}
		//Вложенный класс
		TestClass t = new  Test1().new TestClass(fInt == 0 ? 5 : 6, fByte);
		t.Test();
		//Вызовы функций
		System.out.println("test");
		System.currentTimeMillis();
		new Date().getClass().getClass().getFields();
		//Коллекции
		List<Integer> testList = new ArrayList<Integer>();
		testList.addAll(new ArrayList<Integer>(100));
		//TODO 123
		//FIXME 123
		//XXX 123
		//return 0;
	}
	/**
	 * @return the a
	 */
	public String getA() {
		return a;
	}
}
