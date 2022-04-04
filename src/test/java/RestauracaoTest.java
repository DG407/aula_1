import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauracaoTest {
    @Test

    void testOmissao() {
        //Arrange
        Restauracao lojaRestauracao2 = new Restauracao();

        String expectedResult = "sem nome, sem morada, 0, 0";
        //Act
        String result = "sem nome, sem morada, 0, 0";
        //Assert
        assertEquals(expectedResult, result);
    }


    @Test
    void calcularRenda() {
        //Arrange
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);
        double expectedResult = 251260;
        //Act
        double result = lojaRestauracao1.calcularRenda();
        //Assert
        assertEquals(expectedResult, result);

    }

   //@Test
   //void testToString() {
   //    //Arrange
   //    Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);
   //    String expectedResult = "A loja  TacoBell, com identificação  LC 3, tem um volume de receitas 25000,00€, uma àrea de 26,00 metros quadrados , um custo de manutenção de 300,00€, 10 funcionários e 9 mesas. \n";
   //    //Act
   //    String result = lojaRestauracao1.toString();
   //    //Assert
   //    assertEquals(expectedResult, result);
   //}
}