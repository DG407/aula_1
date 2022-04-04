public class LojaComum extends Loja{
    /**
     * Quantidade de funcionários
     * */
    private int qtdFuncionarios;

    /**
     * Quantidade de lojas
     * */
    private static int qtdLojaComum = 0;

    /**
     * Identificação da loja
     * */
    private int idLojaComum;

    /**
     * Quantidade de funcionários por omissão
     * */
    public static int QTDFUNCIONARIOS_POR_OMISSAO = 0;

    /**
     *  Inicializa o nome, o volume de receitas, a área e a quantidade de funcionários com o nome, volume de receitas, a área e a quantidade de funcionários
     * @param nome o nome da loja
     * @param volumeReceitas o volume de receitas da loja
     * @param area a área da loja
     * @param qtdFuncionarios a quantidade de funcionários da loja
     */
    public LojaComum(String nome, float volumeReceitas, float area, int qtdFuncionarios){
        super(nome, volumeReceitas, area);
        this.qtdFuncionarios = qtdFuncionarios;
        qtdLojaComum ++;
        idLojaComum = qtdLojaComum;
    }

    /**
     *  Inicializa a quantidade de funcionários por omissão
     */
    public LojaComum(){
        super();
        qtdLojaComum = QTDFUNCIONARIOS_POR_OMISSAO;
        qtdLojaComum++;
        idLojaComum = qtdLojaComum;
    }
    /**
     *  Devolve a quantidade de funcionários
     * @return quantidade de funcionários
     */
    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }
    /**
     *  Devolve a quantidade de lojas comuns
     * @return quantidade de lojas comuns
     */
    public static int getQtdLojaComum() {
        return qtdLojaComum;
    }
    /**
     *  Devolve a identificaçao da loja
     * @return a identificaçao da loja
     */
    public int getIdLojaComum() {
        return idLojaComum;
    }

    /**
     * Modifica a quantidade de funcionários
     * @param qtdFuncionarios do novo número de funcionários
     */
    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }
    
    /**
     * Reescreve o toString
     * @return o toString a quantidade de funcionarios, quantidade de lojas comuns e a identificaçao das lojas
     */
    @Override
    public String toString() {
        return String.valueOf(qtdFuncionarios + qtdLojaComum + idLojaComum);
    }

    /**
     *  Calcula a rendas da lojas comuns
     * @return o valor da renda das lojas comuns
     */
    public double calcularRenda() {
        return calcularRenda();
    }
}