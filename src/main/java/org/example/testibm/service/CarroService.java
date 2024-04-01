package org.example.testibm.service;

// CarroService.java
import org.example.testibm.model.Carro;
import org.example.testibm.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarCarroPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro cadastrarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, Carro novoCarro) {
        novoCarro.setId(id);
        return carroRepository.save(novoCarro);
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }
}