package com.example.sistema_gerenciamento_rpg.servico;


import com.example.sistema_gerenciamento_rpg.modelo.ItemMagico;
import com.example.sistema_gerenciamento_rpg.repositorio.RepositorioItemMagico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoItemMagico {
    @Autowired
    private RepositorioItemMagico RepositorioItemMagico;

    public ItemMagico criarItemMagico(ItemMagico item) {
        return RepositorioItemMagico.save(item);
    }

    public List<ItemMagico> listarItensMagicos() {
        return RepositorioItemMagico.findAll();
    }

    public Optional<ItemMagico> buscarItemMagicoPorId(Long id) {
        return RepositorioItemMagico.findById(id);
    }
}
