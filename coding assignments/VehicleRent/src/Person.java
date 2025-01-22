import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private int phoneNumber;

    public Person(String name, LocalDate birthDate, int phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}