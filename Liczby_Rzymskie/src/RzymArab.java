public class RzymArab 
{
	private static String[] liczby = { "I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M" };
	public static int rzym2arab (String rzym) throws RzymArabException 
	{
		for (int i=0;i<rzym.length();i++)
		{
			if (rzym.charAt(i)!='I' && rzym.charAt(i)!='V' && rzym.charAt(i)!='X' && rzym.charAt(i)!='L' && rzym.charAt(i)!='C' && rzym.charAt(i)!='D' && rzym.charAt(i)!='M')
			{
				throw new RzymArabException ("Nieprawidlowe Dane");
			} 
		}
		int curr=12; // aktualnie najwyzsza cyfra rzymska
		int suma=0; // no suma

		rzym+='A'; // dla ochrony przed bledami (wykraczanie poza zasieg)
		rzym+='A';
		String temp;	
		int help=0; // jeden pomocniczy	
		int i=0; // gdzie jestesmy na stringu

		while (i<rzym.length()-2 && curr>=0)
		{
			temp="";
			if (curr%2==1)
			{
				temp+=rzym.charAt(i);
				temp+=rzym.charAt(i+1);
				if (temp.equals(liczby[curr]))
				{
					switch (curr)
					{
						case 11:
							curr-=4;
							suma+=900;
							break;
						case 9:
							curr-=2;
							suma+=400;
							break;
						case 7:
							curr-=4;
							suma+=90;
							break;
						case 5:
							curr-=2;
							suma+=40;
							break;
						case 3:
							curr-=4;
							suma+=9;
							break;
						case 1:
							curr-=2;
							suma+=4;
							break;
						default:
							throw new RzymArabException ("Niespodziewany Blad");
					}
					i+=2;
				}
				else
				{
					curr--;
				}
			}
			else
			if (curr%4==0) // te co moga wystepowac obok siebie
			{
				temp="";
				temp+=rzym.charAt(i);
				if (temp.equals(liczby[curr]))
				{
					i++;
					help=1;
					temp="";
					temp+=rzym.charAt(i);
					if (temp.equals(liczby[curr]))
					{
						i++;
						help=2;
						temp="";
						temp+=rzym.charAt(i);
						if (temp.equals(liczby[curr]))
						{
							i++;
							help=3;
						}
					}
					switch (curr)
					{
						case 12:
							suma+=(1000*help);
							break;
						case 8:
							suma+=(100*help);
							break;
						case 4:
							suma+=(10*help);
							break;
						case 0:
							suma+=(1*help);
							break;
						default:
							throw new RzymArabException ("Niespodziewany Blad");
					}
				}
				curr--;
			}
			else
			{
				temp+=rzym.charAt(i);
				if (temp.equals(liczby[curr]))
				{
					switch (curr)
					{
						case 10:
							curr-=2;
							suma+=500;
							break;
						case 6:
							curr-=2;
							suma+=50;
							break;
						case 2:
							curr-=2;
							suma+=5;
							break;
						default:
						throw new RzymArabException ("Niespodziewany Blad");
					}
					i++;
				}
				else
				{
					curr--;
					curr++;
					curr--;
				}
			}
		}
		if (rzym.charAt(i)!='A')
		{
			throw new RzymArabException ("To nie jest prawidlowo zapisana liczba rzymska");
		}
		return suma;
	}
	public static String arab2rzym (int arab) throws RzymArabException
	{
		if (arab>3999 || arab<1)
		{
			throw new RzymArabException ("Poza zakresem");
		}
		String m="";
		while (arab>=1000)
		{
			m+=liczby[12];
			arab-=1000;
		}
		while (arab>=900)
		{
			m+=liczby[11];
			arab-=900;
		}
		while (arab>=500)
		{
			m+=liczby[10];
			arab-=500;
		}
		while (arab>=400)
		{
			m+=liczby[9];
			arab-=400;
		}
		while (arab>=100)
		{
			m+=liczby[8];
			arab-=100;
		}
		while (arab>=90)
		{
			m+=liczby[7];
			arab-=90;
		}
		while (arab>=50)
		{
			m+=liczby[6];
			arab-=50;
		}
		while (arab>=40)
		{
			m+=liczby[5];
			arab-=40;
		}
		while (arab>=10)
		{
			m+=liczby[4];
			arab-=10;
		}
		while (arab>=9)
		{
			m+=liczby[3];
			arab-=9;
		}
		while (arab>=5)
		{
			m+=liczby[2];
			arab-=5;
		}
		while (arab>=4)
		{
			m+=liczby[1];
			arab-=4;
		}
		while (arab>=1)
		{
			m+=liczby[0];
			arab-=1;
		}
		return m;
	}
}
