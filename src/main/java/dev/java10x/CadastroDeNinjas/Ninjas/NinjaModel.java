package dev.java10x.CadastroDeNinjas.Ninjas;

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
    private List<MissoesModel> missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

}
