import java.io.*;

public class Customer implements Serializable {
    private static int nextId = 1;
    private int custId;
    private String name;
    private String email;
    private String skillsLevel;

    public Customer(String name, String email, String skillsLevel) {
        this.custId = nextId++;
        this.name = name;
        this.email = email;
        this.skillsLevel = skillsLevel;
    }

    /* Get and set methods not required. */
   
    @Override
    public String toString() {
        return "Customer [ID: " + custId + ", Name: " + name + ", Email: " + email + ", Skills Level: " + skillsLevel + "]";
    }
}

