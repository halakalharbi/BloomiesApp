
package stage3;

public class Customer implements OrderObserver {
    // Identify the attributes
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    

    /**
     * Create a customer with all empty fields in the constructor.
     */
    public Customer() {
        customerId = "";
        firstName = "";
        lastName = "";
        phoneNumber = "";
    }

    public Customer(String customerId, String firstName, String lastName, String phoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
       this.phoneNumber=phoneNumber;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
  
            this.phoneNumber = phoneNumber;
       
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

   
    public String toString() {
        return "\nCustomer information:"+
                "\nCustomer ID:" + customerId
                + "\nFirst Name: "+ firstName 
                +"\nLast Name: "+ lastName +"\nPhone Number: "+ phoneNumber;
    }
    
     @Override
    public void update(Order order) {
        // Perform actions when the order is updated
        System.out.println("Notification: Your order has been updated!");
        System.out.println(order.toString());
        // Additional actions...
    }
}
