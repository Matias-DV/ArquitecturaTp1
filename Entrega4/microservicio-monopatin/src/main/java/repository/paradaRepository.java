@Repository
public interface paradaRepository extends JpaRepository <Parada,Integer>{
    @Query("SELECT p FROM Parada p WHERE p.id_parada = :id_parada")
    Parada getParada(@Param("id_parada") int id_parada);

    @Modifying
    @Query("UPDATE Parada p SET p.ubicacion = :ubicacion, p.permitida = :permitida WHERE p.id_parada = :id_parada")
    void updateParada(@Param("ubicacion") String ubicacion, @Param("permitida") boolean permitida, @Param("id_parada") int id_parada);

    @Query("DELETE FROM Parada p WHERE p.id_parada = :id_parada")
    void deleteParada(@Param("id_parada") int id_parada);

}