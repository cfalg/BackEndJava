package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.5;
			}
		};
	}

	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				// return 0;//todo
				// [CFV - 20/07/2021] - Employee:cobre el sou mensual aplicant una reducción del
				// 15% (100%-15%=85%)
				return salaryPerMonth * (0.85);
			}
		};
	}

	// [CFV - 20/07/2021] - Manager: cobre un 10% més del seu salari mensual
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}
	
	
	// [CFV - 21/07/2021] - Junior: cobre un 15% menys del seu salari mensual
	public static IPaymentRate createPaymentRateJunior(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*(0.85);
			}
		};
	}


	// [CFV - 21/07/2021] - Mid: cobre un 10% menys del seu salari mensual
	public static IPaymentRate createPaymentRateMid(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*(0.90);
			}
		};
	}
	

	// [CFV - 21/07/2021] - Senior: cobre un 5% menys del seu salari mensual
	public static IPaymentRate createPaymentRateSenior(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*(0.95);
			}
		};
	}
	
	
	
	
	
	
	
	
}
