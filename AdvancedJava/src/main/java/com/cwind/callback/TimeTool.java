package com.cwind.callback;

public class TimeTool {
	public void printExecutionTime(CallBack callback){
		long startTime = System.currentTimeMillis();
		callback.execute();
		long endTime = System.currentTimeMillis();
		System.out.println("Function in "+ callback.getClass()+ " execution time: "+ (endTime - startTime));
	}
	
	public static void main(String[] args){
		TimeTool timetool = new TimeTool();
		timetool.printExecutionTime(new CallBack(){

			@Override
			public void execute() {
				ExecutionTimeTest.testMethod2();
			}
		});
	}
}
