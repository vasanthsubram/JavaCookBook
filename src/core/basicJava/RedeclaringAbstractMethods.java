package core.basicJava;

public  class RedeclaringAbstractMethods {
}


/**
 * Abstract methods can be redeclared
 * The methods of an interface can be redeclared in the sub-interfaces.
 * See Collection and Set 
 *
 */
abstract class AbstractParentclass  {
	
	public abstract void foo();
}

abstract class AbstractChildclass extends AbstractParentclass {
	
	public abstract void foo();
}
