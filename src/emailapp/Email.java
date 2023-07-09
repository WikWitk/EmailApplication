package emailapp;

import java.util.Scanner;

public class Email  {
   private String firstName;
    private String lastName;
    private String password;
    private String companySuffix = "company.com";
    private String department;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String email;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("Email Created:" + " " + this.firstName + "  " + this.lastName);

        //Call a method asking for the department  return department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//        System.out.println("Your email is:  " + email);


    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + " " + lastName + "Enter the department\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none\nEnter department number: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "sales";}
        else if (depChoice == 2) {return "accounting";}
        else if (depChoice == 3) {return "development";}
        else {return "";}
    }


    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWYXZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
        int rand = (int) (Math.random() * passwordSet.length());
        password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;

    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;

    }

    // Change the password
    public void changePassword(String password){
        this.password = password;

    }
    public int getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo(){
        return "DISPLAY NAME:  " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
