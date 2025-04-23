package utiles.usb;
/* 
public class menu {
        BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
    
        public static void mostrarmenu() {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Listar Viajes");
            System.out.println("0.SALIR");
        }
    
        public static String iniciarsesion() throws IOException {
            String contrasena;
            String usuario;
            System.out.println("Introduce tu nombre de usuario");
            usuario = bufEntrada.readLine();
            System.out.println("Introduce tu contraseña");
            contrasena = bufEntrada.readLine();
            if (usuario.equals("admin") && contrasena.equals("abc123.")) {
                menuusuario();
            }
            return usuario;
        }
    
        public static void menuusuario() throws IOException {
            int opcionusuario2;
            do {
                System.out.println("1. Mis viajes");
                System.out.println("2. Crear Viajes");
                System.out.println("3. Cerrar sesión");
                System.out.println("0. SALIR");
                opcionusuario2 = Integer.parseInt(bufEntrada.readLine());
                switch (opcionusuario2) {
                case 1:
                    System.out.println("No tienes viajes próximamente");
                    break;
                case 2:
                    System.out.println("¿A dónde deseas viajar?");
                    break;
                case 3:
                    System.out.println("Se va a proceder a cerrar la sesión.");
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                }
            } while (!(opcionusuario2==0 || opcionusuario2==3));
        }
    
        public static void leerviajes() {
            System.out.println("Viaje 1: Polonia");
            System.out.println("Viaje 2: Japón");
            System.out.println("Viaje 3: Canadá");
            System.out.println("Viaje 4: Tailandia");
        }
    
        public static void main(String args[]) throws IOException {
            int opcionusuario;
            String usuario;
            // bucle controlado por condicion  - no sabemos cuantas veces se va a ejecutar
            do {
                mostrarmenu();
                System.out.println("Escribe el número de tu elección: ");
                opcionusuario = Integer.parseInt(bufEntrada.readLine());
                switch (opcionusuario) {
                case 1:
                    usuario = INICIARSESION;
                    if ((!usuario.equals(""))) {
                        System.out.println("Menu de usuario:");
                    } else {
                        System.out.println("Inicio de sesión incorrecto");
                    }
                    break;
                case 2:
                    leerviajes();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Acción incorrecta.");
                    mostrarmenu();
                }
            } while (opcionusuario!=0);
        }
    
    
    }
    
    
*/