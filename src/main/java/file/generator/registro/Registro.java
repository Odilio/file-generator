package file.generator.registro;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import file.generator.util.ConversorACFiscal;

public class Registro extends ATipoRegistro {

	public int VersaoLeiaute; // Tamanho 2 - N
	public String SistemaOrigem; // Tamanho 62 - C
	public Date DataGeracao; // Tamanho 8 - D
	public int Empresa; // Tamanho 15 - C
	public String DataInicialLancamentos; // Tamanho 8 - D
	public String DataFinalLancamentos; // Tamanho 8 - D
	public String Comentario; // Tamanho 40 - C
	public boolean AliquotasEspecificas; // Tamanho 1 - L
	
	public Registro() {
		TipoRegistro = ETipoRegistro.CAB;
	}

	@Override
	public void MontarParametros() {
		try {
			Parametros = new String[8];
			
			Parametros[0] = ConversorACFiscal.IntParaString(VersaoLeiaute, 2);
			Parametros[1] = SistemaOrigem;
			Parametros[2] = ConversorACFiscal.DataParaString(DataGeracao);
			Parametros[3] = ConversorACFiscal.IntParaString(Empresa,4);
			Parametros[4] = DataInicialLancamentos;
			Parametros[5] = DataFinalLancamentos;
			Parametros[6] = Comentario;
			Parametros[7] = ConversorACFiscal.BoolParaString(AliquotasEspecificas);
			
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exception", e);
		}
	}
	
	
}
