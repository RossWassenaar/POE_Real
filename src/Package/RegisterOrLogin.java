package Package;
import javax.swing.JOptionPane;

public class RegisterOrLogin {
    public static void main(String[] args) {
        Login newUser = new Login();

        String username;
        String password;
        String firstName;
        String surname;
        boolean registerUsername;
        boolean registerPassword;
        boolean correctLogin;

        boolean cancel = false;
        while (!cancel) {
            String[] rolOption = { "Register", "Login", "Cancel" };
            int registerOrLogin = JOptionPane.showOptionDialog(null,
                    "Register if you don't have an account\nOr Login to an existing account", "Register Or Login", 1, 1,
                    null, rolOption, rolOption[0]);
            switch (registerOrLogin) {
                case 0:
                    // Register
                    do {
                        // Prompting User for registration details
                        username = JOptionPane.showInputDialog("Register your username");
                        password = JOptionPane.showInputDialog("Register your password");
                        firstName = JOptionPane.showInputDialog("Register your first name");
                        surname = JOptionPane.showInputDialog("Register your surname");

                        // Setting inputted details
                        newUser.setUsername(username);
                        newUser.setPassword(password);
                        newUser.setFirstName(firstName);
                        newUser.setLastName(surname);

                        // Validating user inputs ---> username and password
                        registerUsername = newUser.checkUserName();
                        registerPassword = newUser.checkPasswordComplexity();

                        // Message displaying validation results
                        JOptionPane.showMessageDialog(null, newUser.registerUser(), "Registration Status",
                                registerUsername && registerPassword ? 1 : 0);
                    } while (!registerUsername || !registerPassword);
                    break;

                case 1:
                    // Login
                    do {
                        correctLogin = newUser.loginUser();
                        JOptionPane.showMessageDialog(null, newUser.loginStatus(correctLogin), "Login Status",
                                correctLogin ? 1 : 0);
                    } while (!correctLogin);
                    break;

                case 2:
                    cancel = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please choose a valid option", "Error", 0);
                    break;
            }
        }
    }
}
