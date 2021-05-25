/**
 * student name: Sarah Brennan
 * student number: 2962279
 *
 */

import java.util.*;
public class Question1Test {
	public static void main(String[] args)
	{
		//the size of the list with the best performance is 1259 as the percentage of buckets used is 100% and there are no empty buckets
		MyHashList<Point3D> lst = new MyHashList<Point3D>(1259);		
		//add random elements into list
		for(int i = 0; i < 9999; i++)
		{
			int x = (int)(Math.random()*10);
			int y = (int)(Math.random()*10);
			int z = (int)(Math.random()*10);
			Point3D p = new Point3D(x, y, z);
			lst.add(p);
		}
		
		//add specific point to check if the .equals works
		Point3D p1 = new Point3D(1,5,2);
		lst.add(p1);
		//print out all points
		System.out.println(lst.toString());
		
		Point3D p2 = new Point3D(1,5,2);
		System.out.println(p2.equals(p1));
		
		System.out.println(lst.hashCode());
		System.out.println(lst.size());
		System.out.println(lst.remove(p1));
		System.out.println(lst.contains(p1));
		System.out.println(lst.size());
		
		//print out how much of the table is being used and which is the largest/smallest bucket
		System.out.println("Percent used: " + lst.percentUsed());	
		System.out.println("Largest Bucket: " + lst.largestBucket());	
		System.out.println("Smallest Bucket: " + lst.smallestBucket());
		//prints out the amount of buckets with certain elements
		int bucketSize[] = lst.listSizes();
		System.out.println("Frequency list");
		for(int i = 0; i < bucketSize.length; i++){
			if(bucketSize[i] > 0){
				System.out.printf("Buckets with %d elements = %d\n", i, 
						bucketSize[i]);
			}
		}
		//shows how many buckets are empty
		System.out.println("Empty Buckets = " + lst.empty());

	}
}