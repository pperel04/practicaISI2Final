import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelManager exc = new ExcelManager();
		ArrayList<Trabajador> trabajadores = exc.cargartrabajadores();
		for (int i = 0; i < trabajadores.size(); i++) {
			trabajadores.get(i).imprime();
		}
		exc.guardartrabajadores(trabajadores);
	}

}