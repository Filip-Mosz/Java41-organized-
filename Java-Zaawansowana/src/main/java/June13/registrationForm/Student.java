package June13.registrationForm;

import java.util.Random;

public class Student {

    String nameAndSurname;
    String pesel;
    String phone;
    String language;
    boolean isPaid;

    public Student() {
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    static Student studentRandom() {
        Student random = new Student();

        String[] name = new String[]{"Hans", "Johannes", "Hanko", "Liutger", "Albreht"};
        String[] surname = new String[]{"Lichtenauer", "Talhoffer", "Dobringer", "Duhrer", "Marozzo"};
        String[] language = new String[]{"C++", "Java", "Python"};
        String[] pesel = new String[]{"890409033", "00000000000"};

        int nameRandom = new Random().nextInt(name.length);
        int surnameRandom = new Random().nextInt(surname.length);
        int languageRandom = new Random().nextInt(language.length);
        int peselRandom = new Random().nextInt(pesel.length);
        String randomNameAndSurname = name[nameRandom] +
                " " + surname[surnameRandom];

        random.setPesel(pesel[peselRandom]);
        random.setLanguage(language[languageRandom]);
        random.setNameAndSurname(randomNameAndSurname);
        random.setPhone(randomPhone());

        return random;
    }

    static String randomPhone() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = new Random().nextInt(9);
            result.append(digit);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Student: [" + nameAndSurname  +
                ", PESEL " + pesel  +
                ", tel " + phone  +
                ", wybrany język " + language  +
                ']';
    }
}
