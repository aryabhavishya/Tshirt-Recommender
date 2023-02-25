package com.naehas.org;

import java.util.Comparator;

public class Sorting implements Comparator<Tshirt>{


	public int compare(Tshirt o1, Tshirt o2) {
		if(Tshirtdata.outputpreference.equals("PRICE"))
		{
			if(o1.getPrice()>o2.getPrice())
				return 1;
			else if (o2.getPrice()>o1.getPrice())
				return -1;
			return 0;
		}
		else if(Tshirtdata.outputpreference.equals("RATING"))
		{
			if(o1.getRating()<o2.getRating())
				return 1;
			else if(o2.getRating()<o1.getRating())
				return -1;
			return 0;
		}
		else if(Tshirtdata.outputpreference.equals("BOTH"))
		{
			if(o1.getPrice()==o2.getPrice())
			{
				if(o1.getRating()<o2.getRating())
					return 1;
				else
					return -1;
			}
			else if(o1.getRating()==o2.getRating())
			{
				if(o1.getPrice()<o2.getPrice())
					return 1;
				else
					return -1;
			}
		}
		return 0;
	}
}
