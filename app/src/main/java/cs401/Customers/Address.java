// Vincent Rusca

package cs401.Customers;

import java.io.Serializable;

public class Address implements Serializable {
    // address fields
    String streetAddress;
    String cityAddress;
    String stateAddress;
    String zipAddress;

    // constructors
    public Address() {
        streetAddress = "";
        cityAddress = "";
        stateAddress = "";
        zipAddress = "";
    }
    public Address(String _streetAddress, String _cityAddress, String _stateAddress, String _zipAddress) {
        streetAddress = _streetAddress;
        cityAddress = _cityAddress;
        stateAddress = _stateAddress;
        zipAddress = _zipAddress;
    }

    // getters
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCityAddress() {
        return cityAddress;
    }
    public String getStateAddress() {
        return stateAddress;
    }
    public String getZipAddress() {
        return zipAddress;
    }

    // setters
    public void setStreetAddress(String _streetAddress) {
        streetAddress = _streetAddress;
    }
    public void setCityAddress(String _cityAddress) {
        cityAddress = _cityAddress;
    }
    public void setStateAddress(String _stateAddress) {
        stateAddress = _stateAddress;
    }
    public void setZipAddress(String _zipAddress) {
        zipAddress = _zipAddress;
    }

    public String toString() {
        return streetAddress + " " + cityAddress + ", " + stateAddress + " " + zipAddress;
    }

    //

    @Override
    public boolean equals(Object other) {
        if (other instanceof Address) {
            Address otherAddress = (Address) other;
            return streetAddress.equals(otherAddress.streetAddress) &&
                    cityAddress.equals(otherAddress.cityAddress) &&
                    stateAddress.equals(otherAddress.stateAddress) &&
                    zipAddress.equals(otherAddress.zipAddress);
        }
        return false;
    }
}
