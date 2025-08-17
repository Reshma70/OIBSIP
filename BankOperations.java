import java.util.HashMap;

public class BankOperations {
    private static HashMap<Integer, User> users = new HashMap<>();

    static {
        users.put(1010, new User(1010, 1234, 5000));
        users.put(2020, new User(2020, 5678, 3000));
    }

    public static User authenticate(int id, int pin) {
        User user = users.get(id);
        if (user != null && user.getPin() == pin) {
            return user;
        }
        return null;
    }

    public static User getUser(int id) {
        return users.get(id);
    }
}
