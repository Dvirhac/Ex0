package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MomomTest {
	Monom a;
	Monom b;
	Monom c;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		a= new Monom (2,3);
		b= new Monom (6,2);
		c= new Monom (3,3);


	}

	@Test
	void testDerivative() {
		a.derivative();
		assertEquals(true, a.equal(b));
	}

	@Test
	void testAdd() {
		a.add(c);
		Monom d = new Monom(5,3);
		assertEquals(true, a.equal(d));
	}

	@Test
	void testMultiply() {
		a.multiply(b);
		Monom d= new Monom (12,5);
		assertEquals(true, a.equal(d));
	}

	@Test
	void testF() {
		double x=	a.f(2);
		assertEquals(16, x);
	}

	@Test
	void testEqual() {
		assertEquals(false, a.equal(b));
		
	}

}
