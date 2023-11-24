package ucc.analisis.sistemas.m3.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service-status")
public class PublicController {
    @GetMapping("/is-up")
    public ResponseEntity<String> isUp() throws Exception {
        return ResponseEntity.status(200).body("OK!");
    }
}
