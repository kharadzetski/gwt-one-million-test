package com.example.shared;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public final class StringGenerate {
	private StringGenerate() {};
	private static final int MIN_CHARS = 4;
	private static final int MAX_CHARS = 10;
	private static final int RAND_LIMIT = MAX_CHARS - MIN_CHARS;
	private static Random rand = new Random();
	public static String generateStr() {
		StringBuilder result = new StringBuilder(RandomStringUtils.randomAlphabetic(1).toUpperCase());
		int count = rand.nextInt(RAND_LIMIT) + MIN_CHARS;
		result.append(RandomStringUtils.randomAlphanumeric(count));
		return result.toString();
	}
}
