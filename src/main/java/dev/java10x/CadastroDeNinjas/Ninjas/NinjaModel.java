package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity
@Table(name="tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private int idade;

    // Um ninja só pode ter uma missão
    @ManyToOne
    @JoinColumn(name="missoes_id") // foreign key
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

}
