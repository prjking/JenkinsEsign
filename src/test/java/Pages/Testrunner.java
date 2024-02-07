package Pages;

import org.testng.TestNG;

import TestCase.LoginPageTest;

public class Testrunner {
	
     static TestNG testNg;
    	 
    	 
     
	public static void main(String[] args) {
		testNg =new TestNG();
		testNg.setTestClasses(new Class[]{LoginPageTest.class});
		//testNg.setTestClasses(new Class[]{Alldocuments.class});
		testNg.run();
		

	}

}
