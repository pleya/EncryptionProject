package com.encryptionproject;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;

public class Useful {
	public static byte[] CalculateChecksum(byte[] data) {
		System.out.println("\t The data size is " + data.length);
		try {
			// MessageDigest messagedigest = MessageDigest.getInstance("SHA1");
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");

			ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(data);
			// CheckedInputStream cis = new CheckedInputStream(bais, new Adler32());
			byte readBuffer[] = new byte[1024];

			int nread = 0;
			while ((nread = bytearrayinputstream.read(readBuffer)) != -1) {
				messagedigest.update(readBuffer, 0, nread);
			}
			byte[] checksum = messagedigest.digest();
			System.out.printf("\t checksum.length = %d\n", checksum.length);

			// convert the byte to hex format
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < checksum.length; i++) {
				sb.append(Useful.byte2String(checksum[i]));
			}
			System.out.println("\t Digest(in hex format):: " + sb.toString());
			return checksum;
		} catch (Exception e) {
			System.out.println("Exception has been caught" + e);
			e.printStackTrace();
		}
		return null;
	}
	public static int[] CalculateChecksum(int[] data) {
		System.out.println("\t The data size is " + data.length);
		return ByteArray2IntArray(CalculateChecksum(IntArray2ByteArray(data)));
	}
	public static String byte2String(byte byte1) {
		return String.format("%02x", byte1);
	}
	public static byte[] int2byte(int int1) {
		byte[] bytearr = new byte[4];
		for (byte i = 3; i >= 0; i--) {
			bytearr[i] = (byte) int1;
			int1 >>= 8;
		}
		return bytearr;
	}
	public static int ByteArray2int(byte[] byteArray) {
		if (byteArray.length != 4)
			return 0;
		int int1 = 0;
		for (byte i = 0; i < byteArray.length; i++) {
			int1 <<= 8;
			int1 += (byteArray[i]) & 0x000000ff;
		}
		return int1;
	}
	public static byte[] IntArray2ByteArray(int[] intArray) {
		byte[] byteArray = new byte[intArray.length * 4];
		for (int i = 0; i < intArray.length; i++) {
			byte[] tempbytearr = int2byte(intArray[i]);
			byteArray[4 * i] = tempbytearr[0];
			byteArray[4 * i + 1] = tempbytearr[1];
			byteArray[4 * i + 2] = tempbytearr[2];
			byteArray[4 * i + 3] = tempbytearr[3];
		}
		return byteArray;
	}
	public static int[] ByteArray2IntArray(byte[] byteArray) {
		if (byteArray.length == 0)
			return null;
		int len = (byteArray.length / 4) + (byteArray.length % 4 > 0 ? 1 : 0);
		int[] intArray = new int[len];
		int tempint = 0;
		for (int i = 0; i < byteArray.length; i++) {
			if (i % 4 == 0)
				tempint = 0;
			tempint <<= 8;
			tempint += (byteArray[i]) & 0x000000ff;
			if (i % 4 == 3)
				intArray[i / 4] = tempint;
		}
		int repeats = (4 - (byteArray.length % 4)) % 4;
		for (int i = 0; i < repeats; tempint <<= 8, i++)
			;
		intArray[intArray.length - 1] = tempint;
		return intArray;
	}
	public static <T> void PrintArray(T t) {
		if (t == null) {
			System.out.println("Array is null.");
			return;
		}
		int[] intArray = null;
		byte[] byteArray = null;

		if (t.getClass().getSimpleName().contentEquals("int[]"))
			intArray = (int[]) t;
		if (t.getClass().getSimpleName().contentEquals("byte[]"))
			byteArray = (byte[]) t;

		if (intArray != null)
			for (int i = 0; i < intArray.length; i++)
				System.out.printf("0x%08x\n", intArray[i]);
		if (byteArray != null)
			for (int i = 0; i < byteArray.length; i++) {
				System.out.printf("0x%02x ", byteArray[i]);
				if (i % 4 == 3)
					System.out.println();
			}
	}
}
