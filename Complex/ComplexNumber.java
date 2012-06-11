//import java.lang.math.*;
public class ComplexNumber{
	public Double RealPart;
	public Double ImaginaryPart;
	public ComplexNumber(Double real, Double imaginary){
		RealPart=real; ImaginaryPart=imaginary;
	}
	//public ComplexNumber(int real, int im){
	//	this = new ComplexNumber(new Double(real), new Double(im));
	//}
	public void print(){
		if (ImaginaryPart>=0)
		System.out.println(""+RealPart+"+"+ImaginaryPart+"i");
		else System.out.println(""+RealPart+""+ImaginaryPart+"i");
	}
	public void printPolarForm(){
		System.out.println(PolarForm());
	}

	public String PolarForm(){
		Double magnitude=Math.sqrt(Math.pow(RealPart,2) + Math.pow(ImaginaryPart,2));
		Double Theta=Math.atan(ImaginaryPart/RealPart);
		String ret=magnitude+"(cos("+Theta+") + isin("+Theta+"))";
		return ret;
	}
	public ComplexNumber add(ComplexNumber c){
		Double real=this.RealPart+c.RealPart;
		Double imaginary=this.ImaginaryPart+c.ImaginaryPart;
		ComplexNumber ret = new ComplexNumber(real,imaginary);
		return ret;
	}
	public ComplexNumber multiplyBy(ComplexNumber c){
		//using: (a+ib)(c+id)=ac-bd+i(ad + bc)
		Double re=((this.RealPart * c.RealPart) - (this.ImaginaryPart * c.ImaginaryPart));
		Double im=((this.ImaginaryPart*c.RealPart) + (this.RealPart * c.ImaginaryPart));
		return new ComplexNumber(re,im);
	}
	public ComplexNumber conjugate(){
		ComplexNumber ret = new ComplexNumber(this.RealPart,-this.ImaginaryPart);
		return ret;
	}
	public ComplexNumber divideBy(ComplexNumber c){
		ComplexNumber denumerator=c.multiplyBy(c.conjugate());
		ComplexNumber numerator=this.multiplyBy(c.conjugate());

		ComplexNumber ret = new ComplexNumber(numerator.RealPart/denumerator.RealPart, numerator.ImaginaryPart/ denumerator.RealPart);
		return ret;
	}
	

}
