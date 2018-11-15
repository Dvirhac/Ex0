
package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import javax.swing.plaf.synth.SynthStyle;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("Monom test :)\n");
		Monom d= new Monom (2,3);
		Monom y = new Monom (3,3);
		System.out.println("add test\n");
		System.out.println("monom A = " +y + ", monom B = " + d);
		d.add(y);
		System.out.println("expected result: 5x^3");
		System.out.println("actual result: " +d);
		System.out.println("if they were with differnet powers- you cant add them!");
		System.out.println("\nderivative() test!\n");
		d.derivative();
		System.out.println("expected result: 15x^2");
		System.out.println("actual result: "+ d);
		System.out.println("\nF(X) test:\n");
		System.out.println("x=2: the result for 15x^2 should be: 60");
		System.out.println("actual result: " + d.f(2));
		
		System.out.println("\nPolynom Test! :)\n");
		
		
		
		
		
		
		Polynom_able p1 = new Polynom();						//empty constructor
		System.out.println("Empty Constructor p1:");
		System.out.println("expected result: The polynom p1 should be empty");
		System.out.println("actual reuslt: " +p1);


		//string constructor
		System.out.println("\nString Constructor ");
		Polynom_able p2 = new Polynom("-x +4x^2 + 6*x^3 - x^5");
		System.out.println("The expected Polynom p2:\n -4 - x^1 + 4*x^2 +6*x^3 - x^5");
		System.out.println("Your Polynom is:\n" + p2);



		Polynom_able p3 = new Polynom(p2);								//Copy constructor
		System.out.println("\nCopy Constructor p3<-p2:");
		System.out.println("The expected Polynom p4:\n-4 - x^1 + 4*x^2 +6*x^3 - x^5");
		System.out.println("Your Polynom p3 is:\n" + p3);

	
 

		System.out.println("\nF(x) test");
		Polynom_able p5 = new Polynom("6x^2 + 0x -8x");
		System.out.println("x=2: The expected output for: f(x)= 6x^2 + 0x -8x; is 8");
		System.out.println("result: "+ p5.f(2));
		

		
		
		System.out.println("\nadd(Polynom) test\n");
		Polynom_able p6 = new Polynom("5x^2+ 0 + 6x -x^3 + 5 - 0.5x^2 + 0.8x");
		Polynom_able p7 = new Polynom("-x^2 +5 -3x^1 +x^3 + 3 + x");
		System.out.println("expexted result is: 13 + 4.8x + 3.5x^2 ");
		p6.add(p7);
		System.out.println("actual result :" + p6.toString() );
		
		
		
		System.out.println("\nadd(Monom) test:\n");
		Polynom_able p20 = new Polynom();
		System.out.println("expected: empty");
		System.out.println("actual result: "+p20);
		Monom m1 = new Monom(-2,6);
		p20.add(m1);
		System.out.println("expected result: -2x^6");
		System.out.println("actual result:"+ p20);
		Monom m2 = new Monom(-1,2);
		p20.add(m2);
		System.out.println("expected result: -x^2 -2x^6");
		System.out.println("actual result:"+ p20);
		Monom m3 = new Monom(-4,2);
		p20.add(m3);
		System.out.println("expected result: -5x^2 -2x^6");
		System.out.println("actual result:"+ p20);
		
		System.out.println("\nsubstract (Polynom_able) test: \n");
		Polynom_able p8 = new Polynom("x^2+3x^6+5*x^9+2");
		Polynom_able p21= new Polynom("6x^2 + 3 -2x^2");
		p21.substract(p8);;
		System.out.println("expected result: 1 +3*x^2 - 3*x^6 - 5*x^9");;
		System.out.println("actual result:"+ p21 );
		
		System.out.println("\nmultiply(Polynom_able) test: \n");
		Polynom p9 = new Polynom("x^2+3x^6+5*x^9+2");
		p21.multiply(p9);
		System.out.println("expected result: 2.0  + 7.0*x^2  + 3.0*x^4 -3.0*x^6  + 6.0*x^8 -5.0*x^9  + 10.0*x^11 -9.0*x^12 -30.0*x^15 -25.0*x^18");;
		System.out.println("actual result:"+ p21 );
		
		System.out.println("\nequals(Polynom_able)\n");
		Polynom_able p10 = new Polynom("x^2+3x^6+5*x^9+2");
		
		System.out.println("expected result: false");
		System.out.println("actual result:"+ p7.equals(p10));
		
		Polynom_able p11 = new Polynom();
		Polynom_able p12 = new Polynom("0");
		
		System.out.println("expected result: true");
		System.out.println("actual result:"+ p11.equals(p12));
		
		System.out.println("\niszero() test:\n");
		Polynom_able p13 = new Polynom("5x^2");
		System.out.println("expected result: false");;
		System.out.println("actual result:"+ p13.isZero());
		p13.substract(p13);
		System.out.println("expected result: true");;
		System.out.println("actual result:"+ p13.isZero());
		Monom m4 = new Monom(0,2);
		p13.add(m4);
		System.out.println("expected result: true");;
		System.out.println("actual result:"+ p13.isZero());
		
		Polynom_able p14=new Polynom("x^3-x^2+2");
		System.out.println("\nroot(double x0, double x1, double eps) test: \n");
		System.out.println("expected result: -1.00250244..");;
		System.out.println("actual result: "+p14.root(-200, 300, 0.01));
		
		System.out.println("\ncopy() test: \n");
		Polynom_able p15= new Polynom(p14);
		p14.substract(p14);
		System.out.println("expected result: 2 - x^2 + x^3 ");
		System.out.println("actual result: "+ p15.toString());
		
		System.out.println("\nderivative() test:\n");
		System.out.println("expected result: -2x^1 + 3x^3 ");
		p15.derivative();
		System.out.println("actual result: "+ p15);
		
		Polynom p16=new Polynom("x^3-x^2+2");
		System.out.println("\narea test:\n");
		System.out.println("expected result: 12.48 ");
		System.out.println("actual result: "+ p16.area(0, 3, 0.6));
		Polynom_able p40= new Polynom("5x^2 + 6x + 4");
		p40.derivative();
		System.out.println(p40);
		
		Polynom p30=new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		double x=p30.area2(-2, 6);
		System.out.println(x);
		
		
	}
}