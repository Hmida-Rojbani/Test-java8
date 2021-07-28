package main;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Opt {

	public static void main(String[] args) {
		Optional<Integer> opt1 = Optional.of(25);
		Optional<Integer> opt2 = Optional.empty();
		
		System.out.println(opt1);
		System.out.println(opt2);
		if(opt1.isPresent())
		System.out.println(opt1.get());
		if(opt2.isPresent())
		System.out.println(opt2.get());
		
		System.out.println(opt2.orElseThrow(()-> new NoSuchElementException()));
	}
}
