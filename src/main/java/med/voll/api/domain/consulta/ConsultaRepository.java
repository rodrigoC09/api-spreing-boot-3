package med.voll.api.domain.consulta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByPacienteIdAndFechaBetween(Long aLong, LocalDateTime primerHorario, LocalDateTime ultimoHoratio);

    Boolean existsByMedicoIdAndFecha(Long aLong, LocalDateTime fecha);
}