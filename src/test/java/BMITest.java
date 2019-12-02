import static org.junit.Assert.*;

import org.junit.Test;

public class BMITest extends BMIServlet {

	@Test
	public void test() {
		BMIServlet s = new BMIServlet();
		double result = s.bmi(80.0, 2.0);
		assertEquals(20.0, result, 0.1);
	}

}
