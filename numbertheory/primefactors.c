#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

// very important unless you like to type a lot
using namespace std;
int isprime(int n){
	return 0;
}


void usage(){
	cout << "Usage : primefactors <number> \n";
	cout << "try to split a positive integer to it's prime factors \n";

}

string asbinary(unsigned long long int n){
	//Thanks:
	//http://www.fredosaurus.com/notes-cpp/expressions/2binbybitops.html
	string ret="";
	for (int i=63; i>=0; i--) {
            int bit = ((n >> i) & 1);
	    if (bit==1){
		ret.append("1");
	    }
	    else {
		ret.append("0");
		}
            //cout << bit;
        }
	return ret;
}

int isprime(unsigned long long int n){
	//loop over all integers from 2 to n
	//Note, this could be long, be better to implement this by first making a list of as many as feasible prime numbers
	//Then trying to divide n by that list, this has an advantage in that we can make the array of primes limited in range to - 
	//the most likely range on primes suitable for the problem

	//The way to do this should be the following:
	//* Test if n divides by the first 10,000 or so primes
	//* Apply Thermat's little theorem r=2^{p-1} mod (p), if r!=1 it's a composite
	//* Preform other tests like Rabin-Miller

	//Very temporary:
	for(unsigned long long int i = 2; i<n ; i++){
		if( (n%i) == 0) return 0;
	}


	return 1;

}

void dump_primes(unsigned long long int s,unsigned long long int e){
//Dumps all the prime numbers in range (s,e)
	for(unsigned long long int i=s;i < e;i++){
		if(isprime(i)){
			cout << i << " bin:";
			string bin=asbinary(i);
			cout << bin;
			cout << "\n";
		}
	}


}

int main(int argc,char ** argv){
	dump_primes(2,10000000);
}
