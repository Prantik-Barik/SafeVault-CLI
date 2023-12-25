package views;

import DAO.DataDAO;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private String email = "Test_User";
     UserView(String email) {
        this.email = email;
    }

    public void home()
    {
        do{
            System.out.println("Welcone" + email);
            System.out.println("Press 1 to Show Hidden Files");
            System.out.println("Press 2 to Hide a New File");
            System.out.println("Press 3 to Unhide a File");
            System.out.println("Press 0 to Exit");
            System.out.print("Enter Choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1 : try{
                    List<Data> files = DataDAO.getAllFiles(this.email);
                    System.out.println("ID - File Name");
                    for(Data file : files){
                        System.out.println(file.getId()+" - "+file.getName());
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;
                case 2:
                    System.out.println("Enter File Path : ");
                    String path = sc.nextLine();
                    File f = new File(path);
                    Data file = new Data(0, f.getName(),path,this.email);
                    try {
                        DataDAO.hideFile(file);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    List<Data> files = null;
                    try {
                        files = DataDAO.getAllFiles(this.email);

                        System.out.println("ID - File Name");
                        for (Data fl : files) {
                            System.out.println(fl.getId() + " - " + fl.getName());
                        }
                        System.out.println("Enter the id of file to unhide");
                        int id = Integer.parseInt(sc.nextLine());
                        boolean isValidID = false;
                        for (Data fl : files) {
                            if (fl.getId() == id) {
                                isValidID = true;
                                break;
                            }
                        }
                        if (isValidID) {
                            DataDAO.unhide(id);
                        } else {
                            System.out.println("Wrong ID");
                        }
                    } catch (SQLException  e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4: System.exit(1);
            }
        }while(true);
    }
}
