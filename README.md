# SafeVault | _A File Hider CLI App_

### Overview
---

> **Welcome to the SafeVault App**, a Java-based marvel that elevates file security to an art form. This application seamlessly integrates the power of **MySQL** for data storage and the **Java Mail API** for an added layer of authentication, providing a sophisticated solution to discreetly hide and manage your files.

> **Imagine a world where your sensitive documents are tucked away in a secure MySQL database, shielded from prying eyes**, picture the convenience of a command-line interface that empowers you to effortlessly hide, view, and unhide files with just a few keystrokes. The SafeVault CLI App is not just a utility; it's your digital vault, offering a blend of robust functionality and elegant simplicity.

### Features
---
- **File Hiding:** Safeguard your sensitive files within the fortress of a MySQL database.
- **Java Mail API Integration:** Fortify your security with authentication emails, ensuring that only you hold the key.
- **MySQL Database Storage:** Efficiently store and retrieve hidden files, creating an organized haven for your data.
- **Command Line Interface (CLI):** Immerse yourself in a user-friendly command-line experience for seamless interactions.

### Usage
---
**1. Authentication**

``Before using the SafeVault File Hider, authenticate yourself by providing your email:``

>Implementing authentication using OTP (One-Time Password) via email with JavaMail API while authenticating the user against the  MySQL database and also while accesing the hidden files.

**2. Hide Files**

``To hide files, give the file path into the CLI and your file will be uploaded to the database and hidden:``

>Using our CLI App there are options provided to provide the file path of the file user wants to hide , on giving the accurate file path, the file will be hidden from the user's location and safe in the database. 

**3. Remove Hidden Files**

``Unhide the hidden file just with a click``

>Using our CLI App there are options provided to provide the id of the hidden file user wants to unhide . On giving the accurate file id, the file will be written into the user's original location and deleted from the database.

### Screens @SecureVault
---

- Home Screen

  ![register-screen](https://github.com/Prantik-Barik/SafeVault-CLI/assets/107944461/ebfb9aa6-9ba9-497f-85ef-637f1214056f)

  ![login-screen](https://github.com/Prantik-Barik/SafeVault-CLI/assets/107944461/2b87c12d-40b8-4e5e-add3-78c3641ce050)

- File Hidding Menu

  ![file_menu](https://github.com/Prantik-Barik/SafeVault-CLI/assets/107944461/e31374d4-6ef3-470a-bd86-657d9b446f7d)
    
- Authentication Mail

  ![mail-screen](https://github.com/Prantik-Barik/SafeVault-CLI/assets/107944461/a6ea5eae-de39-4881-8494-a285b316ac7c)

- MySQL Database 
    
  ![sql_screen](https://github.com/Prantik-Barik/SafeVault-CLI/assets/107944461/9b27c7d3-29a9-4161-a72f-a88935e94f3f)

