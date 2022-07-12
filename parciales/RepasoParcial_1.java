import java.util.List;

/*
Como docente, deseo poder crear N grupos de trabajo de un tamaño ideal M, vacíos, para permitir la inscripción de estudiantes a cada grupo
Como estudiante, deseo poder inscribirme o darme de baja instantáneamente de un grupo abierto.
Como estudiante, deseo recibir una notificación por correo electrónico cada vez que alguien se inscribe o se da de baja de mi grupo de trabajo. 
Como docente, deseo poder cerrar un grupo que tiene tamaño M.
Como docente, deseo que cuando un grupo sea cerrado, se cree el repositorio correspondiente en Guitab.
Como docente, deseo poder aprobar o rechazar el intento de otro docente de cerrar un grupo que no es de tamaño M.
Como estudiante, quiero solicitar inscribirme o darme de baja de un grupo cerrado.
Como docente, quiero poder aprobar o rechazar la solicitud de alta o baja de un estudiante para un grupo cerrado.
Como docente, deseo que al incluir o eliminar un estudiante de un grupo cerrado, este reciba o pierda los accesos al repositorio del equipo.
Como administrador, deseo poder configurar qué tareas se ejecutan cuando se realiza un cambio sobre un grupo.
Como docente, quiero poder crear asignaciones con una o varias entregas.
Como docente, deseo que el sistema le dé automáticamente acceso a los estudiantes a cada entrega a medida que las semanas de cursada transcurren

*/


class Grupo {
    List<Estudiante> estudiantes;
    int tamanioIdeal;
    Correo correo;
    boolean estaCerrado;
    List<Cambio> cambiosPendientes;

    public Grupo(int tamanioIdeal) {
        this.tamanioIdeal = tamanioIdeal;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if(this.estaCerrado) {
            posponerAgregado(estudiante);
        } else {
            this.estudiantes.add(estudiante);
            notificarEstudiantes("Se suma al grupo " + estudiante.getNombre());    
        }

    }

    public void darBaja(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }

    public void notificarEstudiantes(String mensaje) {
        this.estudiantes.forEach(e -> this.correo.enviar(mensaje, e.getMail()));
    }

    public void cerrar() {
        if(tamanioGrupo() == this.tamanioIdeal) {
            this.estaCerrado = true;
            crearRepoGithub();
        } else { // Pendiente
            posponerCierre();
        }
    }

    public int tamanioGrupo() {
        return this.estudiantes.size();
    }

    public void posponerAgregado(Estudiante estudiante) {
        // TODO
        this.cambiosPendientes.add(new AgregarEstudiante(estudiante));
    }

    public void posponerCierre() {
        this.cambiosPendientes.add(new Cerrar());
    }

}

class Estudiante {
    String mail;
    String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public String getMail() {
        return this.mail;
    }

}

class RepositorioGrupos {
    List<Grupo> grupos;

    public void generarGrupos(int tamIdeal, int cantidad) {
        for(int i = 0; i < cantidad; i++) {
            this.grupos.add(new Grupo(tamIdeal));
        }
    }
}

interface Correo {
    public void enviar(String mensaje, String mail);

}

class CorreoMailSender implements Correo {

    private MailSender mailSender;

    public CorreoMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override    
    public void enviar(String mensaje, String mail) {
        mailSender.send(mail, "tenes una notificacion", mensaje);

        // Otra opcion: instanciar MailSender
        //new MailSender().send(mail, "tenes una notificacion", mensaje);
    }

}

class GuiTab implements SCM {
    GuitabSDK guitabSDK;

    @Override
    public void crear(String nombreRepo, List<String> nombreEstudiantes) {
        this.guitabSDK.crearRepositorioConAccesos(nombreRepo, nombreEstudiantes);
    }
}

interface SCM {
    public void crear(String nombreRepo, List<String> nombreEstudiantes);
}


interface Cambio {
    public void aplicarSobre(Grupo grupo);
}

class AgregarEstudiante implements Cambio {
    Estudiante estudiante;

    public AgregarEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void aplicarSobre(Grupo grupo) {

    }

}

class Cerrar implements Cambio {
    public void aplicarSobre(Grupo grupo) {

    }
}


// Clases externas
class MailSender {
    public void send(String mail, String asunto, String mensaje) {

    }
}

interface GuitabSDK {
    public void crearRepositorioConAccesos(String nombre, List<String> usernames);
    public void darAcceso(String nombreRepo, String username);
    public void quitarAcceso(String nombreRepo, String username);
}
