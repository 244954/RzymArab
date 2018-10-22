package binaryconvert;

public class Convert {

  public Convert() {
    
  }
  
  public String dectobin(int n) throws GUIException {
	  String a = "";
	  if (n<0)
		  throw new GUIException("Liczba ujemna");
	  while (n>0)
	  {
		  if (n % 2 == 0)
			  a+="0";
		  else
			  a+="1";
		  n /= 2;
	  }
	  if (a=="")
		  return "0";
	  else
	  return new StringBuffer(a).reverse().toString();
  }
  
  public int bintodec (String n) throws GUIException {
	  for (int i=0;i<n.length();i++)
	  {
		  if (n.charAt(i) == '0' || n.charAt(i) == '1')
		  {
			  
		  }
		  else
			  throw new GUIException ("Nieprawidlowa liczba binarna");
	  }
	  int b=n.length();
	  int c=1;
	  if (n.charAt(0) == '0' && b>1)
		  throw new GUIException ("Wpisz jedynke na poczatku, nie chce mi sie tego obslugiwac");
	  if (b>32)
		  throw new GUIException ("Za duza liczba");
	  
	  int a=0;
	  
	  for (int i=b-1;i>=0;i--)
	  {
		  if (n.charAt(i) == '1' )
		  {
			  a+=c;
		  }
		  c*=2;
	  }
	  return a;
  }
}
