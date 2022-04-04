public class LojaExterna extends LojaAncora{

    /**
     * Quantidade de funcionários da Loja Externa
     */
    private int qtdFuncionarios;

    /**
     * Renda ixa da Loja externa
     */
    public static double rendaFixa = 2000;
    /**
     * Quantidade de funcionários por omissão
     */
    public static int QTDFUNCIONARIOS_POR_OMISSAO = 0;

    /**
     * Inicializa o nome, volume de receitas, área,custo de segurança e quantidade de funcionários com nome, volumeReceitas, area, custosSeguranca e qtdFuncionarios
     * @param nome
     * @param volumeReceitas
     * @param area
     * @param custoSeguranca
     * @param qtdFuncionarios
     */
    public LojaExterna(String nome, float volumeReceitas, float area, double custoSeguranca, int qtdFuncionarios){
        super(nome, volumeReceitas, area, custoSeguranca);
        this.qtdFuncionarios = qtdFuncionarios;
    }

    /**
     * Inicializa o nome, volume de receitas, área,custo de segurança e quantidade de funcionários por omissão
     */
    public LojaExterna(){
        super();
        qtdFuncionarios = QTDFUNCIONARIOS_POR_OMISSAO;
    }

    /**
     * Devove a quantidade de funcionários da loja externa
     * @return quantidade de funcionários
     */
    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    /**
     * Modifica a quantidade de funcinários na loja externa
     * @param qtdFuncionarios nova quantidade de funcionários
     */
    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    /**
     * Modifica a renda fixa da loja externa
     * @param rendaFixa nova renda fixa
     */
    public static void setRendaFixa(double rendaFixa) {
        LojaExterna.rendaFixa = rendaFixa;
    }

    /**
     * Reescreve o toString
     * @return o toString com nome, identificação, volume de receitas, custos de segurança quntidade de funcionários e renda fixa
     */
    @Override
    public String toString() {
        return String.format("A loja  %s, com identificação LC %d, tem um volume de receitas %.2f€, custos com segurança de %.2f€ %d funcionários e uma renda fixa de %.2f€. \n"
                , getNome(),getQtdLojaAncora(), getVolumeReceitas(), getCustoSeguranca(), qtdFuncionarios, rendaFixa);
    }

    /**
     * Calcula a renda das lojas externas
     * @return do valor da renda
     */
    public double calcularRenda() {
        return (float) (rendaFixa * (1 + (getArea() / 100) + (getVolumeReceitas() / 100)));
    }
}
