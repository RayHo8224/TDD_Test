package demo.hello.test;

//先import 待測套件
import static org.junit.Assert.*;
import demo.hello.*;

import org.junit.Before;
import org.junit.Test;

public class HelloTest {

	private Hello hello; //待測類別
	
	@Before
	public void setUp() throws Exception {
		hello=new Hello();
	}

	@Test
	public void testSayHello() {
//		fail("Not yet implemented");
		String expected="Ray,你好";  //期望值
		String actual=""; 	 //實際運算值
		
		actual=hello.sayHello("Ray");
		
		assertEquals(expected, actual);
	}

}
