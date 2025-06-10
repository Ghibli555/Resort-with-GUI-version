import java.io.*;
import java.time.*;

public class TravelPackage implements Serializable {
    private static int nextId = 1;
    private int packageId;
    private String date;
    private double duration;
    private String liftpass;
    private String lessonfees;

    public TravelPackage(String date, double duration, String liftpass, String lessonfees) {
        this.packageId = nextId++;
        this.date = date;
        this.duration = duration;
        this.liftpass = liftpass;
        this.lessonfees = lessonfees;
        
    }

    /* Get and set methods not required. */
    
    @Override
    public String toString() {
        return "TravelPackage" +
                "packageId=" + packageId +
                ", duration=" + duration +
                ", date=" + date +
                ", liftpass=" + liftpass +
               ", lessonfees= " + lessonfees;
    }
}
