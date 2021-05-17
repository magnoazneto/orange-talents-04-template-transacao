package zupacademy.magno.transacoes.transacao.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import zupacademy.magno.transacoes.transacao.TransacaoResponse;

@Component
public class TransacaoListener {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse respostaEvento){
        try{
            System.out.println("Escutei um evento:");
            System.out.println(respostaEvento.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
