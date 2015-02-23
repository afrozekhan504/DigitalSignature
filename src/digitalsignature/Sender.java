/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package digitalsignature;

/**
 *
 * @author Aroze Khan
 */
public class Sender {
    private static int rol(int n, int t)
	 {
       	 return (n << t) | (n >>> (32 - t));
      	 }
public String encode(String str)
	{
        int i;
       	byte[] byt = str.getBytes();
  	int[] p = new int[(((byt.length + 8) >> 6) + 1) * 16];
	for(i = 0; i < byt.length; i++)
            {
       	     p[i >> 2] |= byt[i] << (24 - (i % 4) * 8);
            }
        p[i >> 2] |= 0x80 << (24 - (i % 4) * 8);
     	p[p.length - 1] = byt.length * 8;
        int[] w = new int[80];
        int a =  1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d =  271733878;
        int e = -1009589776;
        for(i = 0; i < p.length; i += 16)
                {
           	 int H1 = a;
           	 int H2 = b;
           	 int H3 = c;
           	 int H4 = d;
           	 int H5 = e;
 	         for(int j = 0; j < 80; j++)
			{
     		        w[j] = (j < 16) ? p[i + j] :( rol(w[j-3] ^ w[j-8] ^ w[j-14] ^ w[j-16], 1) );
               		int t = rol(a, 5) + e + w[j] +( (j < 20) ?  1518500249 + ((b & c) | ((~b) & d)): (j < 40) ?  1859775393 + (b ^ c ^ d): (j < 60) ? -1894007588 + ((b & c) | (b & d) | (c & d)): -899497514 + (b ^ c ^ d) );
                	e = d;
               		d = c;
                	c = rol(b, 30);
                	b = a;
                	a = t;
              		}
                a = a + H1;
                b = b + H2;
                c = c + H3;
                d = d + H4;
                e = e + H5;
         	}
        String hex1 = Integer.toHexString(a);
        String hex2 = Integer.toHexString(b);
        String hex3 = Integer.toHexString(c);
        String hex4 = Integer.toHexString(d);
        String hex5 = Integer.toHexString(e);
        String hex=hex1+hex2+hex3+hex4+hex5;
return(hex);
    	}
int gcd(int b,int y)
		{
		  while(b!=y)
			  {
			if(b>y)b=b-y;
			else y=y-b;
			  }
		  return b;
		}
String encrypt(String s)
		{
                int p,q,n,k,len,phi,d,e,i;
                int[] x=new int[100];
                char [] s1;
                char [] s2;
                int[] M=new int[100];
                int[] C=new int[100];
                s1=s.toCharArray();
		len=s1.length;
		for(k=0;k<len;k++)
			{
			M[k]=1;
			C[k]=1;
			}

		p=31;q=43;
		n=p*q;
		phi=(p-1)*(q-1);
		i=2;
		while((gcd(phi,i))!=1)
			{
			i++;
			}
		e=i;
	  	i=1;
		while(true)
		{
			if(i*e%phi==1)
				break;
			else
				i++;
		}
		d=i;
		for(k=0;k<len;k++)
			{
			x[k]=(int)s1[k]-96;
			}
		for(k=0;k<len;k++)
			{
			for(i=0;i<e;i++)
  				{
				C[k]=C[k]*x[k]%n;
				}
			}
		for(k=0;k<len;k++)
			{
  			C[k]=C[k]%n;
			}
		int[] st=new int[1024];
		System.out.println("The cipher text is");
		for(k=0;k<len;k++)
			{
			st[k]=C[k]+96;
			//System.out.print(C[k]+96);
			}
                String str1;
		String str2="";
		for(i=0;i<len;i++)
			{
			str1=new Integer(st[i]).toString();
			str2=str2+str1;
			}
		return(str2);
		}

}
