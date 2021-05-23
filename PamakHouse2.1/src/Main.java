import java.util.ArrayList;

/**
 * Created by Dimitris on 20-Dec-16.
 */
public class Main {

    public static void main(String[] args)
    {

        ArrayList<User> allUsers = new ArrayList<>();

        User u1 = new User("Makis", "it1698@uom.edu.gr");
        User u2 = new User("Petros", "it1624@uom.edu.gr");
        User u3 = new User("Maria", "it16112@uom.edu.gr");
        User u4 = new User("Gianna", "it16133@uom.edu.gr");
        User u5 = new User("Nikos", "it1658@uom.edu.gr");
        User u6 = new User("Babis", "it16104@uom.edu.gr");

        Group g1 = new Group("WebGurus","A group for web passionates");
        Group g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");

        allUsers.add(u1);
        allUsers.add(u2);
        allUsers.add(u3);
        allUsers.add(u4);
        allUsers.add(u5);
        allUsers.add(u6);

        new ManageGUI(allUsers, g1, g2);
    }
}
