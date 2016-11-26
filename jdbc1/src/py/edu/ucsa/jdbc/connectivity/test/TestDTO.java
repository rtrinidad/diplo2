package py.edu.ucsa.jdbc.connectivity.test;

import java.sql.Date;
import java.util.List;

import py.edu.ucsa.jdbc.connectivity.dao.FuncionariosDAO;
import py.edu.ucsa.jdbc.connectivity.dao.impl.FuncionariosDAOImpl;
import py.edu.ucsa.jdbc.connectivity.dto.FuncionarioDTO;


public class TestDTO {

		public static void main(String[] args) {
		
			
	// CREAMOS LA CLASE dao para INSTANCIAR LOS METODOS LISTAR,INSERTAR,ACTUALIZAR,ELIMINAR		
			    FuncionariosDAO dao = new FuncionariosDAOImpl();
			
	// ####### - CREAR TABLA SI NO EXISTE - #######					
			
			    dao.crearTabla(); // SI NO EXISTE, CREA LA TABLA
	
	// ####### - LISTAR FUNCIONARIOS - #######	
				
				
				
				List<FuncionarioDTO> lista = dao.listar();
				System.out.println("**********LISTA DE FUNCIONARIOS**********");
				System.out.println(" ");
				for (FuncionarioDTO funcionarioDTO : lista){
				
					//System.out.println("Codigo: " + funcionarioDTO.getCodigo() + " - Nombres: " + funcionarioDTO.getNombres() + ", "+ funcionarioDTO.getApellidos() + " - Salario: " + funcionarioDTO.getSalario());
					System.out.println(funcionarioDTO.toString());
					System.out.println();
				}
				
	// ####### - ACTUALIZAR FUNCIONARIO - #######			
				
				FuncionarioDTO func1 = new FuncionarioDTO();
				func1.setId(1);
				func1.setCodigo(1);
				func1.setNombres("Ricardo Manuel");
				func1.setApellidos("Trinidad Barboza");
				func1.setSalario((double) 5850000);
				
				dao.actualizar(func1);
				System.out.println("**********ACTUALIZAR FUNCIONARIO**********");
				System.out.println("SALARIO ACTUALIZADO del Funcionario con id= "+func1.getId()+" - "+func1.getNombres()+" "+func1.getApellidos());
				System.out.println();
				
	// ####### - INSERTAR FUNCIONARIO - #######	
				
			
				//Date date = new Date(0);
				Date nac = Date.valueOf("1987-05-10");
				Date ing = Date.valueOf("2005-02-12");
				
				FuncionarioDTO func2 = new FuncionarioDTO();
				func2.setId(8);
				func2.setCodigo(8);
				func2.setNombres("Jose Maria");
				func2.setApellidos("Santander Franco");
				func2.setFechaNacimiento(nac);
				func2.setFechaIngreso(ing);
				func2.setSalario((double) 4850000);
				
				dao.insertar(func2);
				
				System.out.println("**********INSERTAR FUNCIONARIO**********");
				System.out.println("INSERCCION FUNCIONARIO con id= "+func2.getId()+" - "+func2.getNombres()+" "+func2.getApellidos());
				System.out.println();
				
	// ####### - ELIMINAR FUNCIONARIO - #######		
				Integer idfuncionario=8;
				dao.eliminar(idfuncionario);
				
				System.out.println("**********ELIMINAR FUNCIONARIO**********");
				System.out.println("SE ELIMINO FUNCIONARIO con id= "+idfuncionario);
				System.out.println();
		}

}
