
import java.util.ArrayList;
import java.util.List;

public class HealthMonitoringApp {

    private static UserDao userDao = new UserDao();
    /**
     * Test the following functionalities within the Main Application
     *  1. Register a new user
     *  2. Log in the user
     *  3. Add health data
     *  4. Generate recommendations
     *  5. Add a medicine reminder
     *  6. Get reminders for a specific user
     *  7. Get due reminders for a specific user
     *  8. test doctor portal
     */
    public static void main(String[] args) {
        // test register a new user
        insertUsers();

        // test Login user (call testLoginUser() here)
        testLoginUser("ramshaishtiaque@gmail.com", "Zarrar");

        // Add health data
        // Generate recommendations
        // Add a medicine reminder
        // Get reminders for a specific user
        // Get due reminders for a specific user
        // test doctor portal (call testDoctorPortal() here)
        
    }

    public static void insertUsers() {
        List<User> userList = new ArrayList<>();

        Doctor user2 = new Doctor(-1,"Ramsha", "Ishtiaque","ramshaishtiaque@gmail.com", "Zarrar", true, "12345", "Physician");
        userList.add(user2);

        User user1 = new User(-1,"Ainee", "Malik","qmalik@gmail.com", "guggu", false);
        userList.add(user1);

        User user3 = new User(-1,"Hamza", "khan","hamzakhan@gmail.com", "guggu", false);
        userList.add(user3);

        Doctor user4 = new Doctor(-1,"Bilal", "Ishtiaque","bilalishtiaque@gmail.com", "guggu", true, "234567", "Dentist");
        userList.add(user4);

        User user5 = new User(-1,"Zarrar", "Khan","zarrarkhan@gmail.com", "guggu", true);
        userList.add(user5);

        User user6 = new User(-1,"Ainee", "Malik","qmalik@gmail.com", "guggu", false);
        userList.add(user6);
        
        User user7 = new User(-1,"Ainee", "Malik","qmalik@gmail.com", "guggu", false);
        userList.add(user7);

        for (User user : userList) {
            boolean insertSuccess = userDao.createUser(user);
            if (insertSuccess) {
                System.out.println(user.getFirstName() + " " + "inserted successfully.");
            } else {
                System.err.println(user.getFirstName() + " " + "insert failed.");
            }
        }
    }


    public static boolean loginUser(String email, String password) {
        //implement method to login user.
        User user = userDao.getUserByEmail(email);

        if (user != null) {
            // Compare the stored hashed password with the given password and return result
            return userDao.verifyPassword(email, password);
        }
        return false;
    }


    /**
     * To test the Doctor Portal in your Health Monitoring System, provide a simple test code method that you can add
     * to your main application class.
     * In this method, we'll test the following functionalities:
     * 1. Fetching a doctor by ID
     * 2. Fetching patients associated with a doctor
     * 3. Fetching health data for a specific patient
      */
    public static void testDoctorPortal() {
        // Replace the doctorId with a valid ID from your database
        int doctorId = 1;

        // Add code to Fetch the doctor by ID

        // Add code to Fetch patients associated with the doctor

        // Add code to Fetch health data for the patient

    }


    /**
     * To test the login user functionality in your Health Monitoring System, you can
     * add a test method to your main application class
     */
    public static void testLoginUser(String email, String password) {
        // Replace the email and password with valid credentials from your database
        boolean loginSuccess = loginUser(email, password);

        if (loginSuccess) {
            System.out.println("Login Successful");
        } else {
            System.err.println("Incorrect email or password. Please try again.");
        }
    }

    /**
     * Inserting health data for test
     */
    public static void insertHealthData() {

    }
}
