//import java.util.string;
public class Primes{
	int upto=20000000;
	int[] getPrimes(int last){
	}		
	Primes(int first, int last){
		for (int i=first;i <= last;i++){
			//System.out.println("Checking if "+i+" is prime");
			boolean hasfactors=false;
			for (int z=2;z<i;z++){
				double division=(double)i/(double)z;
				double mod=(double)i % (double)z;
				//System.out.println(i+" / "+z);
				//System.out.format("mod: %f \n",mod);
				//System.out.format("=>  i / z= %f \n\n",division);
				if(mod == 0) {
					//System.out.println("Looks like "+i +" is divisible by "+ z);
					hasfactors=true;
					break;
				}
				
			}
			if(!hasfactors){
				System.out.println("It is" + i);
			}
			double p;
		}
	}
	public static void main(String[] args){
		
		Primes me = new Primes(2,200000);
	}
}
