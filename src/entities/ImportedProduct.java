package entities;

public final class ImportedProduct extends Product {

	private Double customsFree;

	ImportedProduct() {
	super();
	}

	public ImportedProduct(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public Double getCustomsFree() {
		return customsFree;
	}

	
	public double totalPrice() {
		return price += customsFree;
	}
	
	@Override
	public String priceTag() {
		return super.priceTag() + " (Customs free: $ " + String.format("%.2f", customsFree) + ")";
		}

}
