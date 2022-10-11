package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;

@RestController

@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@GetMapping // Responderá al verbo GET
	public ResponseEntity<List<Comentario>> getAll() {
		// realizamos la consulta y cargamos el objeto comentarios
		List<Comentario> comentarios = comentarioRepository.findAll();
		// retornamos la lista con el status

		return new ResponseEntity<List<Comentario>>(comentarios, HttpStatus.OK);
	}
	// indicar que los datos viajan dentro del request

	// datos que vienen del cliente EN EL OBJETO REQUEST
	@PostMapping
	public ResponseEntity<Comentario> create(@RequestBody Comentario comentarioLlega) {
		try {

			Comentario comentarioRetorno = comentarioRepository.save(comentarioLlega);
			System.out.println(comentarioRetorno.toString());

			return new ResponseEntity<Comentario>(comentarioRetorno, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	// reccibimos el codigo
	@GetMapping(value = "/{codigo}") // cargamos la variable
	public ResponseEntity<Comentario> getOne(@PathVariable Long codigo) {
		// consulta por codigo
		Optional<Comentario> comentarioConsulta = comentarioRepository.findById(codigo);

		if (comentarioConsulta.isPresent()) {
			return new ResponseEntity<Comentario>(comentarioConsulta.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Comentario> deleteById(@PathVariable Long codigo) {
		//logica para eliminar a traves de una tabla precargada
		try {
			comentarioRepository.deleteById(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
