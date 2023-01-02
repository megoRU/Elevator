package elevator;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Elevator {

    private final int[] numberOfFloors;
    private final int[] groundFloors;
    private final ArrayList<Integer> allFloors;
    private int currentFloor;

    public Elevator(int[] numberOfFloors, int[] groundFloors, int currentFloor) {
        if (groundFloors.length == 0 || numberOfFloors.length == 0)
            throw new IllegalArgumentException("groundFloors == 0 or numberOfFloors == 0");

        allFloors = new ArrayList<>(groundFloors.length + numberOfFloors.length);

        for (int groundFloor : groundFloors) {
            if (String.valueOf(groundFloor).matches("\\d{1,2}")) {
                throw new IllegalArgumentException("Подземные этажи должны быть с - : " + groundFloor);
            }
            allFloors.add(groundFloor);
        }

        for (int numberOfFloor : numberOfFloors) {
            if (String.valueOf(numberOfFloor).matches("-\\d{1,2}")) {
                throw new IllegalArgumentException("Надземные этажи не должны быть с - : " + numberOfFloor);
            }
            allFloors.add(numberOfFloor);
        }

        if (!allFloors.contains(currentFloor))
            throw new IllegalArgumentException("Неверное значение для currentFloor: " + currentFloor + "\n"
                    + "Он должен совпадать этим значением: " + allFloors);

        this.numberOfFloors = numberOfFloors;
        this.groundFloors = groundFloors;
        this.currentFloor = currentFloor;
    }

    public void changeFloor(final int selectedFloor) {

        if (!allFloors.contains(selectedFloor)) {
            System.out.println("Вы выбрали неверный этаж");
            return;
        }

        if (currentFloor == selectedFloor) {
            System.out.println("Вы выбрали тот же самый этаж");
            return;
        }

        if (selectedFloor > currentFloor) {
            for (int i = currentFloor; i <= selectedFloor; i++) {

                ++currentFloor; //логика движение лифта вверх
                if (currentFloor == 0) {
                    ++currentFloor; //не учитываем за движение лифта
                }

                if (currentFloor == selectedFloor) {
                    System.out.println("Приехал на этаж: " + currentFloor);
                    return;
                }

                System.out.println("Поднялся на этаж: " + currentFloor);

            }

        } else {
            for (int i = currentFloor; i >= selectedFloor; i--) {

                --currentFloor; //логика движение лифта вниз
                if (currentFloor == 0) {
                    --currentFloor; //не учитываем за движение лифта
                }

                if (currentFloor == selectedFloor) {
                    System.out.println("Приехал на этаж: " + currentFloor);
                    return;
                }

                System.out.println("Спустился на этаж: " + currentFloor);

            }
        }
    }

    @Override
    public String toString() {
        return
                "Количество этажей: " + getNumberOfFloors().length +
                        "\nЦокольных этажей: " + getGroundFloors().length +
                        "\nТекущий этаж: " + getCurrentFloor() + "";
    }

}
