package zupacademy.magno.transacoes.estabelecimento;

import zupacademy.magno.transacoes.transacao.Transacao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estabelecimento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    private String endereco;
    @OneToMany(mappedBy = "estabelecimento")
    private List<Transacao> transacao;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento(EstabelecimentoResponse estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }
}
