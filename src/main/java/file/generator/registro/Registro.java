package file.generator.registro;

import java.util.ArrayList;
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
			Parametros = new ArrayList<String>();
			
			Parametros.add(ConversorACFiscal.IntParaString(VersaoLeiaute, 2));
			Parametros.add(SistemaOrigem);
			Parametros.add(ConversorACFiscal.DataParaString(DataGeracao));
			Parametros.add(ConversorACFiscal.IntParaString(Empresa,4));
			Parametros.add(DataInicialLancamentos);
			Parametros.add(DataFinalLancamentos);
			Parametros.add(Comentario);
			Parametros.add(ConversorACFiscal.BoolParaString(AliquotasEspecificas));
			
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exception", e);
		}
	}
	
	
}
