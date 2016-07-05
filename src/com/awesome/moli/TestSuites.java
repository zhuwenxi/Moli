package com.awesome.moli;

import java.util.ArrayList;
import java.util.List;

public abstract class TestSuites {
	public int failCaseNumber = 0;
	public  int successCaseNumber = 0;
	
	public List<String> successCases;
	public List<String> failCases;
	
	public String desc;
	
	public TestSuites() {
		this.failCaseNumber = 0;
		this.successCaseNumber = 0;
		
		this.successCases = new ArrayList<String>();
		this.failCases = new ArrayList<String>();
	}
	
	public abstract void run();
	
	protected void it(String desc, TestSuite suite) {
		suite.desc = desc;
		suite.run();
	
		successCaseNumber += suite.successCaseNumber > 0 ? 1 : 0;
		failCaseNumber += suite.failCaseNumber > 0 ? 1 : 0;
		
		this.successCases.addAll(suite.successCases);
		this.failCases.addAll(suite.failCases);
	}
	
	protected void xit(String desc, TestSuite suite) {
		// Do nothing.
	}
}


