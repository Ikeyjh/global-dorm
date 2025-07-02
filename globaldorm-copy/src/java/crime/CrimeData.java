package crime;

public class CrimeData {
    
    private CrimeCategory category;
    private CrimeLocation location;

    public CrimeCategory getCategory() { return category; }
    public void setCategory(CrimeCategory value) { this.category = value; }

    public CrimeLocation getLocation() { return location; }
    public void setLocation(CrimeLocation value) { this.location = value; }

}