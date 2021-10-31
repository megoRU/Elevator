import elevator.Elevator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        try {
            System.out.println(elevator);
            System.out.println();
            for (; ; ) {
                Scanner in = new Scanner(System.in);
                System.out.print("Напишите этаж:");
                System.out.println();
                String input = in.nextLine();


                if (input.matches("[0-9]") || input.matches("-[0-9]")) {
                    elevator.changeFloor(Integer.parseInt(input));
                } else {
                    System.err.println("Is not number of floor");
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
