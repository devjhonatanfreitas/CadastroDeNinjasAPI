package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("missoes")

public class MissoesController {

    private MissoesService missoesService;
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @PostMapping ("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO novaMissao = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: "+novaMissao.getNome()+" ID: "+novaMissao.getId());
    }

    //TODO
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){

        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if(missao !=null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID "+id+" não encontrada.");
        }

    }

    //TODO
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){

        if(missoesService.listarMissoes()!=null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID "+id+" não foi encontrada.");
        }
    }
}
