package orchestrator.user;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author isaac
 */
public class SignupData {
    @SerializedName("first_name")
    private String fname;
    @SerializedName("last_name")
    private String lname;
    private String phone;
    private String email;
    private String postcode;
    
    public String getFname(){
        return this.fname;
    }
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public String getLname(){
        return this.lname;
    }
    
    public void setLname(String lname){
        this.lname = lname;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public void getPhone(String phone){
        this.phone = phone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPostcode(){
        return this.postcode;
    }
    
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
}
