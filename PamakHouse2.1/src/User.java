import java.util.ArrayList;

/**
 * Created by Dimitris on 20-Dec-16.
 */
public class User {

    private String name;
    private String email;
    private ArrayList<User> arrayUsers = new ArrayList<>();

    /**
     * Κατασκευαστής που ελέχγει αν το e-mail του χρήστη είναι αποδεκτό
     * @param name
     * @param email
     */
    public User (String name, String email) {

        this.name = name;
        if(email.startsWith("it") && email.endsWith("@uom.edu.gr"))
            this.email = email;
        else
            System.out.println("User " + this.name + " has not been created. Email format is not acceptable.\n");
    }

    public User(){
    }

    /**
     * Μέθοδος που ελέγχει αν δύο χρήστες είναι φίλοι. Επιστρέφει true αν είναι και false αν δεν είναι
     * @param aUser
     * @return
     */
    public boolean isHeInMyFriendList(User aUser) {

        boolean flag = false;

        if(this.getName().equals(aUser.getName()) && this.getEmail().equals(aUser.getEmail()))
            flag = false;

        for(User u : this.arrayUsers) {
            if(u.getName().equalsIgnoreCase(aUser.getName()) && u.getEmail().equalsIgnoreCase(aUser.getEmail()))
                flag = true;
            if(flag)break;
        }
        return flag;
    }

    public ArrayList<User> getArrayUsers() {
        return arrayUsers;
    }

    /**
     * Ελέγχει αν ο φίλος που θέλουμε να προσθέσουμε είναι ήδη στην λίστα ή αν προσπαθούμε
     * να προσθέσουμε τον ίδιο μας ευατό και αν όχι προσθέτει τον φίλο της επιλογής μας.
     * @param aUser
     */
    public void addFriend(User aUser) {

        if(this.isHeInMyFriendList(aUser))
            System.out.println("You already have this friend in your list.");
        else {
            if(this.getName().equals(aUser.getName()) && this.getEmail().equals(aUser.getEmail())) {
                System.out.println("\nYou can't add yourself in your friend list.\n");
                return;
            }
            else{
                this.arrayUsers.add(aUser);
                aUser.arrayUsers.add(this);

            }
            System.out.println(this.getName() + " and " + aUser.getName() + " are now frieds!");
        }
    }

    /**
     * Δημιουργεί μια λίστα temp στην οποία αποθηκεύονται οι κοινοί φίλοι των δύο χρηστών
     * επίσης εκτυπώνει τους κοινούς φίλους των δύο χρηστών.
     * @param aUser
     * @return
     */
    public ArrayList<User> mutualFriends(User aUser) {

        ArrayList<User> temp = new ArrayList<User>();

        System.out.println("\n**************************************");
        System.out.println("Mutual friends of " + this.getName() + " and " + aUser.getName());
        System.out.println("**************************************");

        int count = 0;

        for(User u1 : this.arrayUsers)
            for(User u2 : aUser.arrayUsers){
                if(u1.getName().equals(u2.getName()) && u1.getEmail().equals(u2.getEmail())) {
                    temp.add(u2);
                    count ++;
                    System.out.println(count + ": " +u2.getName());
                    break;
                }
            }
        System.out.println("--------------------------------------");
        return temp;
    }

    /**
     * Εκτυπώνει τους φίλους του χρήστη
     */
    public void printFriends() {

        System.out.println(this.getName() + " is friend with: ");
        for(User u : this.arrayUsers)
            System.out.println(u.getName());
        System.out.println("--------------------------------------");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
