import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

// Clases externas
interface GuitabSDK {
    void crearRepositorioConAcceso(String nombre, List<String> usernames);
    void darAcceso(String nombreRepo, String username);
    void quitarAcceso(String nombreRepo, String username);
}

interface SCM {
    void crearRepositorio(String nombre, List<String> usernames);
    void darAcceso(String nombreRepo, String username);
    void quitarAcceso(String nombreRepo, String username);
}

class Guitab implements SCM {
    GuitabSDK guitabSDK;

    public Guitab(GuitabSDK guitabSDK) {
        this.guitabSDK = guitabSDK;
    }

    public void crearRepositorio(String nombre, List<String> usernames) {
        this.guitabSDK.crearRepositorioConAcceso(nombre, usernames);
    }
    public void darAcceso(String nombreRepo, String username) {

    }
    public void quitarAcceso(String nombreRepo, String username) {

    }
}

class MailSender {
    public void send(String address, String subject, String body) {

    }
}

interface Correo {
    void enviar(String mail, String mensaje);
}

class CorreoMailSender implements Correo {

    public void enviar(String mail, String mensaje) {
        new MailSender().send(mail, "Modificacion en Grupo", mensaje);
    }
}


// Dominio

class RepoGrupos {
    List<Grupo> grupos;

    public void crearGrupos(int cantGrupos, int tamanioIdeal) {
        for(int i = 0; i < cantGrupos; i++) {
            this.grupos.add(new Grupo(tamanioIdeal));
        }
    }

    public List<Grupo> getGruposCerrados() {
        return this.grupos.stream().filter(g -> g.estaCerrado()).collect(Collectors.toList());
    }
}

class Grupo {
    String nombre;
    int tamanioIdeal;
    List<Estudiante> estudiantes;
    boolean estaCerrado = false;
    List<Cambio> cambiosPendientes;
    List<Tarea> tareas;
    List<Entrega> entregasHabilitadas;

    public Grupo(int tamanioIdeal) {
        this.tamanioIdeal = tamanioIdeal;
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if(!this.estaCerrado) {
            agregarEstudiante(estudiante);
        } else {
            posponerInscripcion(estudiante);
        }
    }

    public void agregarEstudiante(Estudiante estudiante) {
        notificarAlta(estudiante);
        this.estudiantes.add(estudiante);   
    }

    public void posponerInscripcion(Estudiante estudiante) {
        this.cambiosPendientes.add(new AltaEstudiante(estudiante));
    }

    public void notificarAlta(Estudiante estudiante) {
        this.tareas.forEach(t -> t.notificarAlta(this, estudiante));
    }

