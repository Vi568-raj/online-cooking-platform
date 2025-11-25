import javax.swing.SwingUtilities;
import ui.LoginUI;

public class Main {
    public static void main(String[] args) {
        // Start the application by opening the login window on the EDT
        SwingUtilities.invokeLater(() -> new LoginUI());
    }
}
