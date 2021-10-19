package com.utility;

import java.util.Random;

public class GenerateOTP {
	public static String generateOTP()
	{
		String OTP="";
		Random r = new Random();
		int max = 999999, min = 100000;
		int code = r.nextInt((max - min) + max);
		OTP=String.valueOf(code);
		return OTP;
	}
}
