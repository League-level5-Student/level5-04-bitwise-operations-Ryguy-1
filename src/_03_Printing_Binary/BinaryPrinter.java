package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
		System.out.println(b>>0);
		String counter ="";
		//need a way to figure out how to change 0x00000001 thing!!! -- may be able to divide by ten or something
		for (int i = 8; i > 0; i--) {
			if((0x00000001 & b)>>i==1) {
				counter += (1 + "");
			}
		}
		System.out.println(counter);
		
	}
	
	public void printShortBinary(short s) {
		//16 bit
//		int sign = Integer.signum(s);
//		if (sign==1) {
//			for (int i = 0; i < 15; i++) {
//				if(temp<) {
//					
//				}
//			}
//		}
	}
	
	public void printIntBinary(int i) {
		
	}
	
	public void printLongBinary(long l) {
		
	}
	
	
	public static void main(String[] args) {
		BinaryPrinter printer = new BinaryPrinter();
		byte s = 122;
		printer.printByteBinary(s);
	}
	
	
}
