package views;

import DAO.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTP;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen()
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to SafeVault - File Hider ");
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Sign Up");
        System.out.println("Press 0 to Exit");
        choice = sc.nextInt();
        switch(choice)
        {
            case 1: login();
                    break;
            case 2: signup();
                    break;
            case 0: System.exit(0);
        }
    }

    private void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        //send OTP for email verification
        String genOTP = GenerateOTP.getOTP();
        SendOTP.sendOTP(email,genOTP);
        System.out.println("Enter the OTP : ");
        String otp = sc.nextLine();
        if(otp.equals(genOTP)){
            User user = new User(name, email);
            int response = UserService.saveUser(user);
            switch(response){
                case 1 :
                    System.out.println("User Registered");
                    break;
                case 0:
                    System.out.println("User Already Exists");
                    break;
            }
        }
        else{
            System.out.println("Wrong OTP");
        }
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Email: ");
        String email = sc.nextLine();
        System.out.println("Sending OTP ....");
        try {
            if(UserDAO.isExists(email)){
                String genOTP = GenerateOTP.getOTP();
                SendOTP.sendOTP(email,genOTP);
                System.out.println("Enter the OTP : ");
                String otp = sc.nextLine();
                if(otp.equals(genOTP)){
                    new UserView(email).home();
                }
                else{
                    System.out.println("Wrong OTP");
                }
            }
            else{
                System.out.println("User Not Found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
