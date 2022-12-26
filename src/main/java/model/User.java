package model;

public class User {

    public int id;
    public String name;
    public String email;
    public String phoneNumber;
    public String emergencyContact1;
    public String emergencyContact2;
    public String address;
    public String masterCode;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContact1() { return emergencyContact1; }

    public void setEmergencyContact1(String emergencyContact1) { this.emergencyContact1 = emergencyContact1; }

    public String getEmergencyContact2() { return emergencyContact2; }

    public void setEmergencyContact2(String emergencyContact2) { this.emergencyContact2 = emergencyContact2; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

}

