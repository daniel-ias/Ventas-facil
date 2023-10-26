package com.ecommerce.core.infraestructure.configuration;

import com.ecommerce.core.application.repository.ArticuloRepository;
import com.ecommerce.core.application.repository.ServicioRepository;
import com.ecommerce.core.application.service.ArticuloService;
import com.ecommerce.core.application.service.ServicioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ArticuloService articuloService(ArticuloRepository articuloRepository) {
        return new ArticuloService(articuloRepository);
    }

    @Bean
    public ServicioService service(ServicioRepository servicioRepository) {
        return new ServicioService(servicioRepository);
    }
}
