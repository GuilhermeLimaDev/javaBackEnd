package br.com.itb.miniprojetospring.service;

import br.com.itb.miniprojetospring.model.Funcionario;
import br.com.itb.miniprojetospring.model.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository _funcionarioRepository) {
        this.funcionarioRepository = _funcionarioRepository;
    }
    @Transactional
    public Funcionario save(Funcionario _funcionario){
        return funcionarioRepository.save(_funcionario);
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findAllById(Long id){
        return funcionarioRepository.findById(id).orElse(null);

    }
    @Transactional
    public Funcionario update(Long id, Funcionario funcionario){
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);

        if(optionalFuncionario.isPresent()){
            Funcionario existingFuncionario = optionalFuncionario.get();
            existingFuncionario.setNome(funcionario.getNome());
            existingFuncionario.setEmail(funcionario.getEmail());
            existingFuncionario.setCargo(funcionario.getCargo());
            existingFuncionario.setSenha(funcionario.getSenha());
            existingFuncionario.setCodStatus(funcionario.getCodStatus());

            return funcionarioRepository.save(existingFuncionario);
        }
        else{
           throw new RuntimeException("Funcionario não encontrado com o id: "+ id);
        }
    }

    @Transactional
    public void delete(Long id){
        funcionarioRepository.deleteById(id);
    }



}
