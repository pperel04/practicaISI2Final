class Trabajador {
	public int id;
	public String nombre = null;
	public String apellido1 = null;
	public String apellido2 = null;
	private String dni = null;

	public Trabajador() {

	}

	public void setdni(String dnist) {
		StringBuffer dnibuff = new StringBuffer(dnist);
		StringBuffer dnioriginal = new StringBuffer(dnist);
		if (dnibuff.length() == 9) { // comprobar que el dni tiene 9 digitos y es valido
			// Comprobando la primera letra por si es un NIE
			if (dnibuff.charAt(0) == 'X') {
				dnibuff.setCharAt(0, '0');
			}
			if (dnibuff.charAt(0) == 'Y') {
				dnibuff.setCharAt(0, '1');
			}
			if (dnibuff.charAt(0) == 'Z') {
				dnibuff.setCharAt(0, '2');
			}
			dnibuff.deleteCharAt(8); // eliminamos la ulima letra para poder pasarlo a int
			StringBuffer letras = new StringBuffer("TRWAGMYFPDXBNJZSQVHLCKE");
			int dninum = Integer.parseInt(dnibuff.toString());
			int correspondencia = dninum % 23; // buscando la letra correspondiente
			// dnibuff.append(letras.charAt(correspondencia));
			dnioriginal.setCharAt(8, letras.charAt(correspondencia));
			dni = dnioriginal.toString();
		}
	}

	public String getdni() {
		return dni;
	}

	public void imprime() {
		System.out.println("Trabajador: " + id + ", Nombre " + nombre + ", Apellidos " + apellido1 + " " + apellido2
				+ ", DNI " + dni);
	}

}
