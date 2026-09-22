import java.util.Scanner;

public class LeakyBucket {

	public static int min(int a, int b)
	{
		if(a<b)
			return a;
		else
			return b;
	}

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int cap, oprt, nsec, cont, i=0,dr=0, x, res;
        int [] inp = new int [25];
        int ch;
    	System.out.println("\n\nLEAKY BUCKET ALGORITHM\n");
    	System.out.println("\nEnter bucket size :   ");
    	cap = sc.nextInt();
    	System.out.println("\nEnter output rate (no..of pkts/sec)  :  ");
    	oprt = sc.nextInt();

    	do{	
    		System.out.println("\nEnter the no..of packets entering at second:"+(i+1));
    		inp[i++] = sc.nextInt();
    		System.out.println("Enter 1 to insert packets or 0 to quit  :   ");
    		ch = sc.nextInt();
    	      }  while(ch==1);
    	            nsec=i;
    	System.out.println("\nSecond : Packets sent : Packets recvd : In bucket: Dropped\n");

    	for(cont=i=0;  (cont>0) || (i<nsec) ; i++)
    	{
    		System.out.print("    :"+(i+1));
    		System.out.print("     \t: "+inp[i]);
    		res = min(cont+inp[i],oprt);
    		System.out.print("     \t: "+res);
    		if((x=cont+inp[i]-oprt)>0)
    		{
    			if(x>cap)
    			{	
    				cont=cap;
    				dr=x-cap;
    			}
    			else
    			{	cont=x;
    				dr=0;
    			}
    		}
    		else
    		cont=0;
    		System.out.print("   \t\t:"+cont);
    		System.out.print("     \t"+dr+"\n");
    	}
	}
}




