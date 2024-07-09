package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    private String telefono;

    private String documento;


    @Embedded
    private Direccion direccion;

    private Boolean activo;

    public Paciente(DatosRegistroPaciente datos){
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.telefono = datos.telefono();
        this.direccion = new Direccion(datos.direccion());

    }

    public void actualizarInformacion(DatosActualizacionPaciente datos) {

        if (datos.nombre() !=null) {
            this.nombre = datos.nombre();
        }
        if (datos.telefono() !=null) {
            this.telefono = datos.telefono();
        }
        if (datos.direccion() !=null) {
            this.direccion.actualizarDatos(datos.direccion());
        }
    }
    public void eliminar(){
        this.activo = false;
    }
}
