public class Main
{
	public static void main(String[] args)
	{
		int n;
		for (int i=0;i<args.length;i++)
		{
			if (args[i].charAt(0)=='1' || args[i].charAt(0)=='2' || args[i].charAt(0)=='3' || args[i].charAt(0)=='4' || args[i].charAt(0)=='5' || args[i].charAt(0)=='6' || args[i].charAt(0)=='7' || args[i].charAt(0)=='8' || args[i].charAt(0)=='9' || args[i].charAt(0)=='0')
			{
				try
				{
					n=Integer.parseInt(args[i]);
					System.out.println(RzymArab.arab2rzym(n));
				}
				catch (RzymArabException ex)
				{
					System.out.println(ex.getMessage());
					return;
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Nieprawidlowe Dane");
					return;
				}
			}
			else
			{
				try
				{
					System.out.println(RzymArab.rzym2arab(args[i]));
				}
				catch (RzymArabException ex)
				{
					System.out.println(ex.getMessage());
					return;
				}
			}
		}
	}
}