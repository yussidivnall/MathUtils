#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

bool bitbucket[64];
int bitchance[64];
int firstprimes[10000];

using namespace std;

void dumpfirstprimes(){
	for (int i=0;i<=10000;i++){
		cout << firstprimes[i] << "\n";
	}
}


int bruteisprime(int n){
	if(n==2) return 1;
	if(n%2==0)return 0; // divides by 2 (only 2 satisfy this as a prime)
	for(int i=3;i<n;i+=2){ // We only need to increment by 2 if we're testing from 3, as all primes but 2 are odd
		if(n%i == 0) return 0; //Not a prime
	}
	return 1;
}


void populatefirstprimes(){
	firstprimes[0]=2;
	firstprimes[1]=3;
	int primeindex=2;
	int test=5;
	while (primeindex <=10000){
		if(bruteisprime(test)){
			firstprimes[primeindex]=test;
			primeindex++;
		}
		test+=2;
	}	
}


void init(){
	memset(firstprimes,0,sizeof(firstprimes));
	memset(bitbucket,false,sizeof(bitbucket));
	memset(bitchance,0,sizeof(bitchance));
	//Creates a list of first 10,000 primes - TO FINISH!
	populatefirstprimes();
}


int main(int argc,char ** argv){
	init();
	dumpfirstprimes();
	/*
	int somenumber=23;
	if(bruteisprime(somenumber)) cout << somenumber << " is prime \n";
	else cout << somenumber << " isn't a prime \n";
	bool *abit;
	for (int i=sizeof(int)*4; i >=0;i--){
		int bit= ((somenumber >> i)& 1);
		
		cout << i << " " << bit <<"\n";
		//cout << bit;
	}
	*/
	cout << "\n";
	//memcpy(abit,somenumber[2],1);
	return 0;
}
