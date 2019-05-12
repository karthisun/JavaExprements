public class Address implements Cloneable  
{  
    public String city, state, country;  
    public Address(String city, String state, String country)  
    {  
        this.city = city;  
        this.state = state;  
        this.country = country;  
    }  
    protected Object clone() throws CloneNotSupportedException   
    {  
        return super.clone();  
    }  
} 