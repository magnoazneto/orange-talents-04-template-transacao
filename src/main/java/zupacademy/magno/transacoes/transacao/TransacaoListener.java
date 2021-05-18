package zupacademy.magno.transacoes.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import zupacademy.magno.transacoes.cartao.Cartao;
import zupacademy.magno.transacoes.cartao.CartaoRepository;
import zupacademy.magno.transacoes.compartiilhado.ExecutorTransacao;
import zupacademy.magno.transacoes.estabelecimento.Estabelecimento;

import java.util.Optional;

@Component
public class TransacaoListener {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired ExecutorTransacao manager;
    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoTopicMessage mensagem){
        try{
            logger.info("Nova mensagem escutada={}", mensagem.toString());

            Transacao novaTransacao = new Transacao(mensagem.getId(),
                    mensagem.getValor(),
                    mensagem.getEfetivadaEm(),
                    new Estabelecimento(mensagem.getEstabelecimento())
            );
            Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(mensagem.getCartao().getId());

            if(possivelCartao.isPresent()){
                Cartao cartaoEncontrado = possivelCartao.get();
                cartaoEncontrado.addTransacao(novaTransacao);
                manager.atualizaEComita(cartaoEncontrado);
            } else{
                Cartao novoCartao = new Cartao(mensagem.getCartao());
                novoCartao.addTransacao(novaTransacao);
                manager.salvaEComita(novoCartao);
                logger.info("Novo cartão salvo com id={}", novoCartao.getId());
            }

        }catch (Exception e){
            logger.error("Erro ao tentar salvar novas transacoes");
            e.printStackTrace();
        }
    }
}
