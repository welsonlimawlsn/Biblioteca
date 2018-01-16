package br.com.welson.biblioteca.model;

public enum Cidade {
    AGUAS_CLARAS("Águas Claras"),
    BRASILIA("Brasília"),
    BRAZLANDIA("Brazlândia"),
    CANDANGOLANDIA("Candangolândia"),
    CEILANDIA("Ceilândia"),
    CRUZEIRO("Cruzeiro"),
    FERCAL("Fercal"),
    GAMA("Gama"),
    GUARA("Guará"),
    ITAPOA("Itapoã"),
    JARDIM_BOTANICO("Jardim Botânico"),
    LAGO_NORTE("Lago Norte"),
    LAGO_SUL("Lago Sul"),
    NUCLEO_BANDEIRANTE("Núcleo Bandeirante"),
    PARANOA("Paranoá"),
    PARK_WAY("Park Way"),
    PLANALTINA("Planaltina"),
    RECANTO_DAS_EMAS("Recanto das Emas"),
    RIACHO_FUNDO("Riacho Fundo"),
    RIACHO_FUNDO_II("Riacho Fundo II"),
    SAMAMBAIA("Samambaia"),
    SANTA_MARIA("Santa Maria"),
    SAO_SEBASTIAO("São Sebastião"),
    SCIA("SCIA"),
    SIA("SIA"),
    SOBRADINHO("Sobradinho"),
    SOBRADINHO_II("Sobradinho II"),
    SUDOESTE_OCTOGONAL("Sudoeste/Octogonal"),
    TAGUATINGA("Taguatinga"),
    VARJAO("Varjão"),
    VICENTE_PIRES("Vicente Pires");

    private String cidade;

    Cidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }
}
