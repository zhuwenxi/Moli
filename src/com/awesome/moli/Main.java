package com.awesome.moli;

public class Main {
	public static void main(String[] args) {
		
		Moli.describe("Testcase1", new TestSuites() {
			
			public void run() {
				it("testcase 1", new TestSuite() {

					public void run() {
						expect("aa").toBe("aa");
					}
					
				});
				
				it("testcase 2", new TestSuite() {

					public void run() {
						expect("aa").toBe("aa");
					}
					
				});
				
				it("testcase 2", new TestSuite() {

					public void run() {
						expect(1).toBe(1);
					}
					
				});
				
			}
			
		});
	}
}
