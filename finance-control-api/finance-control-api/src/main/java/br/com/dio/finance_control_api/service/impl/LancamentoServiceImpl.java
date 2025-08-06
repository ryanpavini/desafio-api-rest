package br.com.dio.financecontrolapi.service.impl;

import br.com.dio.financecontrolapi.dto.BalancoDTO;
import br.com.dio.financecontrolapi.model.Lancamento;
import br.com.dio.financecontrolapi.model.TipoLancamento;
import br.com.dio.financecontrolapi.repository.LancamentoRepository;
import br.com.dio.financecontrolapi.service.LancamentoService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    public LancamentoServiceImpl(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public Lancamento findById(Long id) {
        return lancamentoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    @Override
    public Lancamento create(Lancamento lancamento) {
        // Garante que a data seja salva, caso não seja informada
        if (lancamento.getData() == null) {
            lancamento.setData(java.time.LocalDate.now());
        }
        return lancamentoRepository.save(lancamento);
    }

    @Override
    public BalancoDTO getBalanco() {
        List<Lancamento> todosLancamentos = this.findAll();

        BigDecimal totalReceitas = todosLancamentos.stream()
                .filter(l -> l.getTipo() == TipoLancamento.RECEITA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = todosLancamentos.stream()
                .filter(l -> l.getTipo() == TipoLancamento.DESPESA)
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldoFinal = totalReceitas.subtract(totalDespesas);

        return new BalancoDTO(totalReceitas, totalDespesas, saldoFinal);
    }
}