package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
//import org.jboss.logging.Logger;


import java.util.*;

@ApplicationScoped
public class RepoClientesImp implements RepoClientes {
    //private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    private Map<String, ClienteTelepeaje> clientesTelepeajeMap;
    private Map<String, ClienteSucive> clientesSuciveMap;
    private List<Vehiculo> vehiculos = new ArrayList<>();


    @PersistenceContext
    private EntityManager em;
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }


    public RepoClientesImp() {

        clientesTelepeajeMap = new HashMap<>();
        clientesSuciveMap = new HashMap<>();
        this.vehiculos = new ArrayList<>();

    }

    @Transactional
    @Override
    public void agregarClienteTelepeaje(ClienteTelepeaje cliente) {
        em.persist(cliente);
        //clientesTelepeajeMap.put(cliente.getCi(), cliente);
    }
    @Transactional
    @Override
    public void agregarClienteSukcsive(ClienteSucive cliente) {
        em.persist(cliente);
        //clientesSuciveMap.put(cliente.getCi(), cliente);
    }
    @Transactional
    @Override
    public ClienteTelepeaje buscarClienteTelePorCI(String ci) {

        return em.find(ClienteTelepeaje.class, ci);
                //clientesTelepeajeMap.get(ci);
    }
    @Transactional
    @Override
    public ClienteSucive buscarClienteSucPorCI(String ci) {

        return em.find(ClienteSucive.class, ci);
                //clientesSuciveMap.get(ci);
    }
    @Transactional
    @Override
    public void actualizarCliente(ClienteTelepeaje cliente) {
        ClienteTelepeaje existingCliente = em.find(ClienteTelepeaje.class, cliente.getCi());
        if (existingCliente != null) {
            em.merge(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + cliente.getCi());
        }
    }
    @Transactional
    @Override
    public void eliminarClientePorCI(String ci) {
        ClienteTelepeaje cliente = em.find(ClienteTelepeaje.class, ci);
        if (cliente != null) {
            em.remove(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + ci);
        }
    }
    @Transactional
    @Override
    public void agregarClienteSucive(ClienteSucive cliente) {
        em.persist(cliente);
        //clientesSuciveMap.put(cliente.getCi(), cliente);
    }
    @Transactional
    @Override
    public void actualizarCliente(ClienteSucive cliente) {
        ClienteSucive existingCliente = em.find(ClienteSucive.class, cliente.getCi());
        if (existingCliente != null) {
            em.merge(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + cliente.getCi());
        }
    }
    @Transactional
    @Override
    public void eliminarClienteSucivePorCI(String ci) {
        ClienteSucive cliente = em.find(ClienteSucive.class, ci);
        if (cliente != null) {
            em.remove(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: " + ci);
        }}

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Transactional
    @Override
    public Vehiculo BuscarTag(String tag) {
        try {
            return em.createQuery("SELECT v FROM gestion_Vehiculo v WHERE v.tag.idUnico = :tag", Vehiculo.class)
                    .setParameter("tag", tag)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }




    @Transactional
    @Override
    public void altaMatricula(Matricula matricula) {
        em.persist(matricula);
    }
    @Transactional
    @Override
    public void bajaMatricula(long id) {
        Matricula matricula = em.find(Matricula.class, id);
        if (matricula != null) {
            em.remove(matricula);
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
    public void altaPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje) {
        em.persist(pasadaPorPeaje);
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
    @Transactional
    @Override
    public List<PasadaPorPeaje> buscarPasadaPorPeaje(Vehiculo vehiculo, Date fechaInicio, Date fechaFin)
    {
        return em.createQuery(
                        "SELECT p FROM gestion_PasadaPorPeaje p WHERE p.vehiculo = :vehiculo AND p.fecha BETWEEN :fechaInicio AND :fechaFin",
                        PasadaPorPeaje.class)
                .setParameter("vehiculo", vehiculo)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
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

    @Transactional
    @Override
    public void altaTag(Tag tag) {
        em.persist(tag);
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
    @Override
    @Transactional
    public void ModificarTag(Tag tag) {
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
    public void altaVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
        //this.vehiculos.add(vehiculo);

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
    public void modificarVehiculo(Vehiculo vehiculo) {
        Vehiculo existingVehiculo = em.find(Vehiculo.class, vehiculo.getId());
        if (existingVehiculo != null) {
            existingVehiculo.setTag(vehiculo.getTag());
            //existingVehiculo.setPasadaPorPeajeList(vehiculo.getPasadaPorPeajeList());
            existingVehiculo.setNacionalidad(vehiculo.getNacionalidad());
            em.merge(existingVehiculo);
        } else {
            // Si el vehículo no existe, puedes lanzar una excepción o manejarlo de otra manera
            throw new IllegalArgumentException("Vehículo no encontrado: " + vehiculo.getId());
        }
    }
}

