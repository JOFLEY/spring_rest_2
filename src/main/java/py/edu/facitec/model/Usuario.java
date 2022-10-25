package py.edu.facitec.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import py.edu.facitec.repository.UsuarioRepository;

@Entity
public class Usuario extends General implements UsuarioRepository {

	private String nombre;

	private String pass;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public List<Usuario> findAll() {
		return null;
	}

	@Override
	public List<Usuario> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<Usuario> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
		
	}

	@Override
	public <S extends Usuario> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Usuario> entities) {
		
	}

	@Override
	public void deleteAllInBatch() {
		
	}

	@Override
	public Usuario getOne(Long id) {
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Usuario> S save(S entity) {
		return null;
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		
	}

	@Override
	public void delete(Usuario entity) {
		
	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Usuario> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Usuario> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public Usuario buscarPorNombre(String nombre) {
		return null;
	}

}
