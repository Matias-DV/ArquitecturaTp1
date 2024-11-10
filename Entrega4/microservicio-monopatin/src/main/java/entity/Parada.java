@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parada{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_parada;
    @Column
    private String ubicacion;
    @Column
    private Boolean permitida;

    //getters y setters
}