public class Element {
//Element types
final int TYPE_UNSPECIFIED=-1;
final int TYPE_INTEGER=0;
final int TYPE_RATIONAL=2;
final int TYPE_REAL=4;
final int TYPE_COMPLEX=8;
final int TYPE_SYMBOLIC=16;

//represents an elements in a Set. In order to "cheat" i will use this to store one of Integer, Double, String,
//An alternative would be to use "Object" but this could cause type casting problems later.
public Integer iValue;
public Double dValue;
public String  sValue;
public int type=TYPE_UNSPECIFIED;

public Element(Set in){
	Element me=this;
	
}
public void setValue(int v){
	Integer iValue = new Integer(v);
	}
public void setValue(double v){
	//dValue
	}
}
