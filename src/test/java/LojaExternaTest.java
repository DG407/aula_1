import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LojaExternaTest {

    @Test
    void calcularRenda() {
        //Arrange
        LojaExterna lojaExterna1 = new LojaExterna("Mango", 11000, 30, 120, 5);
        double expectedResult = 222600;
        //Act
        double result = lojaExterna1.calcularRenda();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testToString() {
        //Arrange
        LojaExterna lojaExterna1 = new LojaExterna("Mango", 11000, 30, 120, 5);
        String expectedResult = lojaExterna1.toString();
        //Act
        String result = "A loja  Mango, com identificação LC 5, tem um volume de receitas 11000,00€, custos com segurança de 120,00€ 5 funcionários e uma renda fixa de 2000,00€. \n";
        //Assert
        assertEquals(expectedResult, result);
    }
    @Test
    void testGetQtdFuncionarios() {
        //Arrange
        LojaExterna lojaExterna1 = new LojaExterna("Mango", 11000, 30, 120, 5);

        double expectedResult = lojaExterna1.getQtdFuncionarios();
        //Act
        double result = 5;
        //Assert
        assertEquals(expectedResult, result);
    }
}