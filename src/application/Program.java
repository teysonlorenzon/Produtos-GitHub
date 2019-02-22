package application;

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

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List<Product> listProd = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int numProd = sc.nextInt();

		for (int i = 0; i < numProd; i++) {

			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common,used or imported (c/u/i)? ");
			char decision = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (decision == 'c') {

				Product cProd = new Product(name, price);
				listProd.add(cProd);
			} else if (decision == 'u') {
				System.out.print("manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());

				Product uProd = new UsedProduct(name, price, date);
				listProd.add(uProd);
			} else if (decision == 'i') {
				System.out.print("Customs free: ");
				double customsFree = sc.nextDouble();

				Product iProd = new ImportedProduct(name, price, customsFree);

				listProd.add(iProd);
			}

		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : listProd) {
			System.out.println(prod.priceTag());
		}
		sc.close();

	}

}
