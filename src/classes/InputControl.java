package classes;

public class InputControl {

    public static boolean checkInput(String login, String password, String confirmPassword) {
        String regex = "\\w+";

        try {
            if (!login.matches(regex) || login.length() >= 20) {
                throw new WrongLoginException("Login must be at least 20 characters, must be contain only alphanumeric characters and underline");
            }

            if (!password.matches(regex) || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password must be at least 20 characters, must be contain only alphanumeric characters" +
                        " and underline. Password and confirm password must be equals");
            }
        }
        catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
