package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepoPeajeImpl implements RepoPeaje {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    private Preferencial tarifaPreferencial;
    private Comun tarifaComun;
    private List<Vehiculo> vehiculos;


    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public RepoPeajeImpl() {
        this.vehiculos = new ArrayList<>();
        // Constructor sin parámetros requerido por CDI
    }

    public RepoPeajeImpl(Preferencial tarifaPreferencial, Comun tarifaComun) {
        this.tarifaPreferencial = tarifaPreferencial;
        this.tarifaComun = tarifaComun;
        this.vehiculos = new ArrayList<>();

    }
    @Transactional
    @Override
    public void altaVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
        this.vehiculos.add(vehiculo);

    }

    @Override
    @Transactional
    public void altaVehiculoNacional(Nacional vehiculoNacional) {
        em.persist(vehiculoNacional);
    }

    @Override
    @Transactional
    public void altaVehiculoExtranjero(Extranjero vehiculoExtranjero) {
        em.persist(vehiculoExtranjero);
    }

    @Transactional
    @Override
    public void altaTag(Tag tag) {
        em.persist(tag);
    }

    @Transactional
    @Override
    public void altaMatricula(Matricula matricula) {
        em.persist(matricula);
    }

    @Transactional
    @Override
    public void altaPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje) {
        em.persist(pasadaPorPeaje);
    }

    @Transactional
    @Override
    public void altaTarifa(Tarifa tarifa) {
        em.persist(tarifa);
    }

    @Override
    @Transactional
    public void bajaVehiculo(Long id) {
        Vehiculo vehiculo = em.find(Vehiculo.class, id);
        if (vehiculo != null) {
            em.remove(vehiculo);
        }
    }

    @Override
    @Transactional
    public void bajaVehiculoNacional(long id) {
        Nacional vehiculoNacional = em.find(Nacional.class, id);
        if (vehiculoNacional != null) {
            em.remove(vehiculoNacional);
        } else {
            throw new IllegalArgumentException("Vehículo Nacional no encontrado: " + id);
        }
    }

    @Override
    @Transactional
    public void bajaVehiculoExtranjero(long id) {
        Extranjero vehiculoExtranjero = em.find(Extranjero.class, id);
        if (vehiculoExtranjero != null) {
            em.remove(vehiculoExtranjero);
        } else {
            throw new IllegalArgumentException("Vehículo Extranjero no encontrado: " + id);
        }
    }

    @Transactional
    @Override
    public void bajaTag(long id) {
        Tag tag = em.find(Tag.class, id);
        if (tag != null) {
            em.remove(tag);
        } else {
            throw new IllegalArgumentException("Tag no encontrado: " + id);
        }
    }

    @Transactional
    @Override
    public void bajaMatricula(String id) {
        Matricula matricula = em.find(Matricula.class, id);
        if (matricula != null) {
            em.remove(matricula);
        }
    }

    @Transactional
    @Override
    public void bajaPasadaPorPeaje(long id) {
        PasadaPorPeaje pasadaPorPeaje = em.find(PasadaPorPeaje.class, id);
        if (pasadaPorPeaje != null) {
            em.remove(pasadaPorPeaje);
        } else {
            throw new IllegalArgumentException("PasadaPorPeaje no encontrada: " + id);
        }
    }

    @Override
    @Transactional
    public void bajaTarifa(int id) {
        Tarifa tarifa = em.find(Tarifa.class, id);
        if (tarifa != null) {
            em.remove(tarifa);
        } else {
            throw new IllegalArgumentException("Tarifa no encontrada: " + id);
        }
    }

    @Override
    @Transactional
    public void modificarVehiculo(Vehiculo vehiculo) {
        Vehiculo existingVehiculo = em.find(Vehiculo.class, vehiculo.getId());
        if (existingVehiculo != null) {
            existingVehiculo.setTag(vehiculo.getTag());
            existingVehiculo.setPasadaPorPeajeList(vehiculo.getPasadaPorPeajeList());
            existingVehiculo.setNacionalidad(vehiculo.getNacionalidad());
            em.merge(existingVehiculo);
        } else {
            // Si el vehículo no existe, puedes lanzar una excepción o manejarlo de otra manera
            throw new IllegalArgumentException("Vehículo no encontrado: " + vehiculo.getId());
        }
    }

    @Override
    @Transactional
    public void modificarVehiculoNacional(Nacional vehiculoNacional) {
        Nacional existingVehiculoNacional = em.find(Nacional.class, vehiculoNacional.getId());
        if (existingVehiculoNacional != null) {
            existingVehiculoNacional.setMatricula(vehiculoNacional.getMatricula());
            existingVehiculoNacional.setTag(vehiculoNacional.getTag());
            existingVehiculoNacional.setPasadaPorPeajeList(vehiculoNacional.getPasadaPorPeajeList());
            existingVehiculoNacional.setNacionalidad(vehiculoNacional.getNacionalidad());
            em.merge(existingVehiculoNacional);
        } else {
            throw new IllegalArgumentException("Vehículo Nacional no encontrado: " + vehiculoNacional.getId());
        }
    }

    @Override
    @Transactional
    public void modificarVehiculoExtranjero(Extranjero vehiculoExtranjero) {
        Extranjero existingVehiculoExtranjero = em.find(Extranjero.class, vehiculoExtranjero.getId());
        if (existingVehiculoExtranjero != null) {
            existingVehiculoExtranjero.setTag(vehiculoExtranjero.getTag());
            existingVehiculoExtranjero.setPasadaPorPeajeList(vehiculoExtranjero.getPasadaPorPeajeList());
            existingVehiculoExtranjero.setNacionalidad(vehiculoExtranjero.getNacionalidad());
            em.merge(existingVehiculoExtranjero);
        } else {
            throw new IllegalArgumentException("Vehículo Extranjero no encontrado: " + vehiculoExtranjero.getId());
        }
    }

    @Transactional
    @Override
    public void modificarTag(Tag tag) {
        Tag existingTag = em.find(Tag.class, tag.getId());
        if (existingTag != null) {
            existingTag.setIdUnico(tag.getIdUnico());
            em.merge(existingTag);
        } else {
            throw new IllegalArgumentException("Tag no encontrado: " + tag.getId());
        }
    }

    @Transactional
    @Override
    public void modificarMatricula(Matricula matricula) {
        Matricula matriculaExistente = em.find(Matricula.class, matricula.getId());
        if (matriculaExistente != null) {
            matriculaExistente.setNroMatricula(matricula.getNroMatricula());
            em.merge(matriculaExistente);
        } else {
            throw new IllegalArgumentException("Matrícula no encontrada: " + matricula.getId());
        }
    }

    @Transactional
    @Override
    public void modificarPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje) {
        PasadaPorPeaje existingPasadaPorPeaje = em.find(PasadaPorPeaje.class, pasadaPorPeaje.getId());
        if (existingPasadaPorPeaje != null) {
            existingPasadaPorPeaje.setFecha(pasadaPorPeaje.getFecha());
            existingPasadaPorPeaje.setCosto(pasadaPorPeaje.getCosto());
            existingPasadaPorPeaje.setTipoCobro(pasadaPorPeaje.getTipoCobro());
            em.merge(existingPasadaPorPeaje);
        } else {
            throw new IllegalArgumentException("PasadaPorPeaje no encontrada: " + pasadaPorPeaje.getId());
        }
    }

    @Override
    @Transactional
    public void modificarTarifa(Tarifa tarifa) {
        Tarifa existingTarifa = em.find(Tarifa.class, tarifa.getId());
        if (existingTarifa != null) {
            existingTarifa.setMonto(tarifa.getMonto());
            existingTarifa.setTipoTarifa(tarifa.getTipoTarifa());
            em.merge(existingTarifa);
        } else {
            throw new IllegalArgumentException("Tarifa no encontrada: " + tarifa.getId());
        }
    }

    @Override
    @Transactional
    public Vehiculo BuscarTag(String tag) {
        try {
            Vehiculo vehiculo = em.createQuery("SELECT v FROM peaje_Vehiculo v WHERE v.tag.idUnico= :tag", Vehiculo.class)
                    .setParameter("tag", tag)
                    .getSingleResult();

            return vehiculo;
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    @Transactional
    public Vehiculo BuscarMatricula(String matricula) {
        try {
            Nacional nacional  = em.createQuery("SELECT v FROM peaje_vehiculoNacional v WHERE v.matricula = :matricula", Nacional.class)
                    .setParameter("matricula", matricula)
                    .getSingleResult();
            // Inicializar la colección pasadaPorPeajeList
            nacional.getPasadaPorPeajeList().size();
            return nacional;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Preferencial obtenerTarifaPreferencial() {
        return tarifaPreferencial;
    }

    @Override
    public double obtenerTarifaComun() {
        return tarifaComun.obtenerMonto();
    }


}
