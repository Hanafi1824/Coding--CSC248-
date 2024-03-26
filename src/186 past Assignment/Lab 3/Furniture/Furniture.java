public class Furniture {
    private String furnitureType;
    private String material;
    private double pricePerUnit;
    private int quantity;

    public Furniture() {
        furnitureType = "";
        material = "";
        pricePerUnit = 0.00;
        quantity = 0;
    }

    public Furniture(String ft, String m, double ppu, int q) {
        furnitureType = ft;
        material = m;
        pricePerUnit = ppu;
        quantity = q;
    }

    public Furniture (Furniture furni){
        furnitureType = furni.furnitureType;
        material = furni.material;
        pricePerUnit = furni.pricePerUnit;
        quantity = furni.quantity;
    }

    public void setFurnitureType(String ft){
        furnitureType = ft;
    }
    public void setMaterial(String m){
        material = m;
    }
    public void setPricePerUnit(double ppu){
        pricePerUnit = ppu;
    }
    public void setQuantity(int q){
        quantity = q;
    }

    public String getFurnitureType(){
        return furnitureType;
    }
    public String getMaterial(){
        return material;
    }
    public double getPricePerUnit(){
        return pricePerUnit;
    }
    public int getQuantity(){
        return quantity;
    }

    public double calcPriceFurniture() {
		double priceWood = 0.0, priceRattan = 0.0, priceMetal = 0.0, priceBamboo = 0.0;
		
		if (material.equalsIgnoreCase("wood")){
			priceWood = pricePerUnit * quantity * 0.8;
		}
		if (material.equalsIgnoreCase("rattan")){
			priceRattan = pricePerUnit * quantity * 0.85;
		}
		if (material.equalsIgnoreCase("metal")){
			priceMetal = pricePerUnit * quantity * 0.9;
		}
		if (material.equalsIgnoreCase("bamboo")){
			priceBamboo = pricePerUnit * quantity * 0.95;
		}
		double totAll = priceWood + priceRattan + priceMetal + priceBamboo;
		return totAll;
	}

    public String toString(){
		return "\n----------" + "\n\nFurniture type: " + furnitureType + "\nFurniture Material: " + material + "\nPrice Per Unit: RM"
        + pricePerUnit + "\nThe quantity of " + quantity + " units";
	}
}
