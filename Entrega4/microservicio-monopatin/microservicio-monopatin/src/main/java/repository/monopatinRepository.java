@Repository
public interface monopatinRepository  extends JpaRepository<Monopatin,Integer>{
    @Query("SELECT m FROM Monopatin m WHERE m.id_monopatin = :id_monopatin")
    Monopatin getMonopatin(@Param("id_monopatin") int id_monopatin);

    @Modifying
    @Query("UPDATE Monopatin m SET m.ubicacionActual = :ubicacionActual, m.estaActivado = :estaActivado, m.habilitado = :habilitado, m.kilometrosTotales = :kilometrosTotales, m.tiempo_uso_total = :tiempoTotal WHERE m.id_monopatin = :id_monopatin")
    void updateMonopatin(@Param("ubicacionActual") String ubicacionActual, @Param("estaActivado") boolean estaActivado, @Param("habilitado") boolean habilitado, @Param("kilometrosTotales") double kilometrosTotales, @Param("tiempo_uso_total") int tiempo_uso_total, @Param("id_monopatin") int id_monopatin);

    @Query("DELETE FROM Monopatin m WHERE m.id_monopatin = :id_monopatin")
    void deleteParada(@Param("id_monopatin") int id_monopatin);

}