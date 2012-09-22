#!/usr/bin/python
#Prints all numbers upto "last" which only have 2 prime factors
#Draws a chart, in which x,y are the prime factors
#
import sys
#import and init pygame
import pygame # imports stuff you need to draw shapes etc
import time;  # imports stuff for stop-timer 
import random;# imports stuff to make random numbers
import math
pygame.init()

width=800
height=800
last=100000 #last number to check
update=True #Update display (Will slow it down for large "last"
output_image="NumbersWith2PrimeFactors.png" #Image file name

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
    max=int(math.sqrt(p))+1 #Plus one to compensate for rounding down
    for i in range(3,max,2):
        if( float(p)/float(i) == p/i): #Found factors, not a prime
            return False
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

             
#
# Iterates over numbers from 0 to "last", 
# checks if these are made of 2 prime factors
# plot a point (Got to be a better way to do a pixel in pygame than a circle with radius 1)
# Output to terminal in a CSV format
# Update display if "update==true"
#
#@TODO figure out how to scale colours properly
#
def iterate_numbers():
    global window
    global last
    global update

    one_unit_colour=float (int(0xffffff)/last ) #Last colour / number of composites
    for i in range(0,last):
        if (not is_prime_brute(i)):
            factors=prime_factors(i)
            if (len(factors)==2):
                print "{0} ; {1} ; {2}".format(i,factors[0],factors[1])
                colour=i
                pygame.draw.circle(window,colour,(factors[0],factors[1]),1)
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
