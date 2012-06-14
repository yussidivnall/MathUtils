public class Matrix{
	double matrix[][];

	Matrix(int r,int c){
		matrix=new double[r][c];
	}
	Matrix(double m[][]){
		matrix=m;
	}
	public void print(){
		for(int r=1;r<=get_height();r++){
			for(int c=1;c<=get_width();c++){
				System.out.print(get_entry(r,c)+"	");
			}
			System.out.println("|");
		}
	}


	public double get_entry(int r,int c){
		return matrix[r-1][c-1];
	}
	public void set_entry(int r,int c,double v){
		matrix[r-1][c-1]=v;
	}
	public double[][] get_matrix(){
		return matrix;
	}
	public int get_width(){
		//number of cols
		return matrix[0].length;
	}
	public int get_height(){
		//number of rows
		return matrix.length;
	}
	public Matrix get_column(int col){
		//To add: check bounds
		Matrix ret = new Matrix(get_height(),1);
		for(int r=1;r<=get_height();r++){
			ret.set_entry(r,1,get_entry(r,col));
		}
		return ret;
	}
	public Matrix get_row(int row){
		//To add: check bounds
		Matrix ret = new Matrix(1,get_width());
		for(int c=1;c<=get_width();c++){
			ret.set_entry(1,c,get_entry(row,c));
		}
		return ret;
	}
	public Matrix transpose(){
		Matrix ret=new Matrix(get_width(),get_height());
		for(int r=1;r<=get_height();r++){
			for(int c=1;c<=get_width();c++){
				ret.set_entry(c,r,get_entry(r,c));
			}
		}
		return ret;
	}


	
	public Matrix subtract_row(Matrix row,int row_index){
		//Subtract row from matrix at row_index
		if(row.get_height()!=1){
			System.out.println("this is more then one row");
			System.exit(1);
		}
		if(row.get_width()!=get_width()){
			System.out.println("Wrong width");
			System.exit(1);
		}
		Matrix ret = this;
		for(int c=1;c<=ret.get_width();c++){
			ret.set_entry(row_index,c,(ret.get_entry(row_index,c)-row.get_entry(1,c)));
		}
		return ret;
	}
	public Matrix get_identity(){
		int width=get_width();
		int height=get_height();
		if(test_square()!=0){
			System.out.println("Not a square matrix, can't get identify");
			System.exit(1);
		}
		Matrix ident=new Matrix(get_height(),get_width());
		//double ident[][]=new double[width][height];
		for(int i=1;i<=width;i++){
			for (int j=1;j<=height;j++){
				//ident[i][j]=0;
				ident.set_entry(j,i,0);	
			}
			ident.set_entry(i,i,1);
		}
		return ident;
	}
	public Matrix invert(){
		if(get_width()==2 && get_height()==2){
			return invert2X2();
		}else{
			System.out.println("Sorry only 2X2 matrices implemented so far");
			System.exit(1);
		}
		
		return null;
	}
	public Matrix invert2X2(){
		double det = get_entry(1,1) * get_entry(2,2) - get_entry(2,1) * get_entry(1,2);
		if(det == 0){
			System.out.println("Matrix appears to be uninvertible!");
			System.exit(1);
		}
		Matrix temp = new Matrix(2,2);
		temp.set_entry(1,1,get_entry(2,2));
		temp.set_entry(2,2,get_entry(1,1));
		temp.set_entry(1,2,-get_entry(1,2));
		temp.set_entry(2,1,-get_entry(2,1));
		return temp.multiply(1/det);
	}
	public Matrix join_identity(){
	//Returns the matrix with the Identity joined
	//used for Jordan-Gauss mathod of finding inverse
		Matrix ident = get_identity();
		Matrix ret = new Matrix(get_height(),get_width()*2);
		for(int r=1;r<=ret.get_height();r++){
			for(int c=1;c<=ret.get_width();c++){
				if(c<=get_width()){
					ret.set_entry(r,c,get_entry(r,c));
				}else{
					ret.set_entry(r,c,ident.get_entry(r,c-get_width()));
				}
			}
		}
		return ret;
	}
	public int test_jg(Matrix j){
	//Tests to see if matrix was inverted (if identity is at the left)
		Matrix ident = get_identity();
		for (int r = 1;r<=ident.get_height();r++){
			for(int c=1;c<=ident.get_width();c++){
				if(j.get_entry(r,c)!=ident.get_entry(r,c)){
					return 1;
				}
			}
		}
		return 0;
	}
	public Matrix inverse_jg(){
	//Inverse using Jordan Gauss Method
		Matrix ret = join_identity();
		
		return null;
	}

	//scalar multiplication
	public Matrix multiply(double n){
		Matrix ret=this;
		for(int r=1;r<=ret.get_height();r++){
			for(int c=1;c<=ret.get_width();c++){
				ret.set_entry(r,c,ret.get_entry(r,c)*n);
			}
		}
		return ret;
	}
	//matrix multiplication
	public Matrix multiply(Matrix B){
		Matrix A = this;
		if(test_multiplyable(A,B)!=0){
			System.out.println("Cannot multiply");
			System.exit(1);
		}
		Matrix ret = new Matrix(A.get_height(),B.get_width());
		for(int bc=1;bc<=B.get_width();bc++){
			for(int r=1;r<=A.get_height();r++){
				double v=0;
				for(int c=1;c<=A.get_width();c++){
					v+=A.get_entry(r,c)*B.get_entry(c,bc);
				}
				ret.set_entry(r,bc,v);
			}
		}
		return ret;
	}

	public int test_multiplyable(Matrix A,Matrix B){
		if(A.get_width()!=B.get_height())return 1;
		else return 0;
	}
	public int test_square(){
		if(get_width()!=get_height())return 1;
		else return 0;
	}





	// adds a multiple of src_row to dest_row (For simple row operations)
	public Matrix add_row(double multiple,int src_row,int dest_row){
		Matrix ret =this;
		Matrix src_matrix=this.get_row(src_row);
		for (int i=1; i<= ret.get_width();i++){
			ret.set_entry(dest_row,i, 
				ret.get_entry(dest_row,i)+ multiple*ret.get_entry(src_row,i));
		}
		return ret;	
		
	}

	//Takes a row and returns the column number of the first non-zero
	public int pivot_column(int row){
		Matrix r = this.get_row(row);
		for (int i=1; i <=get_width();i++){
			if(r.get_entry(1,i)!=0)return i;	
		}
		return -1;
	}
	
	//find pivot, and multiply all other elements by 1/pivot
	public Matrix make_leading_ones(){
		Matrix ret=this;
		for(int r=1;r<=ret.get_height();r++){ //Iterate over rows
			int pivot_index=ret.pivot_column(r);
			if(pivot_index==-1) continue;
			double multiple=1.0/(ret.get_entry(r,pivot_index));
			for (int c=pivot_index;c<=ret.get_width();c++){// Iteratre over columns starting with pivot
				double new_value=ret.get_entry(r,c) * multiple;
				ret.set_entry(r,c,new_value);
			}
			
		}
		return ret;
	}
	public Matrix rref(){
		Matrix ret=this;
		for (int src_row=1;src_row<=ret.get_height();src_row++){
			ret=ret.make_leading_ones();//Make row with a leading one after each iteration
			int src_pivot_index=ret.pivot_column(src_row);
			if (src_pivot_index==-1)continue;
			for(int dst_row=1;dst_row<=ret.get_height(); dst_row++){
				if (src_row==dst_row) continue; // Skip current row
				//This is a source of confusing, i am trying to eliminate source pivot in destination?
				//Not all that clear, basically the question is, where do i stop!
				double old_value=ret.get_entry(dst_row,src_pivot_index);
				if(old_value==0.0) continue;
				ret=ret.add_row(-old_value,src_row,dst_row);
			}
		}
		/*
		for(int i=1;i<=get_height();i++){
			int pivot_index=pivot_column(i);
			if(pivot_index==-1)continue;
			double pivot_value=get_entry(i,pivot_index);
			dbg("Pivot at "+pivot_index+" value is: "+pivot_value);	
		}*/
		return ret;
	}

	public static void dbg(String s){
		System.out.println(s);
	}
}

