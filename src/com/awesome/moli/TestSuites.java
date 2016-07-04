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
	
		successCaseNumber += suite.successCaseNumber;
		failCaseNumber += suite.failCaseNumber;
		
		this.successCases.addAll(suite.successCases);
		this.failCases.addAll(suite.failCases);
	}
}

abstract class TestSuite {
	public int failCaseNumber = 0;
	public int successCaseNumber = 0;
	
	public List<String> successCases;
	public List<String> failCases;
	
	public String desc;
	
	public abstract void run();
	
	public TestSuite() {
		this.failCaseNumber = 0;
		this.successCaseNumber = 0;
		
		this.successCases = new ArrayList<String>();
		this.failCases = new ArrayList<String>();
	}
	
	public Object expectValue;
	
	protected TestSuite expect(Object expectValue) {
		this.expectValue = expectValue;
		return this;
	}
	
	protected void toBe(Object toBeValue) {
		if (this.expectValue == null) {
			if (toBeValue == null) {
				meetSuccessCase();
			} else {
				meetFailCase(this.expectValue, toBeValue);
			}
		} else {
			if (this.expectValue.equals(toBeValue)) {
				meetSuccessCase();
			} else {
				meetFailCase(this.expectValue, toBeValue);
			}
		}
	}
	
	private void meetSuccessCase() {
		meetSuccessOrFailCase(true, this.desc);
	}
	
	private void meetFailCase(Object expectValue, Object toBeValue) {
		String failMessage = String.format("%1s:\n    expect %2s to be %3s.", this.desc, expectValue, toBeValue);
		meetSuccessOrFailCase(false, failMessage);
	}
	
	private void meetSuccessOrFailCase(boolean isSuccessCase, String message) {
		if (isSuccessCase) {
			this.successCaseNumber ++;
			if (! this.successCases.contains(message)) {
				this.successCases.add(message);
			}
		} else {
			this.failCaseNumber ++;
			
			if (! this.failCases.contains(message)) {
				this.failCases.add(message);
			}
		}
	}
}
