package stage3;

public class Address {
    private String region;
    private String city;
    private String street;
    private String zipCode;
    private String buildingNumber;

    /**
     * Create an address with all empty fields in the constructor.
     */
    public Address() {
        street = "";
        region = "";
        city = "";
        buildingNumber = "";
        zipCode = "";
    }

    public Address(String street, String region, String city, String buildingNumber, String zipCode) {
        this.street = street;
        this.region = region;
        this.city = city;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return "\nAddress information:"+
                "\nRegion: "+region + 
                "\n"+ "City: " + city +
                "\n" +"Street: "+ street +
                "\n" + "Building Number: "+ buildingNumber +
                "\n"+ "Zip Code:" + zipCode;
    }
}

