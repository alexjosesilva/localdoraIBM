package org.example.testibm.controller;

// CarroController.java
import org.example.testibm.model.Carro;
import org.example.testibm.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroService.listarCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable Long id) {
        Optional<Carro> carro = carroService.buscarCarroPorId(id);
        return carro.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro) {
        Carro novoCarro = carroService.cadastrarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro novoCarro) {
        Carro carroAtualizado = carroService.atualizarCarro(id, novoCarro);
        return ResponseEntity.ok(carroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }
}