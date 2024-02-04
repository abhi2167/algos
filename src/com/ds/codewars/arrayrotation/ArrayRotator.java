package com.ds.codewars.arrayrotation;

public class ArrayRotator {

	public static void main(String ...args){
		ArrayRotator ar = new ArrayRotator();
		Object[] rotatedArray = ar.rotateBetter(new Object[]{1,2,3,4,5},-2);
		for(int i=0;i<rotatedArray.length;i++)
			System.out.print(rotatedArray[i]);
		
	}
	
	//Better solution
	public Object[] rotateBetter(Object []data,int n){
		Object [] result =new Object[data.length];
		int len = n % data.length + (n < 0 ? data.length : 0);
		for(int i = len; i < data.length;i++){
			result[i] = data[i-len];
		}
		for(int i=0;i < len; i++){
			result[i] = data[data.length-len+i];
		}
		return result;
	}
	
	//Not a good solution
	public  Object[] rotate(Object [] a,int n){
		
		if(n == 0){
			return a;
		} else if(n > 0){
			return rotateRight(a,n);
		} else {
			return rotateLeft(a,n);
		}		
	}

	public Object[] rotateRight(Object[] a, int n) {
		for(int j=0;j<n;j++){
			Object temp = null;
			temp = a[0];
			a[0] = a[a.length-1];
			for(int i=a.length-1;i>0;i--){
				if(i==1) {
					a[i] = temp;
					break;				
				}					
				a[i]=a[i-1];						
			}
		}
		return a;
	}
	
	public Object[] rotateLeft(Object[] a, int n){
		
		for(int j=0;j<Math.abs(n);j++){
			Object temp = null;
			temp = a[0];
			//a[a.length-1] = a[0];
			for(int i=0;i<a.length;i++){
				if(i==a.length-1){
					a[i] = temp;
					break;
				}
				a[i]=a[i+1];
			}
		}
		return a;
	}
}
