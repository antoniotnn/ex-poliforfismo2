package entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;

	public ImportedProduct() {
		super();
	}
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return getPrice()+customsFee;
	}

	@Override
	public String priceTag() {
		return super.priceTag()+" $"+ totalPrice()+" (Customs Fee: $"
	}
}
