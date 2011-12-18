#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>
#include <gmpxx.h>
#include <math.h>

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
	if(n==2) return 1; //2 is our special case prime
	if(n<2)return 0; //Ensure we don't get a call like bruteisprime(1);
	if(n%2==0)return 0; // divides by 2 (only 2 satisfy this as a prime)
	for(int i=3;i<n;i+=2){ // We only need to increment by 2 if we're testing from 3, as all primes but 2 are odd
		if(n%i == 0) return 0; //Not a prime
	}
	
	return 1;
}
int isprime(int n){
	//First test that n%firstprimes[i]!=0
	//for(int i=0;i<10000;i++){
	//	if(n%firstprimes[i]==0) return 0; //Not a prime
	//}
	//Then preform thermat's little test
	//is p is prime then, given a positive integer a
	//a^p equiv a (mod p)
	long int pwr=pow(2,n);
	//cout << "PWR:" <<pwr <<"\n";

	if ( (pwr-2) % n == 0){
		return 1;
	}
	return 0; //We suspect this isn't a prime...
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
	//isprime(9);
	
	for(int i=2;i<=100;i++){
		if(isprime(i)){
			cout << i << " is a prime \n";
		}
		else cout << i << " is not a prime \n";
	}
	cout << "\n";
	return 0;
}
