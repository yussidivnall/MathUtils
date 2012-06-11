public class example{
	public static void main(String[] args){
		ComplexNumber a= new ComplexNumber(2.0,2.0);
		System.out.println("a:");
		a.print();
		//a.printPolarForm();
		System.out.println("b:");
		ComplexNumber b= new ComplexNumber(-2.0,3.0);
		b.print();
		
		//c=a*b
		System.out.println("a*b:");
		ComplexNumber c= a.multiplyBy(b);
		c.print();
		//a^2
		System.out.println("a^2:");
		a.multiplyBy(a).print();

		//Complex conjugate a
		System.out.println("complex cojugate:");
		a.conjugate().print();

		//a*bar{a}

		System.out.println("a*conjugate a:");
		a.multiplyBy(a.conjugate()).print();
		a.multiplyBy(a.conjugate()).printPolarForm();
		
		//a/b
		a.print();
		System.out.println("-----------");
		b.print();

		System.out.println("=");

                a.multiplyBy(b.conjugate()).print();
                System.out.println("-----------");
                b.multiplyBy(b.conjugate()).print();

		System.out.println("a/b");
		a.divideBy(b).print();
		
	}
}
