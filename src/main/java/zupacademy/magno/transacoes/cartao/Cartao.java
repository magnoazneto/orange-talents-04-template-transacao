package zupacademy.magno.transacoes.cartao;

import zupacademy.magno.transacoes.transacao.Transacao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String numero;
    @NotBlank @Email
    private String email;
    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacoes = new ArrayList<>();

    @Deprecated
    public Cartao() {
    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public Cartao(CartaoResponse cartao) {
        this.email = cartao.getEmail();
        this.numero = cartao.getId();
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void addTransacao(Transacao transacao){
        this.transacoes.add(transacao);
    }
}
