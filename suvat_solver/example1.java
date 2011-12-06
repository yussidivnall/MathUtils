//import SUVAT_Solver.*;
import java.util.*;
public class example1{
	example1(){
		SUVAT_Solver solver=new SUVAT_Solver();
		solver.setInitialVelocity(0);
		solver.setAcceleration(-9.81);
		solver.setTime(111.2);
		solver.calculate();
		System.out.println("v="+solver.vars.v);
		System.out.println("s="+solver.vars.s);
		
	}
	public static void main(String args[]){
		example1 me = new example1();
	}
}
