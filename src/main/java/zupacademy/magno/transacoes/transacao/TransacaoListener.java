package zupacademy.magno.transacoes.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import zupacademy.magno.transacoes.cartao.Cartao;
import zupacademy.magno.transacoes.compartiilhado.ExecutorTransacao;
import zupacademy.magno.transacoes.estabelecimento.Estabelecimento;

@Component
public class TransacaoListener {

    @Autowired ExecutorTransacao manager;
    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoTopicMessage mensagem){
        try{
            logger.info("Nova mensagem escutada={}", mensagem.toString());
            Transacao novaTransacao = new Transacao(mensagem.getValor(),
                    mensagem.getEfetivadaEm(),
                    new Cartao(mensagem.getCartao()),
                    new Estabelecimento(mensagem.getEstabelecimento())
                    );
            manager.salvaEComita(novaTransacao);
            logger.info("Nova transação salva com id={}", novaTransacao.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
