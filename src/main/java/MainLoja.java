import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainLoja {
    public static void main(String[] args) throws FileNotFoundException {
        //CRIAÇÂO INTANCIA CENTROS COMERCIAIS
        CentroComercial centroComercial1 = new CentroComercial("GaiaShopping", "Rua do Padre Miguel");

        //CRIAÇÂO DE INSTANCIAS LOJAS
        LojaAncora lojaPropria1 = new LojaAncora("Zara", 15000, 50, 100);
        LojaAncora lojaPropria2 = new LojaAncora("JD", 16000, 28, 100);
        LojaAncora lojaPropria3 = new LojaAncora("SportZone", 20000, 120, 250);
        LojaExterna lojaExterna1 = new LojaExterna("Mango", 11000, 30, 120, 5);
        Restauracao lojaRestauracao1 = new Restauracao("TacoBell", 25000, 26, 10, 300, 9);
        Restauracao lojaRestauracao2 = new Restauracao("PizzaHut", 21000, 190, 18, 500, 20);
        Restauracao lojaRestauracao3 = new Restauracao("BurgerKing", 17000, 30, 10, 250, 8);
        Restauracao lojaRestauracao4 = new Restauracao("McDonalds", 40000, 160, 22, 600, 30);
        Quiosque lojaQuiosque1 = new Quiosque("Quiosque A", 9000, 19, 2);
        Quiosque lojaQuiosque2 = new Quiosque("Quiosque B", 7500, 20, 2);
        Quiosque lojaQuiosque3 = new Quiosque("Quiosque C", 11000, 30, 4);


        //ALTERAÇÂO DA TAXA PAGA POR CADA MESA
        Restauracao.setTxSeguranca(7);

        //APRESENTAÇÂO NOME CENTRO COMERCIAL
        System.out.println("###Nome do Centro Comercial###");
        System.out.println(centroComercial1.getNome());
        System.out.println("\n");

        //ADICIONAR INSTANCIAS AO ARRAYLIST
        centroComercial1.adicionarLoja(lojaPropria1);
        centroComercial1.adicionarLoja(lojaPropria2);
        centroComercial1.adicionarLoja(lojaPropria3);
        centroComercial1.adicionarLoja(lojaExterna1);
        centroComercial1.adicionarLoja(lojaRestauracao1);
        centroComercial1.adicionarLoja(lojaRestauracao2);
        centroComercial1.adicionarLoja(lojaRestauracao3);
        centroComercial1.adicionarLoja(lojaRestauracao4);
        centroComercial1.adicionarLoja(lojaQuiosque1);
        centroComercial1.adicionarLoja(lojaQuiosque2);
        centroComercial1.adicionarLoja(lojaQuiosque3);
        System.out.println("### Número de lojas armazenadas###");
        //NUMERO DE LOJAS ARMAZENADAS
        System.out.println(centroComercial1.lojas.size());
        System.out.println("\n");

        System.out.println("###Calculo da renda das lojas âncora###");
        //RENDAS LOJAS ANCORAS
        System.out.println(centroComercial1.calculoRendaAncoras()+"€");
        System.out.println("\n");
        //RENDAS LOJAS COMUM
        System.out.println("###Calculo da renda das lojas comuns###");
        System.out.println(centroComercial1.calculoRendaComuns()+"€");
        System.out.println("\n");
        System.out.println("###Calculo do total dos custos de segurança###");
        //TOTAL CUSTOS SEGURANÇA
        System.out.println(centroComercial1.calculoCustosSeguranca()+"€");
        System.out.println("\n");
        System.out.println("###Calculo do total das receitas do Centro Comercial###");
        //TOTAL DE RECEITAS DO CENTRO COMERCIAL
        System.out.println(centroComercial1.totalReceitas()+"€");
        System.out.println("\n");
        System.out.println("###Calculo do percentual das despesas das rendas das lojas âncora###");
        //PESO DE DESPESAS RENDAS LOJAS ANCORAS
        System.out.printf(centroComercial1.totalCustosLojasAncoras() / centroComercial1.totalReceitas() * 100+"%% ");
        System.out.println("\n");
        System.out.println("###Calculo do percentual das despesas das rendas das lojas comuns###");
        //PESO DE DESPESAS RENDAS LOJAS COMUNS
        System.out.printf((1 - (centroComercial1.totalCustosLojasAncoras() / centroComercial1.totalReceitas())) * 100+"%% ");
        System.out.println("\n");

        //REMOVER UMA INSTANCIA
        centroComercial1.removerLoja(lojaPropria1);
        System.out.println("\n");
        System.out.println("###Lojas ordenadas alfabeticamente###");
        //LOJAS ORDENADAS ALFABETICAMENTE
        centroComercial1.ordenacaoNomeOrdemAlfabetica();
        System.out.println("\n");
        System.out.println("###Lojas ordenadas por tipo e área###");
        //LOJAS ORDENADAS POR TIPO E AREA
        centroComercial1.ordenarClasseArea();
        System.out.println("\n");

        //FICHEIRO DE DADOS
        centroComercial1.lerFicheiro();

    }

}
