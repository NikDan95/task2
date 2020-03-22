import java.io.*;
import java.util.Scanner;

public class Main  {

    private static File file = new File("C:\\Users\\dell\\Desktop\\new\\users.txt");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean b = true;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));


            while (b) {
                String str = reader.readLine();
                if (str != null) {
                    String[] s = str.split(",");
                    UserManager.add(UserManager.users,new User(s[0], s[1], Integer.parseInt(s[2])));
                } else break;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        commandsControl();


    }

    public static void commandsControl() {

        boolean b = true;
        while (b) {
            try {
                switch (Commands.valueOf(scanner.next().toUpperCase())) {
                    case ADD: {
                        UserManager.add();
                        break;
                    }
                    case REMOVE: {
                        UserManager.remove();
                        break;
                    }
                    case LIST: {
                        UserManager.list();
                        break;
                    }
                    case EXIT: {
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                            b=UserManager.exit(writer);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            System.exit(0);
                        }

                    }

                }
            }
            catch (IllegalArgumentException e){

            }
        }
    }
}
