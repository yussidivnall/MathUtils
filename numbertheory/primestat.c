#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

bool bitbucket[64];
int bitchance[64];
int firstprimes[10000];

using namespace std;

void populatefirstprimes(){
	firstprimes[0]=2;
	firstprimes[1]=3;
	int primeindex=2;
	int test=4;
	while (primeindex <=10000){
		
		test++;
		primeindex++;
	}	
}


void init(){
	memset(firstprimes,0,sizeof(firstprimes));
	memset(bitbucket,false,sizeof(bitbucket));
	memset(bitchance,0,sizeof(bitchance));
	//Creates a list of first 10,000 primes - TO FINISH!
	firstprimes[0]=2;
	int lastprime=2;
	bool isprime=true;
	for(int primeindex=1;primeindex < 10000;primeindex++){
		for(int testnum=lastprime+1;;testnum++){
		isprime=true;
		cout <<" testing "<< testnum << "\n";
			for(int testprimeindex=0;testprimeindex <primeindex;testprimeindex++){
				int testprime=firstprimes[testprimeindex];
				cout << "does " << testnum << " divides by "<<testprime << "\n";
				cout << testnum%testprime << "\n\n";
				if( (testnum%testprime)==0){
					isprime=false;
					continue;
				}
			}
			if(isprime){
				firstprimes[primeindex]=testnum;
				cout << "is "<<testnum << " prime? "<<"\n";
			}
		}	
	}
}


int main(int argc,char ** argv){
	init();
	int somenumber=3;
	bool *abit;
	for (int i=sizeof(int)*4; i >=0;i--){
		int bit= ((somenumber >> i)& 1);
		
		cout << i << " " << bit <<"\n";
		//cout << bit;
	}
	cout << "\n";
	//memcpy(abit,somenumber[2],1);
	return 0;
}
