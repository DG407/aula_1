import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuiosqueTest {

    @Test
    void calcularRenda() {
        //Arrange
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);
        double expectedResult = 250;
        //Act
        double result = lojaQuiosque1.calcularRenda();
        //Assert
        assertEquals(expectedResult, result);

    }

    @Test
    void testToString() {
        //Arrange
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);

        String expectedResult = "A loja  Quiosque A, com identificação LC 1, tem um volume de receitas 9000,00€, uma àrea de 19,00 metros quadrados e 2 funcionários. \n";
        //Act
        String result = lojaQuiosque1.toString();
        //Assert
        assertEquals(expectedResult, result);
    }


}