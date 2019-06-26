package shop.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private final List<Address> addresses;

    protected Customer(){
        addresses=new ArrayList<>();
    }

public abstract String getName();

    public List<Address> getAddresses(){
        return addresses;
    }

    public void setAddresses(Address address){
        addresses.add(address);
    }
}
