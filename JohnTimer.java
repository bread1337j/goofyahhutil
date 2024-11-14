package Util;

import java.util.*;

public class JohnTimer{
	private double time = 0; 
	private double timer = 0;
	private double times = 0; //because there wasn't enough ambiguity in variable names already. future me is going to be so mad.
	private double avg = 0;
	public void start(){
		timer = System.nanoTime();
		times = 0;
		avg = 0;
		time = 0;
		
	}
	public void record(){
		time += System.nanoTime()-timer;
		avg *= times;
		avg += time;
		times += 1;
		avg /= times;
		timer = System.nanoTime();
	}
	public void display(){
		System.out.println(time + " | AVG: " + avg);
	}
	public void displaysec(){
		System.out.println(time/1000000000 + " | AVG: " + avg/1000000000);
	}
	public void displayms(){
		System.out.println(time/1000000 + " | AVG: " + avg/1000000);
	}
	public double getTime(){
		return time;
	}
	public void setTime(double num){
		this.time = num;
	}
	




}
