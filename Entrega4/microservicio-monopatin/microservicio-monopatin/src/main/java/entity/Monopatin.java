@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monopatin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_monopatin;
    @Column
    private String ubicacionActual;
    @Column
    private Boolean estaActivo;
    @Column
    private Boolean habilitado;
    @Column
    private Double kilometrosTotales;
    @Column
    private Integer tiempo_uso_total;

//getters y setters


}
