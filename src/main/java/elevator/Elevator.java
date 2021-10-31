package elevator;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Elevator {

    private final int[] numberOfFloors;
    private final int[] groundFloors;

    private int currentFloor;

    public Elevator(int[] numberOfFloors, int[] groundFloors, int currentFloor) {
        this.numberOfFloors = numberOfFloors;
        this.groundFloors = groundFloors;
        this.currentFloor = currentFloor;
    }


    public void changeFloor(final int selectedFloor) {

        if (Arrays.stream(numberOfFloors).noneMatch(i -> i == selectedFloor) &&
                Arrays.stream(groundFloors).noneMatch(i -> i == selectedFloor)) {
            System.out.println("Вы выбрали неверный этаж");
            return;
        }

        if (currentFloor == selectedFloor) {
            System.out.println("Вы выбрали тот же самый этаж");
            return;
        }

        if (selectedFloor > currentFloor) {
            for (int i = currentFloor; i <= selectedFloor; ++i) {

                if (currentFloor == 0) {
                    ++currentFloor;
                } else {
                    ++currentFloor;
                }

                if (currentFloor == selectedFloor) {
                    System.out.println("Приехал на этаж: " + currentFloor);
                    return;
                }

                if (currentFloor != 0) {
                    System.out.println("Поднялся на этаж: " + currentFloor);
                }

            }

        } else {
            for (int i = currentFloor; i >= selectedFloor; --i) {

                if (currentFloor == 0) {
                    --currentFloor;
                } else {
                    --currentFloor;
                }

                if (currentFloor == selectedFloor) {
                    System.out.println("Приехал на этаж: " + currentFloor);
                    return;
                }

                if (currentFloor != 0) {
                    System.out.println("Спустился на этаж: " + currentFloor);
                }

            }
        }
    }

    @Override
    public String toString() {
        return
                "Количество этажей: " + numberOfFloors.length +
                        "\nЦокольных этажей: " + groundFloors.length +
                        "\nТекущий этаж: " + currentFloor + "";
    }

}
