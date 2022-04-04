public class Quiosque extends LojaComum{
    /**
     * valor fixo da renda
     * */
    public static double renda = 250;

    /**
     * Inicializa os Quiosques com o nome, volume de receitas, área e quantidade de funcionários
     * @param nome nome do quiosque
     * @param volumeReceitas volume de receitas do quiosque
     * @param area área do quiosque
     * @param qtdFuncionarios quantidade de funcionários do quiosque
     */
    public Quiosque(String nome, float volumeReceitas, float area, int qtdFuncionarios) {
        super(nome, volumeReceitas, area, qtdFuncionarios);
    }

    /**
     * Inicializa por omissao
     */
    public Quiosque(){
        super();
    }

    /**
     * Modifica o valor da renda
     * @param renda novo valor da renda
     */
    public static void setRenda(double renda) {
        Quiosque.renda = renda;
    }

    /**
     * Reescreve o toString
     * @return Reescreve o toString com a informaçao do nome, identificação, volume de receitas, área e quantidade de funcionários
     */
    @Override
    public String toString() {
        return String.format("A loja  %s, com identificação LC %d, tem um volume de receitas %.2f€, uma àrea de %.2f metros quadrados e %d funcionários. \n"
                , getNome(),getIdLojaComum(), getVolumeReceitas(),getArea(), getQtdFuncionarios());
    }

    /**
     * Calcula o valor da renda
     * @return o valor da renda dos quiosques
     */
    @Override
    public double calcularRenda() {
        return renda;
    }

}
