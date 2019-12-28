package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
//		String counter ="";
		System.out.print((0b10000000&b)>>7);
		System.out.print((0b01000000&b)>>6);
		System.out.print((0b00100000&b)>>5);
		System.out.print((0b00010000&b)>>4);
		System.out.print((0b00001000&b)>>3);
		System.out.print((0b00000100&b)>>2);
		System.out.print((0b00000010&b)>>1);
		System.out.print((0b00000001&b)>>0);
//		if((0x00000001 & b)>>0==1) {
//				counter += (1 + "");
//			}else if((0x00000010 & b))
//		System.out.println(counter);
		
	}
	
	public void printShortBinary(short b) {
	//16bit
//		BinaryPrinter temp = new BinaryPrinter();
		printByteBinary((byte)(b>>8));
		printByteBinary((byte)(b>>0));
	}
	
	public void printIntBinary(int b) {
		//32 bit
		printShortBinary((short)(b>>16));
		printShortBinary((short)(b>>0));
	}
	
	public void printLongBinary(long l) {
		//64
		printIntBinary((int)(l>>32));
		printIntBinary((int)(l>>0));
	}
	
	
	public static void main(String[] args) {
		BinaryPrinter printer;
		printer = new BinaryPrinter();
		byte s = 122;
		short b = 19283;
		int i = 1249012345;
		long l = 18828349;
		printer.printByteBinary(s);
		System.out.println("");
		printer.printShortBinary(b);
		System.out.println("");
		printer.printIntBinary(i);
		System.out.println("");
		printer.printLongBinary(l);
	}
	
	
}
