import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    private JButton userLoginButton, adminLoginButton;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        userLoginButton = new JButton("User Login");
        userLoginButton.setBounds(50, 50, 200, 30);
        userLoginButton.addActionListener(this);
        add(userLoginButton);

        adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setBounds(50, 100, 200, 30);
        adminLoginButton.addActionListener(this);
        add(adminLoginButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userLoginButton) {
            UserLogin userLoginFrame = new UserLogin();
            userLoginFrame.setVisible(true);
        } else if (e.getSource() == adminLoginButton) {
            AdminLogin adminLoginFrame = new AdminLogin();
            adminLoginFrame.setVisible(true);
        }
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenuFrame = new MainMenu();
            mainMenuFrame.setVisible(true);
        });
    }
}

class AdminLogin extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, backButton;

    public AdminLogin() {
        setTitle("Admin Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(140, 30, 100, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(140, 70, 100, 25);
        add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 110, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        backButton = new JButton("Back");
        backButton.setBounds(160, 110, 100, 25);
        backButton.addActionListener(this);
        add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userField.getText();
            char[] pass = passField.getPassword();

            if ("admin".equals(user) && "password".equals(new String(pass))) {
                Main mainFrame = new Main();
                mainFrame.setVisible(true);
                dispose();  // Close login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login. Please try again.");
            }
        } else if (e.getSource() == backButton) {
            MainMenu mainMenuFrame = new MainMenu();
            mainMenuFrame.setVisible(true);
            dispose();  // Go back to main menu
        }
    }
}

class UserLogin extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, backButton;

    public UserLogin() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(140, 30, 100, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(140, 70, 100, 25);
        add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 110, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        backButton = new JButton("Back");
        backButton.setBounds(160, 110, 100, 25);
        backButton.addActionListener(this);
        add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            UserProfile userProfileFrame = new UserProfile(userField.getText(), new String(passField.getPassword()));
            userProfileFrame.setVisible(true);
            dispose();
        } else if (e.getSource() == backButton) {
            MainMenu mainMenuFrame = new MainMenu();
            mainMenuFrame.setVisible(true);
            dispose();  // Go back to main menu
        }
    }
}

class UserProfile extends JFrame {
    public UserProfile(String username, String password) {
        setTitle("User Profile");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username: " + username);
        userLabel.setBounds(50, 50, 200, 25);
        add(userLabel);

        JLabel passLabel = new JLabel("Password: " + password);
        passLabel.setBounds(50, 90, 200, 25);
        add(passLabel);
    }
}

class Main extends JFrame implements ActionListener {
    private JButton viewAllButton, createButton, editButton, deleteButton, salaryButton, exitButton;

    public Main() {
        setTitle("CSE-JU Employee Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        viewAllButton = new JButton("View All Employees");
        viewAllButton.setBounds(100, 70, 200, 30);
        viewAllButton.addActionListener(this);
        add(viewAllButton);

        createButton = new JButton("Create Employee");
        createButton.setBounds(100, 110, 200, 30);
        createButton.addActionListener(this);
        add(createButton);

        editButton = new JButton("Edit Employee");
        editButton.setBounds(100, 150, 200, 30);
        editButton.addActionListener(this);
        add(editButton);

        deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(100, 190, 200, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);

        salaryButton = new JButton("Salary Distribution");
        salaryButton.setBounds(100, 230, 200, 30);
        salaryButton.addActionListener(this);
        add(salaryButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 270, 200, 30);
        exitButton.addActionListener(this);
        add(exitButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAllButton) {
            System.out.println("View All Employees selected");
        } else if (e.getSource() == createButton) {
            System.out.println("Create Employee selected");
        } else if (e.getSource() == editButton) {
            System.out.println("Edit Employee selected");
        } else if (e.getSource() == deleteButton) {
            System.out.println("Delete Employee selected");
        } else if (e.getSource() == salaryButton) {
            System.out.println("Salary Distribution selected");
        } else if (e.getSource() == exitButton) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
