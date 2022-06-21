import java.util.*;
import java.util.stream.*;

class Sort_Stream {
	public static void main(String[] args) throws Exception {
		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat(2, "sana"));
		cats.add(new Cat(3, "momo"));
		cats.add(new Cat(1, "mina"));
		cats.add(new Cat(4, "jihyo"));
		System.out.println("cats: " + cats.toString());
		
		List<Cat> sortedCats = cats.stream().sorted(Comparator.comparing(Cat::getNumber).reversed()).collect(Collectors.toList());
		System.out.println("sortedCats: " + sortedCats.toString());
	}
}

class Cat {
  public int number;
  public String name;
  public Cat(int number, String name) {
    this.number = number;
    this.name = name;
  }
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Cat [number=" + number + ", name=" + name + "]";
	}
}
