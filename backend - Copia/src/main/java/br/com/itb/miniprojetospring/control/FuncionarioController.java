package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Funcionario;
import br.com.itb.miniprojetospring.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService _funcionarioService) {
        this.funcionarioService = _funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody Funcionario funcionario){
        return  ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionario));
    }

    @GetMapping
    public  ResponseEntity<List<Funcionario>> getAllFuncionarios(){
        return  ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

}
