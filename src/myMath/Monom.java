
package myMath;

import java.util.Arrays;
import java.util.function.DoublePredicate;

import javax.management.RuntimeErrorException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Yuval Amar , Dvir Hacohen
 *@version 1.0
 */
public class Monom implements function{
	private double _coefficient; //מקדם
	private int _power;  //חזקה
	/**
	 * this is a constructor to new monom the set the power and the coefficient.
	 * @param a for the coefficient.
	 * @param b for the Power.
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**
	 * the constructor get a monom and copy the coefficient and the power to new monom.
	 * @param ot the monom we want to copy from him
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * 
	 * @return power
	 */
	int get_power() {

		return _power;
	}
	/**
	 *
	 * @return coefficient
	 */
	double get_coefficient() {
		return _coefficient;
	}
	/**
	 * this function compute the derivative of a monom and change the coefficient and the power as needed.
	 */
	public void derivative() {

		if (this.get_power()==0) {
				this.set_coefficient(0);
				return;
			}
			this.set_coefficient(_coefficient*_power);
			this.set_power(_power-1);
		
	}
	/**
	 * this function add the the coefficient for to the monom if the power are the same.
	 * @param b the monom we want to add.
	 */
	public void add(Monom b) {
		if(b._power!=this._power) throw new RuntimeErrorException(null, "differnt power, you cant add them!");
		set_coefficient(this._coefficient+b._coefficient);
	/**
	 * this function multiply between tow monom.
	 */
	}
	public void multiply(Monom b) {
		this.set_coefficient(_coefficient*b._coefficient);
		this.set_power(_power+b._power);
	}
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}
	/**
	 * this function calculate the value of any x in the monom
	 * @param  x the value of the specified point you want to calculate.
	 * @return the value of x in the monom.
	 */
	@Override
	public double f(double x) {
		return _coefficient*Math.pow(x, _power);
	} 
	/**
	 * this function get Monom and check if is equal to the monom that we activate the function on him.
	 * @param a the monom 
	 * @return boolean true/false as needed.
	 */
	public boolean equal(Monom a) {
		if (this.get_coefficient()==0&&a.get_coefficient()==0) return true;
		return (this.get_coefficient()==a.get_coefficient()&&this.get_power()==a.get_power());
	}
	/**
	 * this function print the specifeid monom in this form a*x^b.
	 */
	public String toString () {//
		String st="";
		if (this.get_coefficient()==0) {
			st+= "0";
			return st;
		}
		if (this.get_power()==0) {
			st+=this.get_coefficient();
			return st;
		}
		else {
			st+= this.get_coefficient()+ "*x^" + this.get_power();
			return st;
		}
		
		
	}


}
