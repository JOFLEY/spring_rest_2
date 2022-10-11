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

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@RestController

@RequestMapping("/suscritos")
public class SuscritoController {

	@Autowired
	private SuscritoRepository suscritoRepository;

	@GetMapping // Responderá al verbo GET
	public ResponseEntity<List<Suscrito>> getAll() {
		// realizamos la consulta y cargamos el objeto suscritos
		List<Suscrito> suscritos = suscritoRepository.findAll();
		// retornamos la lista con el status

		return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);
	}
	// indicar que los datos viajan dentro del request

	// datos que vienen del cliente EN EL OBJETO REQUEST
	@PostMapping
	public ResponseEntity<Suscrito> create(@RequestBody Suscrito suscritoLlega) {
		try {

			Suscrito suscritoRetorno = suscritoRepository.save(suscritoLlega);
			System.out.println(suscritoRetorno.toString());

			return new ResponseEntity<Suscrito>(suscritoRetorno, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	// reccibimos el codigo
	@GetMapping(value = "/{codigo}") // cargamos la variable
	public ResponseEntity<Suscrito> getOne(@PathVariable Long codigo) {
		// consulta por codigo
		Optional<Suscrito> suscritoConsulta = suscritoRepository.findById(codigo);

		if (suscritoConsulta.isPresent()) {
			return new ResponseEntity<Suscrito>(suscritoConsulta.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Suscrito> deleteById(@PathVariable Long codigo) {
		//logica para eliminar a traves de una tabla precargada
		try {
			suscritoRepository.deleteById(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
