import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
                AdminMain adminMainFrame = new AdminMain();
                adminMainFrame.setVisible(true);
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
            String username = userField.getText();
            String password = new String(passField.getPassword());
            Employee employee = AdminMain.getEmployee(username, password);
            if (employee != null) {
                UserProfile userProfileFrame = new UserProfile(employee);
                userProfileFrame.setVisible(true);
                dispose();
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

class UserProfile extends JFrame {
    public UserProfile(Employee employee) {
        setTitle("User Profile");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username: " + employee.getUsername());
        userLabel.setBounds(50, 30, 300, 25);
        add(userLabel);

        JLabel nameLabel = new JLabel("Name: " + employee.getName());
        nameLabel.setBounds(50, 70, 300, 25);
        add(nameLabel);

        JLabel designationLabel = new JLabel("Designation: " + employee.getDesignation());
        designationLabel.setBounds(50, 110, 300, 25);
        add(designationLabel);

        JLabel emailLabel = new JLabel("Email: " + employee.getEmail());
        emailLabel.setBounds(50, 150, 300, 25);
        add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone: " + employee.getPhoneNumber());
        phoneLabel.setBounds(50, 190, 300, 25);
        add(phoneLabel);

        JLabel bloodGroupLabel = new JLabel("Blood Group: " + employee.getBloodGroup());
        bloodGroupLabel.setBounds(50, 230, 300, 25);
        add(bloodGroupLabel);

        JLabel workLabel = new JLabel("Daily Work: " + employee.getDailyWork());
        workLabel.setBounds(50, 270, 300, 25);
        add(workLabel);

        JLabel salaryLabel = new JLabel("Monthly Salary: " + employee.getMonthlySalary());
        salaryLabel.setBounds(50, 310, 300, 25);
        add(salaryLabel);
    }
}

class AdminMain extends JFrame implements ActionListener {
    private JButton viewAllButton, createButton, editButton, deleteButton, salaryButton, exitButton, backButton;
    private static Map<String, Employee> employees;

    public AdminMain() {
        setTitle("CSE-JU Employee Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        employees = new HashMap<>();

        viewAllButton = new JButton("View All Employees");
        viewAllButton.setBounds(100, 50, 200, 30);
        viewAllButton.addActionListener(this);
        add(viewAllButton);

        createButton = new JButton("Create Employee");
        createButton.setBounds(100, 90, 200, 30);
        createButton.addActionListener(this);
        add(createButton);

        editButton = new JButton("Edit Employee");
        editButton.setBounds(100, 130, 200, 30);
        editButton.addActionListener(this);
        add(editButton);

        deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(100, 170, 200, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);

        salaryButton = new JButton("Salary Distribution");
        salaryButton.setBounds(100, 210, 200, 30);
        salaryButton.addActionListener(this);
        add(salaryButton);

        backButton = new JButton("Back to Main Menu");
        backButton.setBounds(100, 250, 200, 30);
        backButton.addActionListener(this);
        add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 290, 200, 30);
        exitButton.addActionListener(this);
        add(exitButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAllButton) {
            viewAllEmployees();
        } else if (e.getSource() == createButton) {
            createEmployee();
        } else if (e.getSource() == editButton) {
            System.out.println("Edit Employee selected");
        } else if (e.getSource() == deleteButton) {
            System.out.println("Delete Employee selected");
        } else if (e.getSource() == salaryButton) {
            System.out.println("Salary Distribution selected");
        } else if (e.getSource() == backButton) {
            MainMenu mainMenuFrame = new MainMenu();
            mainMenuFrame.setVisible(true);
            dispose();
        } else if (e.getSource() == exitButton) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    private void createEmployee() {
        JTextField nameField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField bloodGroupField = new JTextField();
        JTextField dailyWorkField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Designation:", designationField,
                "Email:", emailField,
                "Phone Number:", phoneField,
                "Blood Group:", bloodGroupField,
                "Daily Work:", dailyWorkField,
                "Monthly Salary:", salaryField,
                "Username:", usernameField,
                "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Create Employee", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Employee newEmployee = new Employee(
                    nameField.getText(),
                    designationField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    bloodGroupField.getText(),
                    dailyWorkField.getText(),
                    salaryField.getText(),
                    usernameField.getText(),
                    passwordField.getText()
            );
            employees.put(usernameField.getText(), newEmployee);
            JOptionPane.showMessageDialog(this, "Employee created successfully!");
        }
    }

    private void viewAllEmployees() {
        StringBuilder employeeDetails = new StringBuilder();
        for (Employee employee : employees.values()) {
            employeeDetails.append(employee).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, employeeDetails.toString(), "All Employees", JOptionPane.INFORMATION_MESSAGE);
    }

    public static Employee getEmployee(String username, String password) {
        Employee employee = employees.get(username);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }
}

class Employee {
    private String name;
    private String designation;
    private String email;
    private String phoneNumber;
    private String bloodGroup;
    private String dailyWork;
    private String monthlySalary;
    private String username;
    private String password;

    public Employee(String name, String designation, String email, String phoneNumber, String bloodGroup, String dailyWork, String monthlySalary, String username, String password) {
        this.name = name;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
        this.dailyWork = dailyWork;
        this.monthlySalary = monthlySalary;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getDailyWork() {
        return dailyWork;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDesignation: " + designation + "\nEmail: " + email + "\nPhone Number: " + phoneNumber +
                "\nBlood Group: " + bloodGroup + "\nDaily Work: " + dailyWork + "\nMonthly Salary: " + monthlySalary;
    }
}
