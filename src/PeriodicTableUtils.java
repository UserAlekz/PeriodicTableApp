/**
 * This class provides various utility methods for the Periodic Table:
 * conversion between Celsius/Fahrenheit/Kelvin temperature systems
 */
public class PeriodicTableUtils {
	public static double C2F(double tC)
	{
		return (tC - 32) * 9/5; //1.8
	}
	
	public static double F2C(double tK)
	{
		return (tK * 5/9) + 32;
	}
	
	public static double C2K(double tC)
	{
		return tC + 278;
	}
	
	public static double K2C(double tK)
	{
		return tK - 278;
	}
	
	public static double F2K(double tF)
	{
		return C2K(F2C(tF));
	}
	
	public static double K2F(double tK)
	{
		return C2F(K2C(tK));
	}
}
