package p.tomaszewski.FastRace.model.projection;

public class ContactReadModel {
    private String name;
    private String email;
    private String Subject;
    private String message;

    public ContactReadModel(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.Subject = subject;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}