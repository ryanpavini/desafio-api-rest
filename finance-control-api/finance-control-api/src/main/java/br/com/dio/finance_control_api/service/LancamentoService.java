package br.com.dio.financecontrolapi.service;

import br.com.dio.financecontrolapi.dto.BalancoDTO;
import br.com.dio.financecontrolapi.model.Lancamento;
import java.util.List;

public interface LancamentoService {
    Lancamento findById(Long id);
    List<Lancamento> findAll();
    Lancamento create(Lancamento lancamento);
    BalancoDTO getBalanco();
}