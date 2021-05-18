package zupacademy.magno.transacoes.transacao;

import zupacademy.magno.transacoes.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = new EstabelecimentoResponse(
                transacao.getEstabelecimento().getNome(),
                transacao.getEstabelecimento().getCidade(),
                transacao.getEstabelecimento().getEndereco()
        );
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
