import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LojaTest {

    @Test
    void getVolumeReceitas() {
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 28, 100);
        double expectedResult = 16000;
        //Act
        double result = lojaPropria2.getVolumeReceitas();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testClassificacaoAreaMedia() {
        //Arrange
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 50, 100);
        String expectedResult = lojaPropria2.classificacaoArea();
        //Act
        String result = "Média";
        //Assert
        assertEquals(expectedResult, result);
    }
    @Test
    void testClassificacaoAreaPequena() {
        //Arrange
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 10, 100);
        String expectedResult = lojaPropria2.classificacaoArea();
        //Act
        String result = "Pequena";
        //Assert
        assertEquals(expectedResult, result);
    }
    @Test
    void testClassificacaoAreaGrande() {
        //Arrange

        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 200, 100);
        String expectedResult = lojaPropria2.classificacaoArea();
        //Act
        String result = "Grande";
        //Assert
        assertEquals(expectedResult, result);
    }
}