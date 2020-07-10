package com.coffeemachine.customExceptions;

public class CoffeeMachineException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CoffeeMachineException()
	{
		super();
	}
	public CoffeeMachineException(String message)
	{
	    super(message);
    }

	public CoffeeMachineException(String message, Throwable cause)
	{
	    super(message, cause);
    }
	
	public CoffeeMachineException(Throwable cause)
	{
	    super(cause);
    }

}
