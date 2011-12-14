package com.encryptionproject;

public class CharDictionary {
	private char CHAR;
	private int[] InstancesIndices;
	private int[] AllowedNumbers;
	private int[] TrailingNumbers;
	private int WORD_LENGTH;

	public CharDictionary(char CHAR, int[] InstancesIndices) {
		this.CHAR = CHAR;
		this.InstancesIndices = InstancesIndices;

	}

	public char getCHAR() {
		return CHAR;
	}
	public void setCHAR(char cHAR) {
		CHAR = cHAR;
	}

	public int[] getInstancesIndices() {
		return InstancesIndices;
	}

	public void setInstancesIndices(int[] instancesIndices) {
		InstancesIndices = instancesIndices;
	}

	public int[] getAllowedNumbers() {
		return AllowedNumbers;
	}

	public void setAllowedNumbers(int[] allowedNumbers) {
		AllowedNumbers = allowedNumbers;
	}

	public int[] getTrailingNumbers() {
		return TrailingNumbers;
	}

	public void setTrailingNumbers(int[] trailingNumbers) {
		TrailingNumbers = trailingNumbers;
	}

	public int getWORD_LENGTH() {
		return WORD_LENGTH;
	}

	public void setWORD_LENGTH(int WORD_LENGTH) {
		this.WORD_LENGTH = WORD_LENGTH;
	}
}
