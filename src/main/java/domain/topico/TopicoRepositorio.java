package domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepositorio extends JpaRepository<Topico,Long> {
    @Query("""
            select t from Topico t
            order by
            t.fechaCreacion
            desc
            """)
    Page<Topico> ordenarPorMasReciente(Pageable paginacion);

    boolean existsByTitulo(String titulo);

    boolean existsByMensaje(String mensaje);
}
