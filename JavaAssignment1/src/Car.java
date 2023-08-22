import java.util.Scanner;
//Using Exception class so as to handle error if user enter wrong message or details
public class Car 
{
	static class myexception extends Throwable
	{
		public String prob;
		public myexception(String msg) 
		{
			prob = msg;
		} 
		public void showprob() 
		{
			System.out.println(prob);
		}
	}
//Made use of Car detail class so as to make car details enter into this class 
	static class car_details 
	{
		public String c_type, insurance_type;
		public double c_cost;
		public int c_model;
		public double insurance_c; 
		public car_details(int model, String cartype, double carprice, String insurancetype)
		{
			c_type = cartype;
			c_model = model;
			insurance_type = insurancetype;
			c_cost = carprice;
		} 
		public void calculate_insurance() 
		{
			if (insurance_type.equals("Premium"))
			{
				
				
				if (c_type.equals("Hatchback")) 
				{
					insurance_c = (5 * c_cost) / 100; 
				}
				else if (c_type.equals("Sedan"))
				{
					insurance_c = (8 * c_cost) / 100;
				} 
				else if (c_type.equals("SUV"))
				{
					insurance_c = (10 * c_cost) / 100;
				} 
				insurance_c = (20 * insurance_c) / 100 + insurance_c;
				} 
				else if (insurance_type.equals("Basic")) 
				{
				if (c_type.equals("Hatchback"))
				{
					insurance_c = (5 * c_cost) / 100; 
				}
				else if (c_type.equals("Sedan")) 
				{
					insurance_c = (8 * c_cost) / 100;
				}
				else if (c_type.equals("SUV")) 
				{
					insurance_c = (10 * c_cost) / 100;
				}
			}
		}
	} 
//Main method 
	public static void main(String[] args)
	{ 
		char isanothercar = 'y';
		while (isanothercar == 'y')
		{ 
	try 
{
String cartype, insurancetype;
double carcost;
int carmodel;
Scanner sc = new Scanner(System.in); 
carmodel = sc.nextInt();
cartype = sc.next();
carcost = sc.nextDouble();
insurancetype = sc.next();
car_details obj = new car_details(carmodel, cartype, carcost, insurancetype);
if (cartype.equals("Hatchback") || cartype.equals("Sedan") || cartype.equals("SUV")) 
{ 
	if (insurancetype.equals("Basic") || insurancetype.equals("Premium"))
	{ 
		obj.calculate_insurance();
System.out.println("Car_model : " + obj.c_model);
System.out.println("Car_type : " + obj.c_type);
System.out.println("Car_price : " + obj.c_cost);
System.out.println("Insurance type : "+ obj.insurance_type);
System.out.println("The actual amount to paid : " + obj.insurance_c);
} 
	else 
	{ 
		throw new myexception("Insurance type is not valid");
	}
} 
else 
{ 	
	throw new myexception("Car type is not valid");
}
} 
	catch (myexception errmsg)	
	{
		errmsg.showprob();
	}
System.out.println("Do you want to enter details of any other car (y/n):");
Scanner sc = new Scanner(System.in);
isanothercar = sc.next().charAt(0);
			} 
		}
	}

