# 📚 Student Study Tracker

A console-based Java mini project built using **Object-Oriented Programming (OOP)** concepts. Students can register, log in, track study hours per subject, view progress, and save/load their data locally.

---

## 🚀 Features

- 🔐 User Registration & Login with password validation
- ➕ Add subjects to your personal study list
- ⏱️ Log study hours per subject
- 📊 View total progress across all subjects
- 💡 Get motivational suggestions based on total study hours
- 💾 Save and load data from a local `.txt` file
- 🚪 Logout and session management

---

## 🛠️ Tech Stack

| Technology | Details          |
|------------|------------------|
| Language   | Java             |
| Paradigm   | Object-Oriented  |
| Storage    | Local `.txt` file (File I/O) |
| Input      | Console (`Scanner`) |

---

## 🗂️ Project Structure

```
StudyTracker/
├── Main.java          # Entry point — login system & menu logic
└── Student.java       # Student class — OOP core (data + methods)
```

> Both classes are in the same file in the submitted version.

---

## 🧱 OOP Concepts Used

| Concept        | Where Applied |
|----------------|---------------|
| **Class & Object** | `Student` class with instances per user |
| **Encapsulation** | Private fields (`username`, `password`, `subjects`) with getters |
| **Abstraction** | Methods like `addSubject()`, `viewProgress()`, `getSuggestion()` hide internal logic |
| **HashMap** | Stores subject-to-hours mapping inside each Student object |
| **File I/O** | `saveData()` and `loadData()` persist user data across sessions |

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or above installed
- Any IDE (IntelliJ, Eclipse, VS Code) or terminal

### Steps

```bash
# 1. Clone or download the project
# 2. Navigate to the project folder

# 3. Compile
javac Main.java

# 4. Run
java Main
```

---

## 🖥️ Usage Walkthrough

### Main Menu
```
===== LOGIN SYSTEM =====
1. Register
2. Login
3. Exit
```

### Study Menu (after login)
```
===== STUDY MENU =====
1. Add Subject
2. Add Study Hours
3. View Progress
4. Get Suggestion
5. Save Data
6. Logout
```

### Sample Session
```
> Register → username: alice, password: 1234
> Login    → alice / 1234
> Add Subject → "Mathematics"
> Add Study Hours → Mathematics, 6 hours
> View Progress →
    Mathematics : 6 hours
> Get Suggestion → 👍 Good!
> Save Data → alice.txt is created
```

---

## 💡 Suggestion Logic

| Total Hours Studied | Message        |
|---------------------|----------------|
| Less than 5 hours   | ⚠ Study more! |
| 5 – 14 hours        | 👍 Good!       |
| 15+ hours           | 🔥 Excellent!  |

---

## 💾 Data Storage

Each student's data is saved to a local text file named `<username>.txt`.

**Format:**
```
Mathematics,6
Physics,3
Chemistry,10
```

Data is automatically loaded when the user logs in again.

---

## 🐛 Known Bug (to fix)

In `getSuggestion()`, there is a missing semicolon on the `System.out.println()` line:

```java
// ❌ Current (broken)
if (total < 5)
  System.out.println()       // ← missing semicolon
    System.out.println("⚠ Study more!");

// ✅ Fixed
if (total < 5)
    System.out.println("⚠ Study more!");
```

---

## 🔮 Future Improvements

- [ ] Add password encryption (hashing)
- [ ] Store all users in a single database file
- [ ] Add study goals per subject
- [ ] Add weekly/monthly progress tracking
- [ ] Build a GUI using Java Swing or JavaFX

---

## 👨‍💻 Author

> Built as a Java OOP mini project.  
> Feel free to fork, improve, and extend!

---

## 📄 License

This project is open source and free to use for educational purposes.
