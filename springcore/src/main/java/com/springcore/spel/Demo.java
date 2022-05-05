package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // to get obj
public class Demo {
	@Value("#{15+1}") // How to work with Spring expression
	private int x;
	@Value("#{10>2 ? 16: 0}")
	private int y;

	// including static methods.
	@Value("#{T(java.lang.Math).sqrt(25)}")
	private double z;
	// Including static method and staitc vari (E) using Spring exprssion.
	@Value("#{T(java.lang.Math).E}") // syntax : @Value(" { classname.method/var }")
	private double e;

	@Value("#{ new java.lang.String('Durgesh Tiwari') }")
	private String name;

	@Value("#{8>1} ")
	private boolean isactive;

	
	
	
	
	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", e=" + e + ", name=" + name + ", isactive=" + isactive
				+ "]";
	}

}
