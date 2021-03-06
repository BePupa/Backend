package br.com.bepupa.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bepupa.locadora.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }