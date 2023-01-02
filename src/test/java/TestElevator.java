import elevator.Elevator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class TestElevator {

    private static Elevator elevator;

    @BeforeAll
    static void setup() {
        elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 1);
    }

    @Test
    @Order(8)
    @DisplayName("Проверяем конструктор")
    void testConstructor() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            elevator = new Elevator(new int[]{}, new int[]{}, 0);
        }, "");

        Assertions.assertEquals("groundFloors == 0 or numberOfFloors == 0", thrown.getMessage());

        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2}, 1);
        }, "");

        Assertions.assertEquals("Подземные этажи должны быть с - : 1", thrown2.getMessage());

        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            elevator = new Elevator(new int[]{-1, -2, -3, 4, 5, 6}, new int[]{-1, -2}, 1);
        }, "");

        Assertions.assertEquals("Надземные этажи не должны быть с - : -1", thrown3.getMessage());


        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            elevator = new Elevator(new int[]{1, 2, 3, 4, 5, 6}, new int[]{-1, -2}, 8);
        }, "");

        Assertions.assertEquals("Неверное значение для currentFloor: 8" +
                "\nОн должен совпадать этим значением: [-1, -2, 1, 2, 3, 4, 5, 6]", thrown4.getMessage());
    }

    @Test
    @Order(7)
    @DisplayName("Проверяем поднятие на тот же самый этаж")
    void testSameFloor() {
        elevator.changeFloor(4);
    }

    @Test
    @Order(6)
    @DisplayName("Проверяем toSting() метод")
    void testToString() {
        assertEquals("""
                Количество этажей: 6
                Цокольных этажей: 2
                Текущий этаж: 4""", elevator.toString());
    }

    @Test
    @Order(5)
    @DisplayName("Проверяем как поднимается лифт с 1 этажа на 4")
    void testGoTo4() {
        elevator.changeFloor(4);
        assertEquals(4, elevator.getCurrentFloor());
    }

    @Test
    @Order(4)
    @DisplayName("Проверяем как поднимается лифт с 4 этажа на -2")
    void testGoFrom4ToMinus2() {
        elevator.changeFloor(-2);
        assertEquals(-2, elevator.getCurrentFloor());
    }

    @Test
    @Order(3)
    @DisplayName("Проверяем как поднимается лифт на несуществующий этаж")
    void testNonExistsFloor() {
        elevator.changeFloor(-6);
        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    @Order(2)
    @DisplayName("Проверяем как поднимается лифт на текущий этаж")
    void Checking_Going_On_Same_Floor() {
        elevator.changeFloor(1);
        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    @Order(1)
    @DisplayName("Проверяем множественные вызовы лифта на этажи")
    void Checking_Multiple_Elevator_Calls() {
        elevator.changeFloor(-2);
        elevator.changeFloor(5);
        elevator.changeFloor(-1);
        elevator.changeFloor(0);
        elevator.changeFloor(4);

        assertEquals(4, elevator.getCurrentFloor());
    }

}