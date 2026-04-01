# 🔐 JavaFX Login System

A simple Login & Signup system built with **JavaFX**, featuring multi-screen navigation, user registration, authentication, and a styled UI.

---

## ✨ Features

- ✅ User **Signup** — register with username & password
- ✅ User **Login** — authenticate with registered credentials
- ✅ **Duplicate username** prevention on signup
- ✅ **Form validation** — empty field detection with alerts
- ✅ **Screen navigation** — Login → Dashboard / Login → Signup
- ✅ **Dashboard** — displays logged-in username & password
- ✅ Custom **CSS styling** with red theme
- ✅ Password field masking

---

## 🛠️ Built With

- **Java 21**
- **JavaFX 21**
- **FXML** — for UI layout
- **CSS** — for custom styling
- **Maven** — for dependency management

---

## 📁 Project Structure

```
Login/
└── src/
    └── main/
        ├── java/
        │   └── com/example/login/
        │       ├── HelloApplication.java   # App entry point (600x400 window)
        │       ├── HelloController.java    # Login screen controller
        │       ├── signupControl.java      # Signup screen controller
        │       └── screenControl.java      # Dashboard controller
        └── resources/
            └── com/example/login/
                ├── login.fxml              # Login screen UI
                ├── signup.fxml             # Signup screen UI
                ├── display.fxml            # Dashboard UI
                └── style.css              # App styling
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- JavaFX SDK 21
- Maven 3.8+



---

## 🔄 App Flow

```
Launch App
    │
    ▼
Login Screen
    ├── No account? ──► Signup Screen ──► Create Account ──► Back to Login
    │
    └── Have account? ──► Enter credentials
                              │
                    ┌─────────┴─────────┐
                    ▼                   ▼
              ✅ Success            ❌ Failure
           Go to Dashboard       Show Error Alert
           (shows username
            & password)
```

---

## 📋 How Authentication Works

Users are stored **in-memory** using two `ArrayList`s in `HelloController`:

```java
static ArrayList<String> usernames = new ArrayList<>();
static ArrayList<String> passwords = new ArrayList<>();
```

- **Signup** → adds username & password to the lists (rejects duplicates)
- **Login** → checks if username exists, then matches the password

> ⚠️ **Note:** Data is stored in memory only. All accounts are lost when the app is closed. For persistence, consider adding a database (SQLite, MySQL) in a future version.

---

## 🖥️ Screens

| Screen | Controller | FXML |
|--------|------------|------|
| Login | `HelloController` | `login.fxml` |
| Signup | `signupControl` | `signup.fxml` |
| Dashboard | `screenControl` | `display.fxml` |

---

## 🎨 Styling

- Background color: `#d21212` (red theme)
- External CSS file: `style.css`
- Applied on both Login and Signup screens via `initialize()`

---

## 🔮 Future Improvements

- [ ] Persistent storage with a database
- [ ] Password hashing for security
- [ ] Remember me / session management
- [ ] Forgot password feature
- [ ] Input validation (email format, password strength)

---

## 📄 License

This project is open source and available for everyone to use.

---
