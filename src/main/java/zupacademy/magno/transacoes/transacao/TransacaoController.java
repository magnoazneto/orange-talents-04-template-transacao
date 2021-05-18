package zupacademy.magno.transacoes.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/transacoes")
public class TransacaoController {

    @Autowired TransacaoRepository transacaoRepository;

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<List<TransacaoResponse>> consultaCompras(@PathVariable("numeroCartao") String numeroCartao){
        List<Transacao> transacoes = transacaoRepository.findTenByCartaoNumeroOrderByEfetivadaEmDesc(numeroCartao);
        if(transacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList()));

    }
}
