import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

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
        loginButton.setBounds(100, 110, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        char[] pass = passField.getPassword();

        // Simple authentication logic
        if ("admin".equals(user) && "password".equals(new String(pass))) {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
            dispose();  // Close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login. Please try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminLogin loginFrame = new AdminLogin();
            loginFrame.setVisible(true);
        });
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
            // Call view all employees method
            System.out.println("View All Employees selected");
        } else if (e.getSource() == createButton) {
            // Call create employee method
            System.out.println("Create Employee selected");
        } else if (e.getSource() == editButton) {
            // Call edit employee method
            System.out.println("Edit Employee selected");
        } else if (e.getSource() == deleteButton) {
            // Call delete employee method
            System.out.println("Delete Employee selected");
        } else if (e.getSource() == salaryButton) {
            // Call salary distribution method
            System.out.println("Salary Distribution selected");
        } else if (e.getSource() == exitButton) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}

