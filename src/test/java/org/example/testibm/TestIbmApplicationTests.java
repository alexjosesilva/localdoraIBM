package org.example.testibm;

import org.example.testibm.model.Carro;
import org.example.testibm.repository.CarroRepository;
import org.example.testibm.service.CarroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestIbmApplicationTests {

    @Mock
    private CarroRepository carroRepository;

    @InjectMocks
    private CarroService carroService;

    @Test
    public void listarCarros_DeveRetornarListaDeCarros() {
        // Arrange
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Toyota", "Corolla"));
        carros.add(new Carro(2L, "Honda", "Civic"));
        when(carroRepository.findAll()).thenReturn(carros);

        // Act
        List<Carro> resultado = carroService.listarCarros();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Toyota", resultado.get(0).getMarca());
        assertEquals("Corolla", resultado.get(0).getModelo());
    }

    @Test
    public void buscarCarroPorId_QuandoEncontrado_DeveRetornarCarro() {
        // Arrange
        Carro carro = new Carro(1L, "Toyota", "Corolla");
        when(carroRepository.findById(1L)).thenReturn(Optional.of(carro));

        // Act
        Optional<Carro> resultado = carroService.buscarCarroPorId(1L);

        // Assert
        assertEquals(carro, resultado.orElse(null));
    }

    @Test
    public void cadastrarCarro_DeveRetornarCarroCadastrado() {
        // Arrange
        Carro carro = new Carro(1L, "Toyota", "Corolla");
        when(carroRepository.save(carro)).thenReturn(carro);

        // Act
        Carro resultado = carroService.cadastrarCarro(carro);

        // Assert
        assertEquals(carro, resultado);
    }

}
