
public class example1{
	public static void main(String arg[]){
		Set s1=new Set();
		Set s2=new Set();
		s1.Add((double)2/3 ); 
		s1.Add((double)5/4 );
		s1.Add(1);
		s1.Add(2);
		s1.dump();
		s2.Add((double)2/3);
		s2.Add(2);
		Set s3=new Set();
		s3=s1.Union(s2);
		//s3=s1.Intersect(s2);
		System.out.println("Union s1 s2");
		s3.dump();
		//s2.Add(2);
		//Set s3 = new Set();
	}


}
