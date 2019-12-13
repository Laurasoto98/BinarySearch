package lab05;

public class Tester {
	
	public static void main(String[] args) {
		
		BinarySearchSet sTester = new BinarySearchSet();
		
		
		
		sTester.binary_add(1.2);
		sTester.binary_add(13.0);
		sTester.binary_add(7.0);
		sTester.binary_add(2.5);
		sTester.binary_add(9.0);
		
		
		BinarySearchSet secondTester = new BinarySearchSet(new double [] {1.0, 9.0, 3.9, 4.5, 3, 3});
		BinarySearchSet thirdTester = new BinarySearchSet(new double [] {30.0, 45.0, 2.0, 9.0});
		
		double[] test = new double[] {1.2,2.5,13.0,7.0};
		double[] test2 = new double[] {15.0,7.0};
		double[] test3 = new double[] {9.0,1.2,2.5,13.0,7.0};
		
		secondTester.remove(9.0);
		sTester.remove(1.2);
		secondTester.clear();
		
		System.out.println(sTester.containsAll(test));
		System.out.println(sTester.containsAll(test2));
		System.out.println(sTester.containsAll(test3));
		System.out.println(sTester.contains(2.5));
		System.out.println(sTester.contains(20.5));
		System.out.println(sTester.size());
		System.out.println(secondTester.size());
		System.out.println(thirdTester.size());
		System.out.println(sTester.toString());
		System.out.println(secondTester.toString());
		System.out.println(thirdTester.toString());
		sTester.clear();
		System.out.println(sTester.isEmpty());
	}
	
	
}
