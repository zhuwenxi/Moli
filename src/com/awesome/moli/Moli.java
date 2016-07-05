package com.awesome.moli;

public class Moli {
	
	private Moli() {
		
	}
	
	public static void describe(String desc, TestSuites suites) {
		suites.desc = desc;
		suites.run();
		printTestResult(suites);
	}
	
	private static void printTestResult(TestSuites suites) {
		if (suites.failCaseNumber == 0) {
			// No failures, all pass.
			System.out.println(String.format("%1d specs, %2d failures", suites.successCaseNumber, suites.failCaseNumber));
			System.out.println("\n" + suites.desc);
			for (String suiteDesc : suites.successCases) {
				System.out.println("    " + suiteDesc);
			}
		} else {
			// Has some failures
			System.out.println(String.format("%1d specs, %2d failures", suites.successCaseNumber + suites.failCaseNumber, suites.failCaseNumber));
			for (String suiteDesc : suites.failCases) {
				System.out.println("\n" + suiteDesc);
			}
		}
	}
}
