package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n=sc.nextInt();
		
		for (int i=1;i<=n;i++) {
			System.out.println("Product "+"#"+i+" data:");
			System.out.print("Common, used or imported (c/u/i) ? ");
			char cui=sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.print("Price: ");
			Double price=sc.nextDouble();
			if (cui=='u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate=sdf.parse(sc.next());	
				products.add(new UsedProduct(name,price,manufactureDate));
			} else if (cui=='i') {
				System.out.print("Customs fee: ");
				Double customsFee=sc.nextDouble();
				products.add(new ImportedProduct(name,price,customsFee));
			} else {
				products.add(new Product(name,price));	
			}
		}
		
		System.out.println("PRICE TAGS:");
		for (Product product : products ) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
