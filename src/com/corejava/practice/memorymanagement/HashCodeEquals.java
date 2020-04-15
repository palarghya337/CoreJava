package com.corejava.practice.memorymanagement;

public class HashCodeEquals {

	public static void main(String[] args) {
		
		Geek g1 = new Geek("aa", 1);
		Geek g2 = new Geek("aa", 1);
		
		if (g1.hashCode() == g2.hashCode()) {
			if (g1.equals(g2)) {
				
				System.out.println("Objects are equals");
			} else {
				System.out.println("Objects are not equals");
			}
		} else {
			System.out.println("Objects are different");
		}
		/*
		 * The above code will print "Objects are equals because
		 * both the objects hash code will return 1 as we are
		 * returning ID in the hashCode() method of Geek class.
		 * So it will satisfy first if condition. Now it will
		 * come to the second if condition. When equals method
		 * of Geek class will call it will again return true
		 * because hash code of name variable and id of both the
		 * objects are same.
		 * 
		 *  If you do not override the equals method or if you
		 *  uncomment the equals method then the result would be
		 *  "Objects are not equals" because if equals method is
		 *  not overridden then by default is will call Object
		 *  class equals method which will check two object with
		 *  "==" or the reference is same or not which in our case
		 *  is not same because we know java will create separate
		 *  object when we use new keyword to create an object.
		 **/
	}
	private static class Geek {
		
		private String name;
		private int id;
		public Geek(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
		@Override
		public int hashCode() {
			return id;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			Geek local = (Geek) obj;
			if (obj == this) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.name != local.name) {
				return false;
			}
			return this.name.hashCode() == local.name.hashCode()
					&& this.id == local.id;
		}
		
		@Override
		public String toString() {
			return "Geek [name=" + name + ", id=" + id + "]";
		}
	}
}
