package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import py.edu.ucsa.webapp01.DTO.MarcaDTO;

public class Tests {
	public static void main(String[] args) {
		
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		Date fingreso = null;
		try {
			fingreso = new Date(formateador.parse("2015/06/02").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MarcaDTO m = new MarcaDTO();
		long i = 4;
		m.setId(i);
		m.setCodigo("4A");
		m.setDescripcion("Niko");
		m.setFechaInsercion(fingreso);

		MarcaDAO imp = new MarcaImpl();
		//imp.insertMarca(m);
		//imp.borrarMarca("2A");
		//imp.actualizarMarca(m);
		ArrayList<MarcaDTO> listaMarcas = null;
		listaMarcas = imp.listarMarca();
		for (MarcaDTO marcaDTO : listaMarcas) {
			System.out.println("*********************************************");
			System.out.println(" id= "+ marcaDTO.getId());
			System.out.println(" codigo= "+ marcaDTO.getCodigo());
			System.out.println(" descripcion= "+ marcaDTO.getDescripcion());
			System.out.println(" Fecha de ingreso= "+ marcaDTO.getFechaInsercion());	
		}
	}
}
