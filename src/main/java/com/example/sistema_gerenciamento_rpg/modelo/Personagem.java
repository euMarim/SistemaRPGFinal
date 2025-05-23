package com.example.sistema_gerenciamento_rpg.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonProperty("nomeAventureiro")
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;
    private int nivel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    @JsonProperty("forca")
    private int forcaBase; // Força base (sem itens)

    @JsonProperty("defesa")
    private int defesaBase; // Defesa base (sem itens)

    // Construtor padrão exigido pelo JPA
    public Personagem() {}

    // Método de validação
    private void validarForcaEDefesa() {
        System.out.println("Validando: forca=" + forcaBase + ", defesa=" + defesaBase);
        if (forcaBase + defesaBase > 10 || forcaBase < 0 || defesaBase < 0) {
            throw new IllegalArgumentException("A soma de força e defesa não pode exceder 10 pontos.");
        }
    }

    // Executa validação antes de persistir no banco
    @PrePersist
    private void prePersist() {
        validarForcaEDefesa();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNomeAventureiro() { return nomeAventureiro; }
    public void setNomeAventureiro(String nomeAventureiro) { this.nomeAventureiro = nomeAventureiro; }
    public ClassePersonagem getClasse() { return classe; }
    public void setClasse(ClassePersonagem classe) { this.classe = classe; }
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public List<ItemMagico> getItensMagicos() { return itensMagicos; }
    public int getForcaBase() { return forcaBase; }
    public void setForcaBase(int forcaBase) { this.forcaBase = forcaBase; }
    public int getDefesaBase() { return defesaBase; }
    public void setDefesaBase(int defesaBase) { this.defesaBase = defesaBase; }
    public int getForcaTotal() {
        return forcaBase + itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
    }
    public int getDefesaTotal() {
        return defesaBase + itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
    }

    public void adicionarItemMagico(ItemMagico item) {
        if (item.getTipo() == TipoItem.AMULETO && itensMagicos.stream().anyMatch(i -> i.getTipo() == TipoItem.AMULETO)) {
            throw new IllegalStateException("Personagem já possui um amuleto.");
        }
        itensMagicos.add(item);
    }

    public void removerItemMagico(ItemMagico item) {
        itensMagicos.remove(item);
    }
}