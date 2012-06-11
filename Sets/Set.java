import java.util.*;
//Incomplete! Handle's simple Set operations
//Note, this uses Vectors, one for each type of elements.
//It doesn't check for dumplicates, and a Union operation creates a duplicate(Bug)
//
//
//
public class Set{
	//Set of what type of elements?
	int SETTYPE_INTS=1;
	int SETTYPE_RATIONALS=2;
	int SETTYPE_IRRATIONALS=4;
	int SETTYPE_WORDS=8;
	public int type_flags=0;

	final int TYPE_UNSPECIFIED=-1;
	final int TYPE_INTEGER=0;
	final int TYPE_RATIONAL=2;
	final int TYPE_REAL=4;
	final int TYPE_COMPLEX=8;
	final int TYPE_SYMBOLIC=16;
	public int type=TYPE_UNSPECIFIED;

	AbstractSet set;
	Vector vec;
	String description; // Human redable description such as "x in setZ^+ ; x is prime "

	public Vector<Integer> MembersOfSetZ = new Vector<Integer>(); // Stores the integers
	public Vector<Double> MembersOfSetQ = new Vector<Double>(); // Stores rationals (Maybe for the future i should have a class for rationals, st R(2/3)=R(1.5)
	public Vector<Double> MembersOfSetC = new Vector<Double>(); // Stores complex numbers here...
	public Vector<String> MembersOfWords = new Vector<String>();


	//Initilize as a set of integers
	public Set(int setZ[]){
		type_flags=TYPE_INTEGER
		for (int i=0;i <= setZ.length;i++){
			MembersOfSetZ.add(setZ[i]);
		}
	}
	public Set(int set_type){
		type=set_type
	}
	public void Add(int element){
		
		type_flags=(type_flags | SETTYPE_INTS);
		MembersOfSetZ.add(element);
	
	}
	public void Add(Double element){
		type_flags=(type_flags | SETTYPE_RATIONALS);
		MembersOfSetQ.add(element);
	}
	public void Add(String word){}

	public Set Intersect(Set B){
		Set ret = new Set();
		for (Double a: MembersOfSetQ){
			for(Double b:B.MembersOfSetQ){
				if ((double)a==(double)b){
					ret.Add(a);
				}
			}

		}


		for (Integer a: MembersOfSetZ){
			for(Integer b:B.MembersOfSetZ){
				if ((int)a==(int)b){
					ret.Add(a);
				}
			}
		}
		//TODO Other sets 
		return ret;
	}
	public Set Union(Set B){
		Set ret = new Set();
		for (Integer ai: MembersOfSetZ){
			ret.Add(ai);
		}
		for (Integer bi:B.MembersOfSetZ){
			ret.Add(bi);
		}
		for (Double aq: MembersOfSetQ){
			ret.Add(aq);
		}
		for (Double bq:B.MembersOfSetQ){
			ret.Add(bq);
		}
		//TODO Other Sets
		return ret;
	}
	public void SetCycle(Set cycle){}

	//TODO ALL OF THIS	
	public boolean is_subset(Set b){ return false;}
	public boolean is_proper_subset(Set b){return false;}
	public void setDescription(String desc){
		description=desc;
	}
	public void dump(){
		if ( (type_flags | SETTYPE_INTS)==type_flags){
			//System.out.println("dumping ints");
			for(Integer I: MembersOfSetZ){	
				System.out.println(I);
			}
		}


		if ( (type_flags | SETTYPE_RATIONALS)==type_flags){
			//System.out.println("dumping reals");
			for(Double I: MembersOfSetQ){	
				System.out.println(I);
			}
		}

		




	}
	public void dbg(String msg){
		System.out.println(msg);

	}
}

