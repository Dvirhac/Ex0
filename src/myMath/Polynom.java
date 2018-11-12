package myMath;


import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.html.MinimalHTMLWriter;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Dvir Hacohen 311229488 && Yuval Amar 308522416
 *
 */
public class Polynom implements Polynom_able{
	private ArrayList<Monom> list;
	

	final Monom_Comperator monsort= new Monom_Comperator();
	public void sort () {
		list.sort(monsort);
	}
	/**
	 * The function receives a string
	 *The function knows whether it is standard or not.
	 *In addition it arranges the string if it is not in the proper form
	 * @param s thats represent a String.
	 */
	
	public Polynom(String s)  {
		list=new ArrayList<Monom>();
		if (s.length()==0) {
			//throw new IllegalArgumentException("u enter an empty polynom");
			Monom m = new Monom(0,0);
			list.add(m);
			return;
		}

		s = s.replaceAll(" ", ""); 
		s = s.replaceAll("X", "x");

		String[] s1=s.split("(?=[+-])");

		for (int i = 0; i < s1.length; i++) {
			double[] arr= createM(s1[i]);
			Monom m = new Monom(arr[0], (int)arr[1]);
			list.add(m);
		}

		this.noDup();
		list.sort(monsort);

	}


	/**
	 * this constactor bulid new arrays list of monom.
	 * 
	 */
	public Polynom() {		//defult constructor
		list=new ArrayList<Monom>();
	}
	/**
	 * this function copy from a polynom to the new polynom.
	 * this is deep copy.
	 * @param p the polynom we want to copy from.
	 */
	public Polynom(Polynom_able p) {		// copy constructor
		Polynom p1 = new Polynom();
		Iterator<Monom> it= p.iteretor();
		//Iterator<Monom> it= p1.list.iterator();
		this.list= new ArrayList<Monom>();
		while (it.hasNext()) {
			list.add(new Monom(it.next()));
		}
		this.noDup();
		list.sort(monsort);

	}
	/**
	 * this function calculate the value of any x in the polynom.
	 * the function pass over all the monom in the polynom.
	 * the function use the f function in the monom class.
	 * @param  x the value of the specified point you want to calculate.
	 * @return the value of x in the polynom.
	 */
	@Override
	public double f(double x) {
		double sum=0;
		Iterator<Monom> it= list.iterator();
		while (it.hasNext()) {
			sum=sum+it.next().f(x);
		}
		return sum;

	}
	/**
	 * this function add Polynom_able to a polynom then she call to funcion sort and nodup.
	 * @param Polynom_able that we want to add.
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> it= p1.iteretor();
		if (p1==this) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).set_coefficient(list.get(i).get_coefficient()*2);
			}
			return;
		}

		while (it.hasNext()) {
			Monom a=new Monom(it.next());
			list.add(a);
		}
		list.sort(monsort);
		this.noDup();

	}
	/**
	 * this function add monom to polynom.
	 * then the function call to sort .
	 * @param Monom  that we want to add to the polynom.
	 */
	@Override
	public void add(Monom m1) {
		for (int i=0;i<list.size();i++) {
			if (m1.get_power()==list.get(i).get_power()) {
				list.get(i).set_coefficient(list.get(i).get_coefficient()+m1.get_coefficient());
				list.sort(monsort);
				return;
			}
		}

		list.add(m1);
		this.noDup();
		list.sort(monsort);
	}
	/**
	 * this function compute the subtraction between tow polynoms.
	 * the function changed the coefficient of the monom in the polynom that we get and to minus coefficient by mutply all
	 * the monom with monom with coefficient -1.
	 * ths function change the polynom that we operate the function on him.
	 * @param Polynom_able that we want to subtract.
	 */
	public void substract(Polynom_able p1) {
		if (p1==this) {
			this.list.clear();
			Monom m = new Monom(0,0);
			list.add(m);
			return;
		}
		Iterator<Monom> it= p1.iteretor();
		Monom m= new Monom(-1,0);
		while (it.hasNext()) {
			it.next().multiply(m);
		}
		this.add(p1);
		list.sort(monsort);
		this.noDup();

	}
	/**
	 * this function multiply between tow polynoms.
	 * this function change the polynom that we operate the function on him.
	 * * @param Polynom_able that we want to multiply.
	 * 
	 */
	@Override
	public void multiply(Polynom_able p1) {
		ArrayList<Monom> temp1=new ArrayList<Monom>();	
		for (int i = 0; i < list.size(); i++) {
			Monom m = list.get(i);
			Iterator<Monom> it=p1.iteretor();
			while(it.hasNext()) {
				Monom c=new Monom(m);
				c.multiply(it.next());
				temp1.add(c);
			}

		}
		this.list.clear();
		list.addAll(temp1);
		list.sort(monsort);
		this.noDup();
	}
	/**
	 * this function get Polynom_able and check if is it equal to the polynom we operate the function on him.
	 * the function pass over all the monom in both polynoms and check if the the power are the same and then the coefficient.
	 * the function use the equal function from the class monom.
	 * @return boolean true/false in accordance.

	 */
	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> it	= p1.iteretor();
		Iterator<Monom> it1	= this.iteretor();
		while (it.hasNext() && it1.hasNext()) {
			if (it.next().equal(it1.next())== false)
				return false;
		}
		if (it.hasNext()==false&&it1.hasNext()==true) return false;
		if (it.hasNext()==true&&it1.hasNext()==false) return false;
		return true;

	}
	/**
	 * this function check if all the coefficient in the polynom are zero or the polynom is empty.
	 * 
	 */
	@Override
	public boolean isZero() {
		if (list.size()==0) throw new IllegalArgumentException("u enter an empty polynom");
		// TODO Auto-generated method stub
		for (int i=0;i<list.size();i++) {
			if (list.get(i).get_coefficient()!=0)
				return false;
		}
		return true;
	}
	/**
	 * this function compute the root of the polynom.
	 * in this function we get help from https://www.geeksforgeeks.org/program-for-bisection-method/.
	 * @param x0 double the x0 of the start.
	 * @param x1 double x1 of the end.
	 * @param eps step (positive) value.
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		double mid=x0;
		while((x1-x0)>=eps) {
			mid=(x0+x1)/2;
			if(this.f(mid)==0) return mid;
			else if(this.f(x0)*this.f(mid)<0) {
				x1=mid;
			}else {
				x0=mid;
			}


		}
		return mid;
	}
	/**
	 * create a deep copy of this Polynom
	 * @return 
	 */
	@Override
	public Polynom_able copy() {
		Iterator<Monom> it= list.iterator();
		Polynom_able p1= new Polynom();
		while (it.hasNext()) {
			p1.add(new Monom(it.next()));
		}
		return p1;
	}
	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 * @return Polynom_able that is the  derivative.
	 */

	@Override
	public Polynom_able derivative() {
		Polynom_able p = new Polynom();	
		Iterator<Monom> it=this.iteretor();
		while(it.hasNext()) {
			Monom a=it.next();
			a.derivative();
			p.add(a);
		}
		this.noDup();
		return p;
	}

	@Override
	/**
	 * /**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * we use this site:https://www.bluffton.edu/homepages/facstaff/nesterd/java/riemannsums.html to check our result.
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */

	//add source!!!
	public double area(double x0, double x1, double eps) {
		double sum=0;
		for (double i = x0; i <x1; i+=eps) {
			sum=sum+(this.f(i)*eps);
		}
		return sum;
	}

	@Override
	public Iterator<Monom> iteretor() {
		return list.iterator();
	}


	/**
	 * noDup is combining all the Monoms with the same power
	 * in addition, is removing all the Monoms which '0' as coefficient.
	 */
	private void noDup() {
		
		for (int i=0;i<list.size()-1;i++) {
			for (int j=i+1;j<list.size();j++) {
				if (list.get(i).get_power()==list.get(j).get_power()){
					list.get(i).set_coefficient(list.get(i).get_coefficient()+list.get(j).get_coefficient());
					list.remove(j);
					j--;
				}
			}

		}
		for (int i=0 ; i<list.size() ; i++) {
			if (list.get(i).get_coefficient()==0)
				list.remove(i);		
		}
		
	}
	/**
	 * the function return string which represents a polynom 
	 */
	public String toString () {
		Iterator<Monom> it= this.iteretor() ;
		String st="";
		if (it.hasNext()) {
			Monom m1 = new Monom (it.next());
			if (m1.get_power()==0) {
				st+=m1.get_coefficient() + " ";
			}

			else {
				if (m1.get_coefficient()==1) {
					st+= "x^" + m1.get_power();
				}
				else if (m1.get_coefficient()==-1) {
					st+= "-x^" + m1.get_power();
				}
				else 
					st+= m1.get_coefficient() + "x^" + m1.get_power();
			}
		}
		else {
			return " The polynom is empty";
		}
		while (it.hasNext()) {
			Monom m= new Monom(it.next());
			double con= m.get_coefficient();
			int pow= m.get_power();
			if (pow>0) {
				if (con==1) {
					st+= " + x^" + pow+ " ";
				}
				if (con==-1) {
					st+= "- x^" + pow+ " ";
				}if (con>0 && con!=1) {
					st+= " + " +con+"*x^"+ pow + " ";
				}
				if (con<0&&con!=-1) {
					st+=+ con + "*x^"+ pow + " ";
				}
			}


		}
		return st;
	}
	/**
	 * 
	 * @param st 
	 * the createM is given a String which represents a single Monom from the total string.
	 * create double[] arr and puts in the arr[0] the coefficient, and in the arr[1] the power.
	 * @return the arr back to the Polynom constructor to easly make the polynom.
	 */
	private double[]  createM (String st) {
		double [] arr= new double [2];
		double x=0;
		int y=0;
		if (st.contains("*")) st= st.replace("*", "");
		if (st.charAt(0)!='+'&& st.charAt(0)!='-') {// first
			if (st.contains("x")==false) {
				arr[0]= Double.parseDouble(st);
				arr[1]= 0;
				return arr;
			}
			if (st.contains("^")==false) {// doest have "^"
				if (st.charAt(0)!= 'x') {
					st= st.replaceAll("x", "");
					x=Double.parseDouble(st);
					y=1;
					arr[0]= x;
					arr[1]= y;
					return arr;
				}
				else {
					arr[0]= 1;
					arr[1]= 1;
					return arr;
				}
			}
			else {
				if (st.charAt(0)!= 'x') {
					st =  st.replace("^", "");
					String [] s= st.split("x");
					x=Double.parseDouble(s[0]);
					y=Integer.parseInt(s[1]);
					arr[0]= x;
					arr[1]= y;
					return arr;
				}
				else {
					st = st.replace("x", "");
					st = st.replace("^", "");
					arr[0]= 1;
					arr[1]= Integer.parseInt(st);
				}
			}
		}
		// not first
		else {
			if (st.contains("^")==false) {
				if (st.contains("x")==false) {

					arr[0]= Double.parseDouble(st);
					arr[1]= 0;
					return arr;
				}
				st = st.replace("x", "");
				if (st.length()==1){
					if (st.charAt(0)=='-') {
						arr[0]= -1;
						arr[1] = 1;
						return arr;
					}
					else {
						arr[0] = 1;
						arr[1]= 1;
						return arr;
					}
				}
				else {
					arr[0]= Double.parseDouble(st);
					arr[1]= 1;
					return arr;
				}
			}
			else {
				st = st.replace("^", "");
				String [] s= st.split("x");;
				if (s[0].length()==1) {
					if (s[0].charAt(0)=='-') {
						arr[0]= -1;
						arr[1]= Integer.parseInt(s[1]);
						return arr;
					}
					else {
						arr[0]= 1;
						arr[1]= Integer.parseInt(s[1]);
						return arr;
					}
				}
				else {
					arr[0]= Double.parseDouble(s[0]);
					arr[1]= Integer.parseInt(s[1]);
					return arr;
				}
			}
		}
		return arr;
	}
}
