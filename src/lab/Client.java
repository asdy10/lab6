package lab;

public class Client {
    private final String firstName;
    private final String secondName;
    private String address;
    private Integer passport;
    private boolean hasFewInfo = false;

    private Client(Builder builder) {
        firstName = builder.firstName;
        secondName = builder.secondName;
        address = builder.address;
        passport = builder.passport;
        if (address != null || passport != 0)
            hasFewInfo = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAddress() {
        return address;
    }

    public int getPassport() {
        return passport;
    }

    public boolean hasFewInfo() {
        return hasFewInfo;
    }

    public static Builder Builder(String firstName, String secondName) {
        return new Builder(firstName, secondName);
    }

    public static class Builder {
        private String firstName;
        private String secondName;
        private String address;
        private Integer passport = 0;

        public Builder(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPassportNumber(Integer passport) {
            this.passport = passport;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    public String toString() {
        String res =      "Client:   " + firstName + " " + secondName;
        if (address != null)
            res = res + "\nAddress:  " + address;
        if (passport != 0)
            res = res + "\nPassport: " + passport;
        return res;
    }

}