package myMath;

import java.util.ArrayList;
import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	public int compare(Monom x, Monom y) {
		if (x.get_power()==y.get_power()) {
			if (x.get_coefficient()==y.get_coefficient())
				return 0;
			else if 
			(x.get_coefficient()>y.get_coefficient())
				return 1;
			return -1;


		}
		if (x.get_power()>y.get_power())
			return 1;
		return -1;

	}

	// ******** add your code below *********

}
