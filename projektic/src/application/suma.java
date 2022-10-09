package application;

import java.util.ArrayList;

public class suma {

	 static boolean isSubsetSum(int set[],int n, int sum){

		 if (sum == 0)
			 return true;
		 if (n == 0)
			 return false;

		 if (set[n - 1] > sum)
			 return isSubsetSum(set, n - 1, sum);

		 return isSubsetSum(set, n - 1, sum)
				 || isSubsetSum(set, n - 1, sum - set[n - 1]);
	}
	 
	 public void podsuma(int niz[],int n,int suma) {	 
		 ArrayList<Integer> indeksi = new ArrayList<Integer>();
		 if(isSubsetSum(niz, n, suma)) {
			 for(int i = 0;i<n;i++) {
				 for(int j = i;j<n;j++) {
					if(niz[i]+niz[j]>n)
						continue;
					else {
						
						
						
					}
					 
				 }
			 }
			 
			 
		 }
		 else {
			 System.err.println("Nista!");
			 return;
		 }
	 }
	 
	 
	 
	 public static void main(String args[]){
		/* int set[] = { 3, 34, 4, 12, 5, 2 };
		 int sum = 41;
		 int n = set.length;
		 if (isSubsetSum(set, n, sum) == true)
			 System.out.println("Found a subset"+ " with given sum");
		 else
			 System.out.println("No subset with" + " given sum");*/
		 
		 int set[] = { 3, 34, 4, 12, 5, 2 };
		 int sum = 41;
		 int n = set.length;

	 }
	}
