package com.example.sigleTable;

import com.example.sigleTable.entidades.Alumno;
import com.example.sigleTable.entidades.Profesor;
import com.example.sigleTable.enuneraciones.Especialidades;
import com.example.sigleTable.enuneraciones.Titulos;
import com.example.sigleTable.repositorios.AlumnoRepository;
import com.example.sigleTable.repositorios.PersonaRepository;
import com.example.sigleTable.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SigleTableApplication {


	private static final Logger logger = LoggerFactory.getLogger(SigleTableApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SigleTableApplication.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			Profesor pro1 = Profesor.builder()
					.nombre("Juan")
					.apellido("Perez")
					.fechaIngreso(LocalDate.of(2002, 6, 30))
					.cantHijos(0)
					.edad(49)
					.titulo(Titulos.LICENCIADO)
					.sueldo(new BigDecimal("20.45"))
					.build();

			Profesor pro2 = Profesor.builder()
					.nombre("Maria")
					.apellido("Gutierrez")
					.fechaIngreso(LocalDate.of(2020, 10, 5))
					.cantHijos(1)
					.edad(33)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("255.45"))
					.build();

			Alumno alu1 = Alumno.builder()
					.nombre("Rosa")
					.apellido("Flores")
					.edad(20)
					.especialidad(Especialidades.BACHILLER)
					.legajo(68412)
					.build();

			Alumno alu2 = Alumno.builder()
					.nombre("Alan")
					.apellido("Castillo")
					.edad(25)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.legajo(19758)
					.build();


			profesorRepository.save(pro1);
			profesorRepository.save(pro2);
			alumnoRepository.save(alu1);
			alumnoRepository.save(alu2);











		};

	};




}
