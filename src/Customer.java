public class Customer {
    private String name;
    private String streetAddress;
    private String stateAndTown;
    private int zipCode;

    public Customer(String name, String streetAddress, String stateAndTown, int zipCode)
    {
        this.name=name;
        this.streetAddress=streetAddress;
        this.stateAndTown=stateAndTown;
        this.zipCode=zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStateAndTown() {
        return stateAndTown;
    }

    public void setStateAndTown(String stateAndTown) {
        this.stateAndTown = stateAndTown;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
