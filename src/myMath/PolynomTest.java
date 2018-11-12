package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {
	Polynom_able p;
	Polynom_able p1;
	@BeforeEach
	void setUp() throws Exception {
	 p=new Polynom("x^3-x^2+2");
	 p1= new Polynom("6x^3 + 10x");
	}

	
	@Test
	void testF() {
		
		double x= p.f(3);
		assertEquals(20, x,"testF is wrong");
	}

	@Test
	void testAddPolynom_able() {
		p.add(p1);
		System.out.println(p);
		Polynom_able p2 = new Polynom("2  + 10x - x^2  + 7x^3 ");
		assertTrue(p.equals(p2),"testAddPolynom is wrong");
		
	}

	@Test
	void testAddMonom() {
		//fail("Not yet implemented"); // TODO
		Monom m = new Monom(6,4);
		p.add(m);
		Polynom_able p1= new Polynom("6x^4 + x^3 - x^2 + 2");
		assertEquals(true, p1.equals(p1),"testAddMonom is wrong");
		
	}

	@Test
	void testSubstract() {
		//fail("Not yet implemented"); // TODO
		p.substract(p1);
		Polynom_able p2 = new Polynom("-5x^3 -x^2 -10x +2");
		assertEquals(true, p.equals(p2),"testSubstruck is wrong");
	}

	@Test
	void testMultiply() {
	//	fail("Not yet implemented"); // TODO
		p.multiply(p1);
		Polynom_able p2= new Polynom("20x + 2x^3 + 10x^4 -6x^5 + 6x^6");
		assertEquals(true, p.equals(p2), "testMultyply is wrong");
	}

	@Test
	void testEqualsPolynom_able() {
		//fail("Not yet implemented"); // TODO
		
 		assertEquals(false, p1.equals(p),"testEqual is wrong");
		
	}

	@Test
	void testIsZero() {
		//fail("Not yet implemented"); // TODO
		assertEquals(false, p.isZero(),"testIsZero is wrong");
	}

	@Test
	void testRoot() {
		//fail("Not yet implemented"); // TODO
		double x = p.root(-200, 300, 0.01);
		assertEquals(-1.00250244140625, x, 0.1,"testRoot is wrong");
		
	}
	 	
	

	@Test
	void testDerivative() {
		//fail("Not yet implemented"); // TODO
		p.derivative();
		Polynom_able p2= new Polynom("3x^2 - 2x");
		assertEquals(true, p.equals(p2),"testDerivative is wrong");
		
		
		
	}

	@Test
	void testArea() {
		//fail("Not yet implemented"); // TODO
		double x= p.area(0, 3, 0.6);
		assertEquals(12.48, x, 0.1,"testArea is wrong");
		
	}

}
