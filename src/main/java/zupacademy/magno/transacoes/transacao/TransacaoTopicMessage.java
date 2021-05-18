package zupacademy.magno.transacoes.transacao;

import zupacademy.magno.transacoes.cartao.CartaoResponse;
import zupacademy.magno.transacoes.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoTopicMessage {

    private String id;
    private BigDecimal valor;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;

    @Deprecated
    public TransacaoTopicMessage() {
    }

    public TransacaoTopicMessage(String id,
                                 BigDecimal valor,
                                 CartaoResponse cartao,
                                 LocalDateTime efetivadaEm,
                                 EstabelecimentoResponse estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    @Override
    public String toString() {
        return "TransacaoResponse{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                ", estabelecimento=" + estabelecimento +
                '}';
    }
}
