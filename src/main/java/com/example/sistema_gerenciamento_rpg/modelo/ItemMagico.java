package com.example.sistema_gerenciamento_rpg.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class ItemMagico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    @Min(0) @Max(10)
    private int forca;

    @Min(0) @Max(10)
    private int defesa;

    // Construtor
    public ItemMagico() {}

    @PrePersist
    @PreUpdate
    public void validarCampos(){

        if (forca < 0 || forca > 10) {
            throw new IllegalArgumentException("Valor de força deve estar entre 0 e 10.");
        }
        if (defesa < 0 || defesa > 10) {
            throw new IllegalArgumentException("Valor de defesa deve estar entre 0 e 10.");
        }
        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa zeradas.");
        }
        if (tipo == TipoItem.ARMA && defesa != 0) {
            throw new IllegalArgumentException("Armas não podem ter defesa.");
        }
        if (tipo == TipoItem.ARMADURA && forca != 0) {
            throw new IllegalArgumentException("Armaduras não podem ter força.");
        }
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public TipoItem getTipo() { return tipo; }
    public int getForca() { return forca; }
    public int getDefesa() { return defesa; }
}

