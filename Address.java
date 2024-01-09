
package studyopedia;

import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    private String name;
    private String phone;
    private String email;
    
    public Contact(String name, String pn, String mail)
    {
        this.name = name;
        this.phone = pn;
        this.email = mail;
    }
    
    public String getname(){
        return name;
    }
    
    public String getmob(){
        return phone;
    }
    
    public String getmail(){
        return email;
    }
    
    @Override
    public String toString(){
        return "Name: "+ name +", Phone: "+phone+", Email: "+email;
    }
    
}

class AddressBook{
    private ArrayList<Contact> contacts;
    
    public AddressBook(){
        contacts = new ArrayList<>();
    }
    
    public void addC(Contact contact){
        contacts.add(contact);
    }
    
    public void remove(String name)
    {
        contacts.removeIf(contact -> contact.getname().equalsIgnoreCase(name));
    }
    
    public Contact search(String name)
    {
        for (Contact contact : contacts)
        {
            if(contact.getname().equalsIgnoreCase(name))
            {
            return contact;
            }
        }
        return null;
    }
    
    public void display(){
        System.out.println("All CONTACTS:");
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }

}

public class Address{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        AddressBook addBook = new AddressBook();
        
        while(true){
            System.out.println("\n** ADDRESS BOOK MENU **\n");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit from Program.");
            
            System.out.println("Enter choice: ");
            int ch = scan.nextInt();
            scan.nextLine();
            
            switch(ch){
                //Add
                case 1:
                    
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.print("Mobile Nummber: ");
                    String num = scan.nextLine();
                    System.out.print("Email: ");
                    String email = scan.nextLine();
                    
                    Contact newCont = new Contact(name,num,email);
                    addBook.addC(newCont);
                    System.out.println("Contact Saved.");
                    break;
                    
                    //Remove
                case 2:
                    System.out.print("Enter name of Contact to remove: ");
                    String rem = scan.nextLine();
                    addBook.remove(rem);
                    System.out.println("Contact Deleted Successfully.");
                    break;
                    
                //Search
                case 3:
                    System.out.print("Enter Contact to search: ");
                    String s = scan.nextLine();
                    Contact found = addBook.search(s);
                    if(found != null)
                    {
                        System.out.println("contact found:\n" + found);
                    }
                    else{
                        System.out.println("Contact not found.");
                    }
                    break;
                    
                //Display All
                case 4:
                    addBook.display();
                    break;
                    
                //Exit
                case 5:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                    
                default:
                System.out.println("Invalid choice. Please try again.");
                break;
            }
        }
    }
}
