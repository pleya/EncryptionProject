package com.encryptionproject;


public class EncryptionProject {

	public static void main(String[] args) {
		int[] intArray = {0x12345678, 0x87654321};
		byte[] byteArray = Useful.IntArray2ByteArray(intArray);
		
		Useful.PrintArray(intArray);
		Useful.PrintArray(byteArray);
		
		int int1 = 2;
		int int2 = 7;
		String str = "int1 = %06d";
		System.out.println("str = " + str);
		System.out.printf(String.format("int1 = %s0%dd", "%",int2), int1 );

	}

}
