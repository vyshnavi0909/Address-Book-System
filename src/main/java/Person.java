import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private int zip;
    private String phoneNum;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "\nfirstName='" + firstName + '\'' +
                ",\nlastName='" + lastName + '\'' +
                ",\ncity='" + city + '\'' +
                ",\nstate='" + state + '\'' +
                ",\nzip=" + zip +
                ",\nphoneNumber='" + phoneNum + '\'' +
                ",\nemail='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return  Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
