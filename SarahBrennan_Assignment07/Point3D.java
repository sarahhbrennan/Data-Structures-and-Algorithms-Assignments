/**
 * student name: Sarah Brennan
 * student number: 2962279
 */

import java.util.*;
public class Point3D{
	private int x,y,z;

	Point3D(int a, int b, int c){
		x = a;
		y = b;
		z = c;
	}

	public int x(){
		return x;
	}

	public int y(){
		return y;
	}

	public int z(){
		return z;
	}

	public String toString(){
		return "("+x+", "+y+", "+z+")";
	}
	
	
	public boolean equals(Object ob)
	{
		if(!(ob instanceof Point3D)) 
			return false;
		Point3D p = (Point3D)ob;
		if(x == p.x && y == p.y && z == p.z)
			return true;
		else
			return false;
	}
}