import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LojaAncoraTest {

    @Test
    void testToString() {
        //Arrange
        int cont = LojaAncora.getQtdLojaAncora();
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        String expectedResult = "A loja  Zara, com identificação LA: " + (cont +1) + ", tem um volume de receitas 15000,00€  e custos com segurança de 100,00€. \n";
        //Act
        String result = lojaPropria1.toString();
        //Assert
        assertEquals(expectedResult, result);
    }
}