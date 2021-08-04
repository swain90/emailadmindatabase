package emailapp;
import java.util.Locale;
import java.util.Scanner;


public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength;
    private int mailboxCapacity;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //call a method asking ofr department, return dept
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //call method that asks for pasword:
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);


        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

    }
    //ask fo the department

    private String setDepartment() {
        System.out.println("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }
        //generate a random password

    private String randomPassword(int length) {
            String passwordSet = "ABCDEFGHIJLKMNOPQRSTUVWXYZ0123456789!@#$%";
            char[] password = new char[length];
            for (int i=0; i<length; i++){
                int rand = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
        }

        //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }


        //set the alterante email

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

        //change the password

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "Company Email: " + email + "Mailbox Capacity: " + mailboxCapacity + "mb";
    }

}
