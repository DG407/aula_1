public class Restauracao extends LojaComum {
    /**
     * Custo de Manutenção
     */
    private double custoManutencao;

    /**
     * Quantidade de mesas
     */
    private int qtdMesas;

    /**
     * Valor da taxa de segurança
     */
    public static double txSeguranca = 5;

    /**
     * Valor da Renda fixa
     */
    public static double rendaFixa = 1000;

    /**
     * Custo de manutenção por omissão
     */
    private static double CUSTOMANUTENCAO_POR_OMISSAO = 0;
    /**
     * Quatidade de mesas por omissão
     */
    private static int QTDMESAS_POR_OMISSAO = 0;

    /**
     * Inicializa as lojas de Restauraçao com nome, volume de receitas, área, quantidade de funcionários, custo de manutençao e quantidade de mesas
     * @param nome nome da loja
     * @param volumeReceitas volume de receitas da loja
     * @param area área da loja
     * @param qtdFuncionarios quantidade de funcionários da loja
     * @param custoManutencao custo de manutenção da loja
     * @param qtdMesas quantidade de mesas da loja
     */
    public Restauracao(String nome, float volumeReceitas, float area, int qtdFuncionarios, double custoManutencao, int qtdMesas) {
        super(nome, volumeReceitas, area, qtdFuncionarios);
        this.custoManutencao = custoManutencao;
        this.qtdMesas = qtdMesas;
    }

    /**
     * Inicializa as lojas de Restauraçao com valores por omissão
     */
    public Restauracao() {
        super();
        custoManutencao = CUSTOMANUTENCAO_POR_OMISSAO;
        qtdMesas = QTDMESAS_POR_OMISSAO;
    }

    /**
     * Devolve o custo de manutenção da loja de restauração
     * @return o custo de manutençao
     */
    public double getCustoManutencao() {
        return custoManutencao;
    }

    /**
     * Devolve a quantidade de mesas da loja de restauração
     * @return quantidade de mesas
     */
    public int getQtdMesas() {
        return qtdMesas;
    }

    /**
     * Devolve o valor da taxa de segurança da loja de restauração
     * @return taxa de segurança
     */
    public static double getTxSeguranca() {
        return txSeguranca;
    }

    /**
     * Modifica o custo de manutenção da loja de restauração
     * @param custoManutencao novo custo de manutenção
     */
    public void setCustoManutencao(double custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    /**
     * Modifica a quantidade de mesas da loja de restauração
     * @param qtdMesas novo número de mesas
     */
    public void setQtdMesas(int qtdMesas) {
        this.qtdMesas = qtdMesas;
    }

    /**
     * Modifica o valor da renda fixa da loja de restauração
     * @param rendaFixa novo valor da renda fixa
     */
    public static void setRendaFixa(double rendaFixa) {
        Restauracao.rendaFixa = rendaFixa;
    }

    /**
     * Modifica o valor da taxa de segurança da loja de restauração
     * @param txSeguranca novo valor da taxa de segurança
     */
    public static void setTxSeguranca(double txSeguranca) {
        Restauracao.txSeguranca = txSeguranca;
    }

    /**
     * Calcular o custo de segurança
     * @return devolve o valor do custo de segurança
     */
    public double custosSeguranca(){
        return txSeguranca * qtdMesas;
    }
    /**
     * Reescreve o toString
     * @return Reescreve o toString com a informaçao do nome, identificação, volume de receitas, área, custo de manutenção, quantidade de funcionários e quantidade de mesas
     */
    @Override
    public String toString() {
        return String.format("A loja  %s, com identificação  LC %d, tem um volume de receitas %.2f€, uma àrea de %.2f metros quadrados , um custo de manutenção de %.2f€, %d funcionários e %d mesas. \n"
                , getNome(), getIdLojaComum(), getVolumeReceitas(), getArea(), custoManutencao, getQtdFuncionarios(), qtdMesas);
    }

    /**
     * Reescreve o calculo da renda
     * @return o valor do calculo da renda para as lojas de restauração
     */
    @Override
    public double calcularRenda() {
        return (float) (rendaFixa * (1 + (getArea() / 100) + (getVolumeReceitas() / 100)));
    }
}
