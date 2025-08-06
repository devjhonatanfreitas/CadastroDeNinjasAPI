package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    final private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Cria um novo ninja e o insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: "+novoNinja.getNome()+" ID: "+novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Retorna uma lista com todos os ninjas cadastrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ninjas retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum ninja encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Busca ninja por ID", description = "Retorna os dados de um ninja específico baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado com o ID fornecido"),
            @ApiResponse(responseCode = "400", description = "ID inválido fornecido")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID "+id+ " não existe em nossos registros.");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Atualiza dados do ninja", description = "Atualiza completamente os dados de um ninja existente baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado com o ID fornecido"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos para atualização")
    })
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID "+id+ " não existe em nossos registros.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Remove ninja", description = "Remove um ninja do sistema baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado com o ID fornecido"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao remover ninja")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if(ninjaService.listarNinjasPorId(id)!=null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID "+id+ " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID "+id+" não foi encontrado.");
        }
    }
}