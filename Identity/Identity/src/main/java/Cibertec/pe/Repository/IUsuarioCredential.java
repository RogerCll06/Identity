package Cibertec.pe.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cibertec.pe.Models.UsuarioCredential;

@Repository
public interface IUsuarioCredential extends JpaRepository<UsuarioCredential, Integer> {
	
	Optional <UsuarioCredential> findByEmail(String email);

}
