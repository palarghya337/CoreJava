package com.corejava.practice.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.corejava.practice.utils.Log;

public class FlatMapExample {

	public static void main(String[] args) {
		
		FlatMapExample example = new FlatMapExample();
		List<String> amazonList = Arrays.asList("Laptop",
				"Refrigerator", "Mobile");
		List<String> mintraList = Arrays.asList("Shirt",
				"TShirt", "Pant");
		
		ECommerce amazon = example.new ECommerce("Amazon", amazonList);
		ECommerce mintra = example.new ECommerce("Mintra", mintraList);
		List<ECommerce> listOfECommerce = Arrays.asList(amazon, mintra);
		
		List<List<String>> allProductsByMap = listOfECommerce.stream()
				.map(ECommerce::getProducts)
				.collect(Collectors.toList());
		Log.logInfo("---------- Result of map() ----------");
		Log.logInfo(allProductsByMap);
		
		List<String> allProductsByFlatMap = listOfECommerce.stream()
				.map(ECommerce::getProducts)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		Log.logInfo("---------- Result of flatMap() ----------");
		Log.logInfo(allProductsByFlatMap);
		
		List<String> sortedList = allProductsByFlatMap.stream()
				.sorted().collect(Collectors.toList());
		Log.logInfo("---------- After sorting the flatMap() ----------");
		Log.logInfo(sortedList);
	}
	private class ECommerce {
		
		private String eCommerceName;
		private List<String> listOfProduct;
		
		public ECommerce(String eCommerceName,
				List<String> listOfProduct) {
			
			this.eCommerceName = eCommerceName;
			this.listOfProduct = listOfProduct;
		}
		@SuppressWarnings("unused")
		public String geteCommerceName() {
			return eCommerceName;
		}
		public List<String> getProducts() {
			return listOfProduct;
		}
	}
}
