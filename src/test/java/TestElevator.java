import elevator.Elevator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestElevator {

    private static Elevator elevator;

    @Test
    @DisplayName("Проверяем toSting() метод")
    public void Checking_To_String() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);

        assertEquals("""
                Количество этажей: 6
                Цокольных этажей: 2
                Текущий этаж: 1""", elevator.toString());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт с 1 этажа на 4")
    public void Checking_Going_Up_To_4() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        elevator.changeFloor(4);

        assertEquals(4, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт с 4 этажа на -2")
    public void Checking_Down_To_Minus_2() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        elevator.changeFloor(-2);

        assertEquals(-2, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт на несуществующий этаж")
    public void Checking_Going_Up_To_Non_Existent() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        elevator.changeFloor(-6);

        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт на текущий этаж")
    public void Checking_Going_On_Same_Floor() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        elevator.changeFloor(1);

        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем множественные вызовы лифта на этажи")
    public void Checking_Multiple_Elevator_Calls() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
        elevator.changeFloor(-2);
        elevator.changeFloor(5);
        elevator.changeFloor(-1);
        elevator.changeFloor(0);
        elevator.changeFloor(4);

        assertEquals(4, elevator.getCurrentFloor());
    }

}