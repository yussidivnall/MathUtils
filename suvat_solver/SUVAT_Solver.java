//package SUVAT_Solver;
import java.util.*;
public class SUVAT_Solver{
	//v=u+at
	//s=(1/2)(u+v)t
	//s=u+(1/2)vt^2
	//s=v-(1/2)ut^2
	//v^2=u^2+2as
	//a=(v-u)/t
	public class Variables{
		double g=-9.81;
		Double s;
		Double u;
		Double v;
		Double a;
		Double t;
		Variables(){}

	}
	Variables vars;
	public void calculate(){
		if(vars.u!=null && vars.a!=null && vars.t!=null){
			vars.v=new Double(vars.u+vars.a*vars.t);
			vars.s=new Double(vars.v-(1/2)*(vars.u)*(vars.t*vars.t));
		}
	}
	SUVAT_Solver(){
		vars=new Variables();
	}
	public void setAcceleration(double a){vars.a=new Double(a);}
	public void setInitialVelocity(double u){vars.u=new Double(u);}
	public void setFinalVelocity(double v){vars.v=new Double(v);}
	public void setTime(double t){vars.t=new Double(t);}
	public static void main(String args[]){
	}

}
