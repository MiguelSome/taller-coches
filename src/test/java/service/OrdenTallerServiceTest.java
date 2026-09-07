package service;

import enums.EstadoOrden;
import model.OrdenTaller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.OrdenTallerRepository;
import repository.PiezaRepository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrdenTallerServiceTest {

    @Mock
    private OrdenTallerRepository ordenTallerRepository;

    @Mock
    private PiezaRepository piezaRepository;

    @InjectMocks
    private OrdenTallerServiceImpl ordenTallerService;

    @Test
    public void testCambiarEstadoExitosamente() {
        // 🎬 GIVEN: Preparamos los datos de entrada y el mock
        Long ordenId = 1L;
        OrdenTaller ordenOriginal = new OrdenTaller();
        ordenOriginal.setId(ordenId);
        ordenOriginal.setEstado(EstadoOrden.PENDIENTE);

        // Simulamos que el repositorio devuelve nuestra orden al buscarla
        when(ordenTallerRepository.buscarPorId(ordenId)).thenReturn(ordenOriginal);

        // ⚡ WHEN: Ejecutamos el método del servicio
        OrdenTaller ordenActualizada = ordenTallerService.cambiarEstado(ordenId, EstadoOrden.EN_PROCESO);

        // 🎯 THEN: Verificamos los resultados
        assertNotNull(ordenActualizada, "La orden no debería ser nula");
        assertEquals(EstadoOrden.EN_PROCESO, ordenActualizada.getEstado(), "El estado debe cambiar a EN_PROCESO");
        
        // Verificamos que el repositorio realmente guardó la orden
        verify(ordenTallerRepository, times(1)).guardar(ordenOriginal);
    }
}