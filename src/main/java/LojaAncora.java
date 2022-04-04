public class LojaAncora extends Loja{

    /**
     * custos com segurança
     */
    private double custoSeguranca;
    /**
     * Quantidade de lojas âcoras
     */
    private static int qtdLojaAncora = 0;
    /**
     * identificação das lojas âncoras
     */
    private int idLojaAncora ;

    /**
     * Custos de segurança por omissão
     */
    private static double CUSTOSEGURANCA_POR_OMISSAO = 0;
    /**
     * Quantidade de lojas âncora por omissão
     */
    private static int QTDLOJAANCORA_POR_OMISSAO = 0;

    /**
     * Inicializa o nome , o volume de receitas, a área e o custo de segurança com o nome, volumeReceitas, a area e o custoSegurança
     * @param nome o nome da loja
     * @param volumeReceitas o volume de receitas da loja
     * @param area a área da loja
     * @param custoSeguranca o custo de segurança da loja
     */
    public LojaAncora(String nome, float volumeReceitas, float area, double custoSeguranca){
        super(nome, volumeReceitas, area);
        this.custoSeguranca = custoSeguranca;
        qtdLojaAncora ++;
        idLojaAncora = qtdLojaAncora;
    }

    /**
     * Inicializa o nome, o volume de receitas, a área e o custo de segurança por omissão
     */
    public LojaAncora(){
        super();
        custoSeguranca = CUSTOSEGURANCA_POR_OMISSAO;
        qtdLojaAncora ++;
        idLojaAncora = qtdLojaAncora;
    }

    /**
     * Inicializa a quantidade de lojas âncoras com qtdLojaAncora
     * @param qtdLojaAncora
     */
    public LojaAncora(int qtdLojaAncora) {
        this.qtdLojaAncora = qtdLojaAncora;
    }

    /**
     * Devolve os custos de segurança
     * @return custos de segurança
     */
    public double getCustoSeguranca() {
        return custoSeguranca;
    }

    /**
     * Devolve a quantidade de lojas âncora
     * @return quantidade de lojas âncora
     */
    public static int getQtdLojaAncora() {
        return qtdLojaAncora;
    }

    /**
     * Devolve a identificação das lojas âncora
     * @return identificação das lojas âncora
     */
    public int getIdLojaAncora() {
        return idLojaAncora;
    }

    /**
     * Modifica os custos com segurança
     * @param custoSeguranca do novos custos de segurança
     */
    public void setCustoSeguranca(double custoSeguranca) {
        this.custoSeguranca = custoSeguranca;
    }

    /**
     * Rescreve o toString
     * @return o toString com o nome, identificação, o o volume de receitas e os custos de segurança de cada loja.
     */
    @Override
    public String toString() {
        return String.format("A loja  %s, com identificação LA: %d, tem um volume de receitas %.2f€  e custos com segurança de %.2f€. \n", getNome(), idLojaAncora, getVolumeReceitas(), custoSeguranca);
    }

}