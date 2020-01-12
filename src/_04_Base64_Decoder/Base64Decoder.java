package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for (int i = 0; i < base64Chars.length; i++) {
			if(base64Chars[i]==c) {
				return (byte) i;
			}
		}
		return 0;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		char[] chars = s.toCharArray();
		byte[] bytes = new byte[3];
			bytes[0] = (byte)((convertBase64Char(chars[0])<<2)+(convertBase64Char(chars[1])>>4));
			bytes[1] = (byte)((convertBase64Char(chars[1])<<4)+(convertBase64Char(chars[2])>>2));
			bytes[2] = (byte)((convertBase64Char(chars[2])<<6)+(convertBase64Char(chars[3])>>0));
		return bytes;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
			byte[] bytes = new byte[file.length()*3/4];
			int counter = 0;
			String temp = "";
			for (int i = 0; i < file.length(); i+=4) {
				byte[] b1 = convert4CharsTo24Bits(file.substring(i, i+4));
				for (int j = 0; j < 3; j++) {
					bytes[counter+j] = b1[j];
					
				}
				counter+=3;
			}
		return bytes;
	}
	
	
	
	
	
//	char[] chars = file.toCharArray();
//	for (int i = 0; i < bytes.length; i+=3) {
//		bytes[i] = (byte)((convertBase64Char(chars[i])<<2)+(convertBase64Char(chars[i+1])>>4));
//		bytes[i+1] = (byte)((convertBase64Char(chars[i+1])<<4)+(convertBase64Char(chars[i+2])>>2));
//		bytes[i+2] = (byte)((convertBase64Char(chars[i+2])<<6)+(convertBase64Char(chars[i+3])>>0));
//	}
	//char[] arrayC = file.toCharArray();
	
	
	
	
	
	
	
	

	
//	for (int j = i; j < i+4; j++) {
//	temp+=arrayC[j];
//}
//byte[] b1 = convert4CharsTo24Bits(temp);
//temp = "";
	
//	public byte decimalToByte(byte b) {
//		byte counter = 0;
//		if((0b10000000&b)>>7==1){
//			counter+=128;
//		}else if ((0b01000000&b)>>6==1) {
//			counter+=64;
//		}else if ((0b00100000&b)>>5==1) {
//			counter+=32;
//		}else if ((0b00010000&b)>>4==1) {
//			counter+=16;
//		}else if ((0b00001000&b)>>3==1) {
//			counter+=8;
//		}else if ((0b00000100&b)>>2==1) {
//			counter+=4;
//		}else if ((0b00000010&b)>>1==1) {
//			counter+=2;
//		}else if ((0b00000001&b)>>0==1) {
//			counter+=1;
//		}
//		return counter;
//		
//	}
	
}
