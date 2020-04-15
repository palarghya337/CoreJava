package com.corejava.practice.interfaces;

import com.corejava.practice.utils.Log;

public class TestInterfaces {

  public static void main(String[] args) {
    
    ImplementFunctionalInterface fInterfaceObj = (firstNumber, secondNumber) -> firstNumber + secondNumber;
    Log.logInfo("Addition: {0}", fInterfaceObj.addNumbers(10, 20));
    Log.logInfo("Substraction: {0}", fInterfaceObj.substractNumbers(20, 10));
    Log.logInfo("Multiplication: {0}", ImplementFunctionalInterface.multiplyNumbers(20, 10));
    
    AClass aa= new AClass(10) {
	};
  }
}
abstract class AClass{
	
	int input;
	public AClass() {}
	public AClass(int input) {
		this.input = input;
	}
}