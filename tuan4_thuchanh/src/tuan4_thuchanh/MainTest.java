package tuan4_thuchanh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		Main tst = new Main();
		
		Double result = tst.PhepTinh("6", "7", "/");
		System.out.print(result);
		assertEquals(Double.POSITIVE_INFINITY, result);
		
		result = tst.PhepTinh("a", "a", "-");
		System.out.print(result);
		assertNull(result);
		
		result = tst.PhepTinh("6", "4", "+");
		System.out.print(result);
		assertEquals(10, result);
	}

}
