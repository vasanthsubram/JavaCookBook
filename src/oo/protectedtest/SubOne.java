package oo.protectedtest;

import oo.protected2.SubTwo;

public class SubOne extends Super{
	
	public static void main ( String [ ] args ) {
        Super s = new Super() ;
        SubOne s1 = new SubOne () ;

        SubTwo s2 = new SubTwo() ;

        s.say (" Super ") ; 
        s1.say ("SubOne") ; 
        s2.say ("SubTwo") ;

    } 
}