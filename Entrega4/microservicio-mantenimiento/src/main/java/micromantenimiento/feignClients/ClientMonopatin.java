package micromantenimiento.feignClients;

import micromantenimiento.models.Monopatin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservicio-monopatin")
public interface ClientMonopatin {

    @GetMapping("api/monopatines")
    List<Monopatin> getMonopatines();

    @GetMapping("api/monopatines/id/{id_monopatin}")
    Monopatin getMonopatin(@PathVariable("id_monopatin") int id_monopatin);
}
