#!/usr/bin/python

import sys
#import and init pygame
import pygame # imports stuff you need to draw shapes etc
import time;  # imports stuff for stop-timer 
import random;# imports stuff to make random numbers
import math
pygame.init()

width=800
height=800
last=100000
update=True
output_image="NumbersWith2PrimeFactors.png"

window = pygame.display.set_mode((width, height))
#
#   The simplest primality test 
#   (will fail if you call: is_prime_brute(3.0)
#
def is_prime_brute(p):
    if (p==2): return True;
    if (p==3): return True;
    if (p < 2): return False;
    if (float(p)/float(2) == p/2):
        return False; # Even number

    #print "Testing now";
    max=int(math.sqrt(p))+1
    for i in range(3,max,2):
        if( float(p)/float(i) == p/i):
            #print ("{0} is not a prime and i have {1} to prove is".format(p,i))
            return False
     #print(i);

    return True;

#
# translate to center at (0,0)
#
def translate_coords(x,y):
    global window
    w,h=window.get_size()
    return (x+(w/2),y+(h/2))

#
# find all prime factors of n by recursive calls to self
#
def prime_factors(n):
    ret=[]
    for i in range(2,n): #Find the first factor

        if (float(n)/float(i) == n/i): #whole divisor
            if(is_prime_brute(i)):ret.append(i) #i is prime
            else: 
                for f in prime_factors(i):
                    ret.append(f)
            if(is_prime_brute(n/i)):ret.append(n/i) #n/i is prime
            else: 
                for f in prime_factors(n/i):
                    ret.append(f)
            break; #Should stop after first factor was found
    return ret;

             

def iterate_numbers():
    global window
    global last
    global update

    for i in range(0,last):
        if (not is_prime_brute(i)):
            factors=prime_factors(i)
            if (len(factors)==2):
                print i
                print factors
                print "-------------------"
                pygame.draw.circle(window,i,(factors[0],factors[1]),1)
                if(update): pygame.display.flip()
            

def main():
    global window
    global output_image
    iterate_numbers();
    #pygame.draw.circle(window,0xff0000,translate_coords(0,0),20);
    pygame.display.flip();
    pygame.image.save(window,output_image)
if __name__=='__main__': main()
time.sleep(1)
