import java.util.UUID;

public abstract class Person {
    String id;
    String name;
    String phoneNumber;
    String mail_id;

    public Person(String name, String phoneNumber, String mail_id) {
        // try {
        //     if(name == null || name.trim().isEmpty())
        //         throw new IllegalArgumentException("Name cannot be empty.");
        //     if(phoneNumber == null || phoneNumber.trim().isEmpty())
        //         throw new IllegalArgumentException("Phone number cannot be empty.");
        //     if(mail_id == null || mail_id.trim().isEmpty())
        //         throw new IllegalArgumentException("Mail ID cannot be empty.");
        // } catch (IllegalArgumentException e) {
        //     System.out.println(e.getMessage());
        //     return;
        // }
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail_id = mail_id;
    }

    public String getName() {
        return name;
    }

     public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailId() {
        return mail_id;
    }

    public void setName(String name) {
        try {
            if(name == null || name.trim().isEmpty())
                throw new IllegalArgumentException("Name cannot be empty.");
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            if(phoneNumber == null || phoneNumber.trim().isEmpty())
                throw new IllegalArgumentException("Phone number cannot be empty.");
            this.phoneNumber = phoneNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }   
    }

    public void setMailId(String mail_id) {
        try {
            if(mail_id == null || mail_id.trim().isEmpty())
                throw new IllegalArgumentException("Mail ID cannot be empty.");
            this.mail_id = mail_id;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public String toString() {
        return "Person ID: " + id + ", Name: " + name + ", Phone Number: " + phoneNumber + ", Mail ID: " + mail_id;
    }

    // public void getNotification(String message) {
    //     System.out.println("Notification for " + name + ": " + message);
    // }
}   