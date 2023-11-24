/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement71;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class CheckInput {

    static Scanner sc = new Scanner(System.in);

    public static String inputStr(String msg) {

        String a = new String();
        boolean input = true;

        while (input) {
            try {
                System.out.println("");
                System.out.println(msg);
                sc = new Scanner(System.in);
                a = sc.nextLine().trim();
                if (a.isEmpty()) {
                    System.out.println("No accept for null string! "
                            + "Please enter again!");
                    continue;
                }
                input = false;
            } catch (InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }

        return a;

    }

    public static String inputPattern(String msg, String pattern) {

        String a = new String();

        boolean inputDeny = true;

        System.out.println(msg);
        while (inputDeny) {
            try {
                sc = new Scanner(System.in);
                a = sc.nextLine().trim();
                if (a.isEmpty() || !a.matches(pattern)) {
                    System.out.println("This string must be in right format!");
                    System.out.println("Please enter again!");
                    continue;
                }
                inputDeny = false;
            } catch (InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }

        return a;

    }

    public static int inputInt(String msg) {

        int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.println(msg);
                sc = new Scanner(System.in);
                a = sc.nextInt();
                if (a <= 0) {
                    System.out.println("Please input number greater than zero.");
                    System.out.print("Enter again: ");
                    continue;
                }
                inputter = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please input number greater than zero.");
                System.out.print("Enter again: ");
            }
        }

        return a;

    }

    public static int minMax() {
        boolean input = true;
        int choice = 0;
        while (input) {
            try {
                sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Must be input integer 1 to 4.");
                    System.out.print("Enter again: ");
                    continue;
                }
                input = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
        return choice;
    }

    public static String inputTaskTypeID(String msg) {
        while (true) {
            System.out.println(msg);
            int ID = minMax();
            String TaskType = null;
            switch (ID) {
                case 1:
                    TaskType = "Code";
                    break;
                case 2:
                    TaskType = "Test";
                    break;
                case 3:
                    TaskType = "Design";
                    break;
                case 4:
                    TaskType = "Review";
                    break;
            }
            return TaskType;
        }

    }

    public static String inputTimeFrom(String msg) {
        String time;
        while (true) {
            try {
                System.out.println(msg);
                time = sc.nextLine();

                if (Double.parseDouble(time) >= 8 && Double.parseDouble(time) <= 17.5) {
                    if (Double.parseDouble(time) % 0.5 == 0) {

                        break;
                    } else {
                        System.out.println("end must be .0 or .5 ");
                    }

                } else {
                    System.out.println("within 8 h-17 h 30");
                }
            } catch (Exception e) {
                System.out.println(" Input Again");
            }
        }
        return time;
    }

    public static String inputTimeTo(String PlanFrom, String msg) {
        String time;
        while (true) {
            try {

                System.out.println(msg);
                time = sc.nextLine();
                if (Double.parseDouble(time) >= 8 && Double.parseDouble(time) <= 17.5) {
                    
                    if (Double.parseDouble(time) > Double.parseDouble(PlanFrom) && Double.parseDouble(time) % 0.5 == 0) {
                        break;
                    } else {
                        System.out.println("Plan From must less Plan To and end must be .0 or .5 ");
                    }

                } else {
                    System.out.println("within 8 h -17 h 30 ");
                }
            } catch (Exception e) {
                System.out.println("Input Again");
            }
        }
        return time;
    }

    public static String inputDate(String msg) {
        
        sc = new Scanner(System.in);       
        
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        format1.setLenient(false);
        
        Date date= new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            try {
                System.out.println(msg);                
                date = format1.parse(sc.nextLine());
               break;
            } catch (Exception e) {
                System.out.println("Input false. Again");

            }
        }
      return format1.format(date);
    }

}
