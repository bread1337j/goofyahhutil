package Util;

import java.util.*;

public class JohnTimer{
	private double time = 0; 
	private double timer = 0;
	public void start(){
		double timer = System.nanotime();
	}
	public void record(){
		time += timer-System.nanotime();
	}
	public void display(){
		System.out.println(time);
	}
	public double getTime(){
		return time;
	}
	public void setTime(double num){
		this.time = num;
	}
	




}
