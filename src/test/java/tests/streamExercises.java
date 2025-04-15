package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class streamExercises {

	//@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Sai");
		names.add("Sravani");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				count = count + 1;
			}
		}
		System.out.println("Count is : "+String.valueOf(count));
	}
	
	
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Sai");
		names.add("Sravani");
		names.add("Adam");
		
		//there is no life for internediate operation if there is no terminal operation
		// terminal operation will execute only if inter operation filter) returns true
		// we can create stream
		// how to use filter in stream API
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("C value is: "+String.valueOf(c));
		
		long d = Stream.of("Abhijeet", "Don", "Sai", "Sravani", "Adam").filter(s->{
			if(s.startsWith("A"))
				return true;
			else
				return false;
		}).count();
		System.out.println("d value is: "+String.valueOf(d));
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap() {
		System.out.println("Convert with uppercase");
		Stream.of("Abhijeet", "Sai", "Sravani").map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("String with ending I and usage of map and filter");
		Stream.of("Abhijeet", "Sai", "Sravani").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		//print the first letter as a and sorted
		Stream.of("Abhijeet", "Sai", "Sravani", "Adam").filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
		
		List<String> names = Arrays.asList("Abhijeet", "Sai", "Sravani", "Adam", "Aadhya", "Azad");
		List<String> names1 = Arrays.asList("Hari", "Rakesh");
		System.out.println("list of Arrays to list");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("Merge Two lists");
		//merge two different list
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		//list - convert into new list and perform the modifications
		List<String> ls = Stream.of("Abhijeet", "Sai", "Sravani", "Adam", "Aadhya", "Azad").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//print unique numbers from list
		List<Integer> values = Arrays.asList(3, 2, 5, 6, 4, 4);
		values.stream().distinct().forEach(s->System.out.println(s));
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		values.stream().distinct().sorted().limit(2).forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(0));
	}

	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Sai");
		names.add("Sravani");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				count = count + 1;
			}
		}
		System.out.println(count);
	}*/

}
