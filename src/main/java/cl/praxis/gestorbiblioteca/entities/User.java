package cl.praxis.gestorbiblioteca.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_usuario", unique = true)
    private Long id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String name;
    @Column(name = "apellido", length = 50, nullable = false)
    private String surname;
    @Column(name = "edad")
    private int age;
}
