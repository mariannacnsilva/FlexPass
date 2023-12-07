package Back;

class Academia {
    private int gymID;
    private String gymNome;
    private String gymEndereco;
    private int limiteUsuários;
    private String horárioFunc;
    private Avaliacao[] avaliacoes;

    public Academia() {
    }

    public Academia(int gymID, String gymNome, String gymEndereco, int limiteUsuários, String horárioFunc, Avaliacao[] avaliacoes) {
        this.gymID = gymID;
        this.gymNome = gymNome;
        this.gymEndereco = gymEndereco;
        this.limiteUsuários = limiteUsuários;
        this.horárioFunc = horárioFunc;
        this.avaliacoes = avaliacoes;
    }

    public int getGymID() {
        return this.gymID;
    }

    public void setGymID(int gymID) {
        this.gymID = gymID;
    }

    public String getGymNome() {
        return this.gymNome;
    }

    public void setGymNome(String gymNome) {
        this.gymNome = gymNome;
    }

    public String getGymEndereco() {
        return this.gymEndereco;
    }

    public void setGymEndereco(String gymEndereco) {
        this.gymEndereco = gymEndereco;
    }

    public int getLimiteUsuários() {
        return this.limiteUsuários;
    }

    public void setLimiteUsuários(int limiteUsuários) {
        this.limiteUsuários = limiteUsuários;
    }

    public String getHorárioFunc() {
        return this.horárioFunc;
    }

    public void setHorárioFunc(String horárioFunc) {
        this.horárioFunc = horárioFunc;
    }

    public Avaliacao[] getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(Avaliacao[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String toString() {
        return "{" +
            " gymID='" + getGymID() + "'" +
            ", gymNome='" + getGymNome() + "'" +
            ", gymEndereco='" + getGymEndereco() + "'" +
            ", limiteUsuários='" + getLimiteUsuários() + "'" +
            ", horárioFunc='" + getHorárioFunc() + "'" +
            ", avaliacoes='" + getAvaliacoes() + "'" +
            "}";
    }

}