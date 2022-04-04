import java.util.Comparator;

public class Loja implements Comparable<Loja>{
    /**
     * Nome da loja
     * */
    private String nome;
    /**
     * Volume de receitas
     * */
    private float volumeReceitas;
    /**
     * valor da área
     * */
    private float area;

    /**
     * valor do primeiro limite
     * */
    public static int limite1 = 20;
    /**
     * valor do segundo limite
     * */
    public static int limite2 = 100;
    /**
     *Nome por omissão da loja
     */
    private static String NOME_POR_OMISSAO = "sem nome";
    /**
     * Valor do volume de receitas por omissao da loja
     */
    private static float VOLUME_RECEITAS_POR_OMISSAO = 0;

    /**
     *área por omissão da loja
     */
    private static float AREA_POR_OMISSAO = 0;

    /**
     * Inicializa a loja com o nome, volume de receitas e area com o nome, volume de receitas e area recebidos
     * @param nome nome da loja
     * @param volumeReceitas volume de receitas da loja
     * @param area área da loja
     */
    public Loja(String nome, float volumeReceitas , float area){
        this.nome = nome;
        this.volumeReceitas = volumeReceitas;
        this.area = area;
    }
    /**
     *  Inicializa o nome, volume de receitas e área da loja por omissão
     */
    public Loja(){
        nome = NOME_POR_OMISSAO;
        volumeReceitas = VOLUME_RECEITAS_POR_OMISSAO;
        area = AREA_POR_OMISSAO;
    }

    /**
     *  Devolve o primeiro limite para a classificação da área
     * @return primeiro limite
     */
    public static int getLimite1() {
        return limite1;
    }
    /**
     *  Devolve o segundo limite para a classificação da área
     * @return segundo limite
     */
    public static int getLimite2() {
        return limite2;
    }
    /**
     *  Devolve o nome da loja
     * @return nome da loja
     */
    public String getNome() {
        return nome;
    }
    /**
     *  Devolve o volume de receitas da loja
     * @return volume de receitas da loja
     */
    public float getVolumeReceitas() {
        return volumeReceitas;
    }
    /**
     *  Devolve a área da loja
     * @return área da loja
     */
    public float getArea() {
        return area;
    }

    /**
     * Modifica o nome da loja
     * @param nome do novo nome da loja
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * modifica o primeiro limite para a classificação da área
     * @param limite1 do novo limite para a classificação da área
     */
    public static void setLimite1(int limite1) {
        Loja.limite1 = limite1;
    }
    /**
     * modifica o segundo limite para a classificação da área
     * @param limite2 do novo limite para a classificação da área
     */
    public static void setLimite2(int limite2) {
        Loja.limite2 = limite2;
    }

    /**
     * Modifica o volume de receitas da loja
     * @param volumeReceitas do novo volume de receitas da loja
     */
    public void setVolumeReceitas(float volumeReceitas) {
        this.volumeReceitas = volumeReceitas;
    }

    /**
     * Modifica a área da loja
     * @param area da nova área da loja
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Reescreve o toString
     * @return o toString com a área e o volume de receitas
     */
    @Override
    public String toString(){
        return String.valueOf(area + volumeReceitas);
    }

    /**
     *  Classifica o tamanho da área de acordo com os limites pré estabelecidos
     * @return Se a loja é Pequena, Média ou Grande
     */
    public String classificacaoArea() {
        if (getArea() < limite1) {
            return "Pequena";
        } else {
            if (getArea() >= limite1 && getArea() < limite2) {
                return "Média";
            } else {
                return "Grande";
            }
        }
    }

    /**
     * Ordenação das lojas pelo seu nome
     * @param OutraLoja ordenação da lojas por ordem alfabética
     * @return
     */
    @Override
    public int compareTo(Loja OutraLoja) {
        return this.nome.compareTo(OutraLoja.nome);
    }

}
