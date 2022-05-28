package tests;

public class JavaClass {

	public static void main(String[] args) {
		
		System.out.println("Hi");
		
		int a = 10;
		int b = 2;
		int c = 45;
		int d [] = {1,45,32,76};
				
		try {
			c = a/b;
			System.out.println(d[7]);
		}
		catch (ArithmeticException e) {
			System.out.println("alternative code ArithmeticException");
			b = 1; 
			c = a/b;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("finally");
		}
	
		System.out.println("value of c = " + c);
		
		// Exception generated and get handelled 
		//try -> catch -> finally -> Normal flow
		
		// Exception not generated 
		//try -> finally -> Normal flow
		
		// Exception generated and not get handelled 
		//try -> finally
		
		
		
	}
}
