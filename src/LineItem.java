public class LineItem {
    private String Product;
    private int Quantity;
    private double ItemPrice;

    private double ItemTotal;

    public LineItem(String product, int Quantity, Double ItemPrice)
    {
        this.Product=product;
        this.Quantity=Quantity;
        this.ItemPrice=ItemPrice;
        this.ItemTotal=this.Quantity*this.ItemPrice;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getItemTotal() {
        return ItemTotal;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }
}