    public void darBajaEstudiante(Estudiante estudiante) {
        if(!this.estaCerrado) {
            eliminarEstudiante(estudiante);
        } else {
            posponerBaja(estudiante);
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.notificarBaja(estudiante);
        this.estudiantes.remove(estudiante);   
    }

    public void notificarBaja(Estudiante estudiante) {
        this.tareas.forEach(t -> t.notificarBaja(this, estudiante));
    }

    public void posponerBaja(Estudiante estudiante) {
        this.cambiosPendientes.add(new BajaEstudiante(estudiante));
    }

    public void aplicarCambio(Cambio cambio) {
        this.cambiosPendientes.remove(cambio);
        cambio.aplicarEn(this);
    }


    public void cerrarGrupo() {
        if(this.estudiantes.size() == this.tamanioIdeal) {
            this.estaCerrado = true;
            notificarCierre();
        } else {
            posponerCierre();
        }
    }

    public void posponerCierre() {
        this.cambiosPendientes.add(new Cierre());
    }

    public void notificarCierre() {
        this.tareas.forEach(t -> t.notificarCierre(this));
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<String> getUsernames() {
        return this.estudiantes.stream().map(e -> e.getGitUsername()).collect(Collectors.toList());
    }

    public List<String> getEmails() {
        return this.estudiantes.stream().map(e -> e.getMail()).collect(Collectors.toList());
    }

    public boolean estaCerrado() {
        return this.estaCerrado;
    }

    public void habilitarEntrega(Entrega entrega) {
        this.entregasHabilitadas.add(entrega);
        new EnviarMail().notificarEntrega(this, entrega);
    }

}

class Estudiante {
    String nombre;
    String mail;
    String gitUsername;

    public String getNombre() {
        return this.nombre;
    }
    public String getMail() {
        return this.mail;
    }
    public String getGitUsername() {
        return this.gitUsername;
    }
}


interface Cambio {
    void aplicarEn(Grupo grupo);
}

class AltaEstudiante implements Cambio{
    Estudiante estudiante;

    public AltaEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void aplicarEn(Grupo grupo) {
        grupo.agregarEstudiante(this.estudiante);
    }
}

class BajaEstudiante implements Cambio {
    Estudiante estudiante;

    public BajaEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void aplicarEn(Grupo grupo) {
        grupo.eliminarEstudiante(this.estudiante);
    }
}

class Cierre implements Cambio {
    public void aplicarEn(Grupo grupo) {
        
    }
}

interface Tarea {
    void notificarCierre(Grupo grupo);
    void notificarAlta(Grupo grupo, Estudiante estudiante);
    void notificarBaja(Grupo grupo, Estudiante estudiante);
}

class CrearRepo implements Tarea {
    SCM scm;
    public void notificarCierre(Grupo grupo) {
        this.scm.crearRepositorio("repo-" + grupo.getNombre(), grupo.getUsernames());
    }
    public void notificarAlta(Grupo grupo, Estudiante estudiante) {
    }
    public void notificarBaja(Grupo grupo, Estudiante estudiante) {
    }
}

class EnviarMail implements Tarea {
    Correo correo;
    public void notificarCierre(Grupo grupo) {
    }
    public void notificarAlta(Grupo grupo, Estudiante estudiante) {
        grupo.getEmails().forEach(mail -> correo.enviar(mail, "Se inscribio al grupo: " + estudiante.getNombre()));
    }
    public void notificarBaja(Grupo grupo, Estudiante estudiante) {
        grupo.getEmails().forEach(mail -> correo.enviar(mail, "Se dio de baja al grupo: " + estudiante.getNombre()));
    }

    public void notificarEntrega(Grupo grupo, Entrega entrega) {
        grupo.getEmails().forEach(mail -> correo.enviar(mail, "Se libero entrega: " + entrega.getURL()));
    }
}

class DarPermisoRepo implements Tarea {
    SCM scm;
    public void notificarCierre(Grupo grupo) {
    }
    public void notificarAlta(Grupo grupo, Estudiante estudiante) {
        if(grupo.estaCerrado()) {
            this.scm.darAcceso("repo-" + grupo.getNombre(), estudiante.getGitUsername());
        }
    }
    public void notificarBaja(Grupo grupo, Estudiante estudiante) {
    }
}

class QuitarPermisoRepo implements Tarea {
    SCM scm;
    public void notificarCierre(Grupo grupo) {
    }
    public void notificarAlta(Grupo grupo, Estudiante estudiante) {
    }
    public void notificarBaja(Grupo grupo, Estudiante estudiante) {
        if(grupo.estaCerrado()) {
            this.scm.quitarAcceso("repo-" + grupo.getNombre(), estudiante.getGitUsername());
        }
    }
}


class RepoAsignaciones {
    RepoGrupos repoGrupos;
    List<Asignacion> asignaciones;

    public void distribuirEntregas() {
        this.repoGrupos.getGruposCerrados().forEach(g -> habilitarEntregas(g));
    }

    // Este metodo se ejecuta semanalmente en un main utilizando un cron (ejemplo crontab de linux)
    public void habilitarEntregas(Grupo grupo) {
        this.asignaciones.forEach(a -> {
            grupo.habilitarEntrega(a.entregas.get(0));
        });
    }
}

class Asignacion {
    TipoAsignacion tipoAsignacion;
    String titulo;
    List<Entrega> entregas;
}

enum TipoAsignacion {
    TP,
    ACTIVIDAD_CLASE
}

class Entrega {
    URL url;

    public URL getURL() {
        return this.url;
    }
}