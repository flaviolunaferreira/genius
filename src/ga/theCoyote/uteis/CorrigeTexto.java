package ga.theCoyote.uteis;

public class CorrigeTexto {
    /**
     * vamos criar uma rotina para mudar as primeiras letras dos nomes próprios
     * para maiuscula com a exeção dos nomes com ate dua letras para tentarmos
     * evitar os (de, da, etc...)
     *
     * @param texto
     * @return textoCorrigido
     */
    public static final String corrige(String texto) {
        String sNova = "";                                                      // vamos criar uma string nova, vamos usa-la como retorno
        for (String sNome : texto.toLowerCase().split(" ")) {                   // para cada vez que for encontrado o " " 
            if (!"".equals(sNome)) {
                if (!"".equals(sNova)) {
                    sNova += " ";
                }
                if (sNome.length() > 2) {                                        // utilizado para nomes próprios, para não colocar maiúscula em De, por exemplo
                    sNova += sNome.substring(0, 1).toUpperCase() + sNome.substring(1);
                } else {
                    sNova += sNome;
                }
            }
        }
        return ("" + sNova + "");
    }
}
