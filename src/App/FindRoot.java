package App;



public class FindRoot {
	
	
	public double firstRoot(double coefficients[], double initial,double max,double keq)
	{
		double x = initial;
		boolean control = true;
		double tolerance =calTol(keq);
		Long initTime = System.currentTimeMillis();
		while(control&&x<=max)
		{
			
			if(System.currentTimeMillis()>=initTime+900) {
				tolerance = lowerTol(tolerance);
				x = initial;
				initTime = System.currentTimeMillis();
			}
			double value = calculate(coefficients,x);
			if(value<=tolerance&&value>=-tolerance)
			{
				
				return x;
			}
			x+=0.000001;
		}
	
		return 0;
	}
	public double calculate(double coeff[],double x)
	{
		double x4 = coeff[0]*Math.pow(x, 4);
		double x3 = 0;
		double x2 = coeff[2]*Math.pow(x, 2);
		double x1 = coeff[3]*x;
		double constant = coeff[4];
		return x4+x3+x2+x1+constant;
	}
	public double calTol(double k)
	{
		if(k>100000)
		{
			return 0.1;
		}
		else if(k>10000)
		{
			return 0.01;
		}
		
		else if(k>1000)
		{
			return 0.001;
		}
		else if(k<1000) {
			return 0.0001;
		}
		return 1;
	}
	public double lowerTol(double currT)
	{
		return currT*10;
	}

}
