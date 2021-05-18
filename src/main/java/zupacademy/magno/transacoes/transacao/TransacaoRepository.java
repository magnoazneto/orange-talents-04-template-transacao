package zupacademy.magno.transacoes.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findTenByCartaoNumeroOrderByEfetivadaEmDesc(String cartaoNumero);

}
