package main.modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.datos.Persona;
import main.datos.Deporte;
import main.datos.Municipio;
import main.datos.Estado;
import main.modelo.excepciones.ApellidoIncorrectoException;
import main.modelo.excepciones.CamposIncompletosException;
import main.modelo.excepciones.NombreIncorrectoException;
import main.modelo.excepciones.DeportesVaciosException;
import main.modelo.excepciones.MunicipioNoSeleccionadoException;
import main.modelo.excepciones.EstadoNoSeleccionadoException;

/**
 *
 * @author Uriel
 */
public class Validaciones {

		/**
		 * Verifica que el nombre y los apellidos de una persona cumplan con la
		 * expresion regular y que ninguno de estos campos se encuentre vacio, si no
		 * cumplen con la expresion o alguno se encuentra vacio arroja una
		 * excepcion.
		 *
		 * @param p Un objeto de tipo persona
		 * @throws NombreIncorrectoExeption
		 * @throws ApellidoIncorrectoException
		 * @throws CamposIncompletosException
		 * @throws DeportesVaciosException
		 */
		public static void validarPersona(Persona p) throws NombreIncorrectoException,
						ApellidoIncorrectoException, CamposIncompletosException, DeportesVaciosException,
						EstadoNoSeleccionadoException, MunicipioNoSeleccionadoException {
				String expReg = "[[[A-ZÁÉÍÓÚ][a-záéíóú]+]\\s*]+";
				String nombrePersona = p.getNombre();
				String apellidoPaterno = p.getApPaterno();
				String apellidoMaterno = p.getApMaterno();
				ArrayList<Deporte> al = p.getDeportes();
				Municipio m = p.getMunicipio();
				Estado e = m.getEstado();

				if (nombrePersona.length() == 0
								|| apellidoMaterno.length() == 0
								|| apellidoPaterno.length() == 0) {
						throw new CamposIncompletosException("Uno o más campos está vacío, favor de verificar.");
				}

				Pattern patron = Pattern.compile(expReg);
				Matcher matcherNombre = patron.matcher(nombrePersona);
				Matcher matcherApellidoPat = patron.matcher(apellidoPaterno);
				Matcher matcherApellidoMat = patron.matcher(apellidoMaterno);

				if (!matcherNombre.matches()) {
						throw new NombreIncorrectoException("Nombre escrito incorrectamente");
				}
				if (!matcherApellidoPat.matches()
								|| !matcherApellidoMat.matches()) {
						throw new ApellidoIncorrectoException("Apellido escrito incorrectamente");
				}
				if (al.isEmpty()) {
						throw new DeportesVaciosException("No se seleccionado ningún deporte");
				}
				if (m.getIdMunicipio() == 0) {
						throw new MunicipioNoSeleccionadoException("No se ha seleccionado algún municipio");
				}
				if (e.getIdEstado() == 0) {
						throw new EstadoNoSeleccionadoException("No se ha seleccionado algún estado");
				}
		}
}
