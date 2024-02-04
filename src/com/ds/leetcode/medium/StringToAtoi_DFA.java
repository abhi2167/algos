package com.ds.leetcode.medium;

public class StringToAtoi_DFA {
	
	public static void main(String[] args) {
		
		String s = "   -421 with ";
		
		StateMachine sm = new StateMachine();
		
		for(int i = 0; i < s.length() && sm.getCurrentState() != State.qd; i++) {
			sm.transition(s.charAt(i));
		}
		
		System.out.println("Result is "+ sm.getResult());
	}

}


enum State {
	q0,q1,q2,qd;
}

class StateMachine {
	
	private int result;
	private State currentState;
	private int sign;
	
	public StateMachine() {
		
		sign = 1;
		result = 0;
		currentState = State.q0;
		
	}
	
	void toStateQ1(char ch) {
		sign = ch == '-' ? -1 : 1;
		currentState = State.q1;
	}
	
	void toStateQ2(int digit) {
		currentState = State.q2;
		appendDigit(digit);
	}
	
	void toStateQd() {
		currentState = State.qd;
	}
	
	private void appendDigit(int digit) {
		if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE && digit > Integer.MAX_VALUE%10)) {
			result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			toStateQd();
		} else {
			result = result * 10 + digit;
		}
	}
	
	public void transition(char ch) {
		if(currentState == State.q0) {
			if(ch == ' ') {
				return;
			} else if(ch == '+' || ch == '-') {
				toStateQ1(ch);
			} else if(Character.isDigit(ch)) {
				toStateQ2(ch - '0');
			} else {
				toStateQd();
			}
		} else if(currentState == State.q1 || currentState == State.q2) {
			if(Character.isDigit(ch)) {
				toStateQ2(ch - '0');
			} else {
				toStateQd();
			}
		}
	}
	
	public int getResult() {
		return result * sign;
	}
	
	
	public State getCurrentState() {
		return currentState;
	}
	
}