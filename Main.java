import java.util.*;
import java.io.*;

// Student Class
class Student {
    private String username;
    private String password;
    private Map<String, Integer> subjects;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
        subjects = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public void addSubject(String subject) {
        subjects.putIfAbsent(subject, 0);
        System.out.println("Subject added!");
    }

    public void addStudyHours(String subject, int hours) {
        if (subjects.containsKey(subject)) {
            subjects.put(subject, subjects.get(subject) + hours);
            System.out.println("Hours updated!");
        } else {
            System.out.println("Subject not found!");
        }
    }

    public void viewProgress() {
        System.out.println("\n--- Progress of " + username + " ---");
        for (String sub : subjects.keySet()) {
            System.out.println(sub + " : " + subjects.get(sub) + " hours");
        }
    }

    public void getSuggestion() {
        int total = 0;
        for (int h : subjects.values()) total += h;

        if (total < 5)
          System.out.println()
            System.out.println("⚠ Study more!");
        else if (total < 15)
            System.out.println("👍 Good!");
        else
            System.out.println("🔥 Excellent!");
    }

    // Save Data
    public void saveData() {
        try {
            FileWriter fw = new FileWriter(username + ".txt");
            for (String sub : subjects.keySet()) {
                fw.write(sub + "," + subjects.get(sub) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving data!");
        }
    }

    // Load Data
    public void loadData() {
        try {
            File file = new File(username + ".txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                subjects.put(parts[0], Integer.parseInt(parts[1]));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading data!");
        }
    }
}

// Main Class
public class Main {
    static Map<String, Student> users = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LOGIN SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    Student user = login();
                    if (user != null) {
                        userMenu(user);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    // Register
    public static void register() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        users.put(user, new Student(user, pass));
        System.out.println("Registration successful!");
    }

    // Login
    public static Student login() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (users.containsKey(user) && users.get(user).checkPassword(pass)) {
            System.out.println("Login successful!");
            Student s = users.get(user);
            s.loadData();
            return s;
        } else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }

    // User Menu (7 Options)
    public static void userMenu(Student s) {
        int choice;

        do {
            System.out.println("\n===== STUDY MENU =====");
            System.out.println("1. Add Subject");
            System.out.println("2. Add Study Hours");
            System.out.println("3. View Progress");
            System.out.println("4. Get Suggestion");
            System.out.println("5. Save Data");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    s.addSubject(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter subject: ");
                    String sub = sc.nextLine();
                    System.out.print("Enter hours: ");
                    int h = sc.nextInt();
                    s.addStudyHours(sub, h);
                    break;
                case 3:
                    s.viewProgress();
                    break;
                case 4:
                    s.getSuggestion();
                    break;
                case 5:
                    s.saveData();
                    System.out.println("Data saved!");
                    break;
                case 6:
                    System.out.println("Logged out!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}