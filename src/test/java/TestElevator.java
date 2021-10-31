import elevator.Elevator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestElevator {

    private static Elevator elevator;

    @BeforeAll
    static void setUp() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт с 1 этажа на 4")
    public void Checking_Going_Up_To_4() {
        elevator.changeFloor(4);

        assertEquals(4, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт с 4 этажа на -2")
    public void Checking_Down_To_Minus_2() {
        elevator.changeFloor(-2);

        assertEquals(-2, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт на несуществующий этаж")
    public void Checking_Going_Up_To_Non_Existent() {
        elevator.changeFloor(-6);

        assertEquals(-2, elevator.getCurrentFloor());
    }

    @Test
    @DisplayName("Проверяем как поднимается лифт на текущий этаж")
    public void Checking_Going_On_Same_Floor() {
        elevator.changeFloor(-2);

        assertEquals(-2, elevator.getCurrentFloor());
    }

}
