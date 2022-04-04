import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.*;

public class CentroComercial implements Comparable<CentroComercial>, Comparator<Loja> {
    /**
     * Nome centro comercial
     */
    private String nome;
    /**
     * Morada centro comercial
     */
    private String morada;

    /**
     *Nome por omissão do centro comercial
     */
    private static String NOME_POR_OMISSAO = "sem nome";
    /**
     * Morada por omissão do centro comercial
     */
    private static String MORADA_POR_OMISSAO = "sem morada";

    /**
     * Inicializa o nome e morada do centro comercial com o nome e morada recebidos
     * @param nome o nome do centro comercial
     * @param morada a morada do centro comercial
     */
    public CentroComercial(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    /**
     *Inicializa o nome e morada do centro comercial com o nome e morada por omissão
     */
    public CentroComercial() {
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
    }

    /**
     * Inicializa o nome do centro comercial com o nome e a morada com a morada por omissão
     * @param nome
     */
    public CentroComercial(String nome) {
        this.nome = nome;
        morada = MORADA_POR_OMISSAO;
    }

    /**
     * Devolve o nome do centro comercial
     * @return nome do centro comercial
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a morada do centro comercial
     * @return morada do centro comercial
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Modifica o nome do centro comercial
     * @param nome do novo nome do centro comercial
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a morada do centro comercial
     * @param morada da nova morada do centro comercial
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Devolve o nome do centro comercial
     * @return nome do centro comercial
     */
    @Override
    public String toString() {
        return nome;
    }

    /**
     * Criação de um Arraylist para amarzenar as lojas do centro comercial
     */
    ArrayList<Loja> lojas = new ArrayList<Loja>();

    /**
     * Devolve o Arraylist lojas do centro comercial
     * @return lojas do centro comercial
     */
    public ArrayList<Loja> getLojas() {
        return lojas;
    }

    /**
     * Acrescerntar uma instância ao Arraulist
     * @param l nova loja
     */
    public void adicionarLoja(Loja l) {
        lojas.add(l);
    }

    /**
     * Remover uma instância ao Arraylist
     * @param l remove uma loja
     */
    public void removerLoja(Loja l) {
        lojas.remove(l);
    }

    /**
     * Calculo da Renda das Lojas âncoras
     * @return renda das lojas âncoras
     */
    public double calculoRendaAncoras() {

        double soma = 0;
        for (Loja lj : lojas) {
            if (lj instanceof LojaExterna) {
                soma = soma + ((LojaExterna) lj).calcularRenda();
            }
        }

        return soma;
    }

    /**
     * Calculo da Renda das Lojas Comuns
     * @return renda das lojas comuns
     */
    public double calculoRendaComuns() {
        double soma2 = 0;
        for (Loja lj : lojas) {
            if (lj instanceof LojaComum) {
                soma2 = soma2 + ((LojaComum) lj).calcularRenda();
            }
        }


        return soma2;
    }

    /**
     * Calculo dos custos de segurança das lojas do centro comercial
     * @return custos com segurança
     */
    public double calculoCustosSeguranca() {

        double soma3 = 0;
        for (Loja lj : lojas) {
            if (lj instanceof LojaAncora) {
                soma3 = soma3 + ((LojaAncora) lj).getCustoSeguranca();
            }
        }
        double soma4 = 0;
        for (Loja lj : lojas) {
            if (lj instanceof Restauracao) {
                soma4 = soma4 + ((Restauracao) lj).custosSeguranca();
            }
        }

        return soma3 + soma4;
    }

    /**
     * Calculo do total de receitas a receber pelo centro comercial
     * @return total de receitas
     */
    public double totalReceitas() {

        return calculoRendaAncoras() + calculoRendaComuns() + calculoCustosSeguranca();
    }

    /**
     * Calculo do total de custos das Lojas Âncoras
     * @return custos das lojas âncoras
     */
    public double totalCustosLojasAncoras() {

        double totalCustos = 0;
        for (Loja lj : lojas) {
            if (lj instanceof LojaAncora) {
                totalCustos = totalCustos + calculoRendaAncoras() + ((LojaAncora) lj).getCustoSeguranca();
            }
        }
        return totalCustos;
    }

    /**
     * Ordena as lojas primeiro ppr classe e depois pela área
     */
    public void ordenarClasseArea() {
        lojas.sort(this);
        listar(lojas);
    }

    /**
     * Ordena as lojas pela área
     * @param l1 loja 1 a ser comparada
     * @param l2 loja 2 a ser comparada
     * @return ordenação das lojas por área crescente
     */
    @Override
    public int compare(Loja l1, Loja l2) {

        float area1 = l1.getArea();
        float area2 = l2.getArea();

        if (area1 > area2) {
            return -1;
        } else if (area1 < area2) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * Ordena as lojas em relção ao seu tipo
     * @param l1 loja 1 a ser comparada
     * @param l2 loja 2 a ser comparada
     * @return ordenação das lojas atravéz do seu tipo
     */
    public int compareToTipo(Loja l1, Loja l2) {
        String tipo = l1.getClass().getSimpleName();
        String tipo2 = l2.getClass().getSimpleName();
        if (tipo.equals(tipo2)) {
            return compare(l1, l2);
        } else {
            return tipo.compareTo(tipo2);
        }
    }

    /**
     * retorna a ordenação pelo tipo
     */
    public void ordenarPorTipo() {
        lojas.sort(this::compareToTipo);
    }

    /**
     * Ordenação das lojas pelo seu nome
     * @param OutroCentroComercial
     * @return ordenação da lojas por ordem alfabética
     */
    @Override
    public int compareTo(CentroComercial OutroCentroComercial) {
        return this.nome.compareTo(OutroCentroComercial.nome);
    }

    /**
     * Lista as lojas por ordem alfabética
     */
    public void ordenacaoNomeOrdemAlfabetica() {
        Collections.sort(lojas);
        listar(lojas);
    }

    /**
     * lista as lojas apresentando o nome
     * @param lojas
     */
    public static void listar(List<Loja> lojas) {
        for (Loja lj : lojas) {
            if (lojas != null) {
                System.out.println(lj.getNome());
            }
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void lerFicheiro() throws FileNotFoundException {
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

        final int TAMANHO = 20;
        String[] linha = new String[TAMANHO];
        int contador = 0;
        Scanner ler = new Scanner(new File("ListaLojas.txt"));

        Formatter fichLojas = new Formatter(new File("ListaLojas.txt"));
        fichLojas.format("Nome: %s; Morada %s:\n", nome, morada);

        ArrayList<LojaAncora> lojasAncora = new ArrayList<>();
        lojasAncora.add(lojaPropria1);
        lojasAncora.add(lojaPropria2);
        lojasAncora.add(lojaPropria3);
        lojasAncora.add(lojaExterna1);
        ArrayList<LojaComum> lojasComum = new ArrayList<>();
        lojasComum.add(lojaRestauracao1);
        lojasComum.add(lojaRestauracao2);
        lojasComum.add(lojaRestauracao3);
        lojasComum.add(lojaRestauracao4);
        lojasComum.add(lojaQuiosque1);
        lojasComum.add(lojaQuiosque2);
        lojasComum.add(lojaQuiosque3);

        for (LojaAncora lja : lojasAncora
        ) {
            fichLojas.format("Nome: %s; Identificação LA-%d; Area: %.2fm²; Volume de Receitas: %.2f€. \n", lja.getNome(), lja.getIdLojaAncora(), lja.getArea(), lja.getVolumeReceitas());
        }
        for (LojaComum ljc : lojasComum
        ) {
            fichLojas.format("Nome: %s; Identificação LC-%d; Area: %.2fm²; Volume de Receitas: %.2f€; Número de funcionários: %d. \n", ljc.getNome(), ljc.getIdLojaComum(), ljc.getArea(), ljc.getVolumeReceitas(), ljc.getQtdFuncionarios());
        }

        while (ler.hasNextLine()){

            String l = ler.nextLine();

            if (linha[contador] == null){
                linha[contador] = l;
            }

            contador++;
        }
        fichLojas.close();
    }

}