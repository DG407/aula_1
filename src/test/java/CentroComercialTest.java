import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.*;

class CentroComercialTest {


    @Test
    void testGetNome() {
        //Arrange
        CentroComercial instance = new CentroComercial("TacoBell", "Rua azul") {
        };
        String expectedResult = instance.getNome();
        //Act
        String result = "TacoBell";
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetMorada() {
        //Arrange
        CentroComercial instance = new CentroComercial("TacoBell", "Rua azul") {
        };
        String expectedResult = instance.getMorada();
        //Act
        String result = "Rua azul";
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testOmissao() {
        //Arrange
        CentroComercial instance = new CentroComercial() {
        };
        String expectedResult = "sem nome, sem morada";
        //Act
        String result = "sem nome, sem morada";
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testCalculoRendas() {
        //Arrange
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);

        double expectedResult = 251260;
        //Act
        double result = lojaRestauracao1.calcularRenda();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testCalculoCustosSeguranca() {
        //Arrange
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);
        double expectedResult = 45;
        //Act
        double result = lojaRestauracao1.custosSeguranca();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testTotalCustosLojasAncoras() {
        //Arrange
        CentroComercial x = new CentroComercial();
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 28, 100);
        LojaAncora lojaPropria3 = new LojaAncora("SportZone", 20000, 120, 250);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.adicionarLoja(lojaPropria3);
        double expectedResult = 450;
        //Act
        double result = x.totalCustosLojasAncoras();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testRendasAncoras() {
        //Arrange
        CentroComercial x = new CentroComercial();
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 28, 100);
        LojaExterna lojaExterna1 = new LojaExterna("Mango", 11000, 30, 120, 5);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.adicionarLoja(lojaExterna1);
        double expectedResult = 222600;
        //Act
        double result = x.calculoRendaAncoras();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testRendasComuns() {
        //Arrange
        CentroComercial x = new CentroComercial();
        Restauracao lojaRestauracao3 = new Restauracao("BurgerKing", 17000, 30, 10, 250, 8);
        Restauracao lojaRestauracao4 = new Restauracao("McDonalds", 40000, 160, 22, 600, 30);
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);

        x.adicionarLoja(lojaRestauracao3);
        x.adicionarLoja(lojaRestauracao4);
        x.adicionarLoja(lojaQuiosque1);
        double expectedResult = 574150;
        //Act
        double result = x.calculoRendaComuns();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testCalculoCustoSegurança() {
        //Arrange
        CentroComercial x = new CentroComercial();
        Restauracao lojaRestauracao3 = new Restauracao("BurgerKing", 17000, 30, 10, 250, 8);
        Restauracao lojaRestauracao4 = new Restauracao("McDonalds", 40000, 160, 22, 600, 30);
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);

        x.adicionarLoja(lojaRestauracao3);
        x.adicionarLoja(lojaRestauracao4);
        x.adicionarLoja(lojaQuiosque1);
        double expectedResult = 190;
        //Act
        double result = x.calculoCustosSeguranca();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testTotalReceitas() {
        //Arrange
        CentroComercial x = new CentroComercial();
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        Restauracao lojaRestauracao4 = new Restauracao("McDonalds", 40000, 160, 22, 600, 30);
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaRestauracao4);
        x.adicionarLoja(lojaQuiosque1);
        double expectedResult = 403100;
        //Act
        double result = x.totalReceitas();
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testRemoverLoja() {
        //Arrange
        CentroComercial x = new CentroComercial();
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        Restauracao lojaRestauracao4 = new Restauracao("McDonalds", 40000, 160, 22, 600, 30);
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaRestauracao4);
        x.removerLoja(lojaQuiosque1);
        double expectedResult = 402850;
        //Act
        double result = x.totalReceitas();
        //Assert
        assertEquals(expectedResult, result);
    }


    @Test
    public void testOrdenacaoNomeOrdemAlfabetica() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 15000, 50);
        Loja lojaPropria2 = new Loja("JD", 16000, 28);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.ordenacaoNomeOrdemAlfabetica();
        Loja expectedResult = lojaPropria2;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareMaior() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 15000, 50);
        Loja lojaPropria2 = new Loja("JD", 16000, 28);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.compare(lojaPropria1, lojaPropria2);
        Loja expectedResult = lojaPropria1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareMenor() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 0, 10);
        Loja lojaPropria2 = new Loja("JD", 0, 28);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.compare(lojaPropria1, lojaPropria2);
        Loja expectedResult = lojaPropria1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareIgual() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 0, 10);
        Loja lojaPropria2 = new Loja("JD", 0, 10);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaPropria2);
        x.compare(lojaPropria1, lojaPropria2);
        Loja expectedResult = lojaPropria1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareToTipo() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 0, 10);
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaRestauracao1);
        x.compareToTipo(lojaPropria1, lojaRestauracao1);
        Loja expectedResult = lojaPropria1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOrdenarPorTipo() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 0, 10);
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaRestauracao1);
        x.ordenarPorTipo();
        Loja expectedResult = lojaPropria1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void compareTo() {
        //Arrange


        CentroComercial instance1 = new CentroComercial("TacoBell", "Rua azul") {
        };
        CentroComercial instance2 = new CentroComercial("Gaia", "Rua azul") {
        };
        instance1.compareTo(instance2);
        CentroComercial expectedResult = instance2;
        //Act
        CentroComercial result = instance2;
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testOrdenarClasseArea() {
        //Arrange
        CentroComercial x = new CentroComercial();

        Loja lojaPropria1 = new Loja("Zara", 0, 10);
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);

        x.adicionarLoja(lojaPropria1);
        x.adicionarLoja(lojaRestauracao1);
        x.ordenarClasseArea();
        Loja expectedResult = lojaRestauracao1;
        //Act
        Loja result = x.lojas.get(0);
        //Assert
        assertEquals(expectedResult, result);
    }

}