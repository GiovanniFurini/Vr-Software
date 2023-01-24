package principal;

public class Cliente {
    
    private long  cnh;
    private int fk_endereco;
    private String nome;
    private String email;
    private String dtnascimento;
    private String telefone;
    
    public Cliente(long cnh,int fk_endereco,String nome,String email, String dtnascimento, String telefone){
        this.dtnascimento = dtnascimento;
        this.email = email;
        this.fk_endereco = fk_endereco;
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public long getCnh() {
        return cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }

    public int getFk_endereco() {
        return fk_endereco;
    }

    public void setFk_endereco(int fk_endereco) {
        this.fk_endereco = fk_endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
