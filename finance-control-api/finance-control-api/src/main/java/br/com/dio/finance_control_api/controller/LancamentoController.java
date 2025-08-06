package br.com.dio.financecontrolapi.controller;

import br.com.dio.financecontrolapi.dto.BalancoDTO;
import br.com.dio.financecontrolapi.model.Lancamento;
import br.com.dio.financecontrolapi.service.LancamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final LancamentoService lancamentoService;

    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> findById(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> findAll() {
        return ResponseEntity.ok(lancamentoService.findAll());
    }

    @GetMapping("/balanco")
    public ResponseEntity<BalancoDTO> getBalanco() {
        return ResponseEntity.ok(lancamentoService.getBalanco());
    }

    @PostMapping
    public ResponseEntity<Lancamento> create(@RequestBody Lancamento lancamento) {
        Lancamento lancamentoCriado = lancamentoService.create(lancamento);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lancamentoCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(lancamentoCriado);
    }
}