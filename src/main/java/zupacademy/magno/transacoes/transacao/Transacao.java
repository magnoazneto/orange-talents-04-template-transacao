package zupacademy.magno.transacoes.transacao;

import zupacademy.magno.transacoes.cartao.Cartao;
import zupacademy.magno.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idExterno;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "cartao_id")
    private Cartao cartao;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idExterno,
                     BigDecimal valor,
                     LocalDateTime efetivadaEm,
                     Estabelecimento estabelecimento) {
        this.idExterno = idExterno;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
    }

    public Long getId() {
        return id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEsbatelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
