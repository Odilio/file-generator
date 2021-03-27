package file.generator.registro;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import file.generator.util.ConversorACFiscal;

public class Registro2 extends ATipoRegistro {

	public int VersaoLeiaute; // Tamanho 2 - N
	public String SistemaOrigem; // Tamanho 62 - C
	public String DataGeracao; // Tamanho 8 - D
	public String Empresa; // Tamanho 15 - C
	
	
	public Registro2() {
		TipoRegistro = ETipoRegistro.CAB;
	}

	@Override
	public void MontarParametros() {
		try {
			Parametros = new ArrayList<String>();
			
			Parametros.add(ConversorACFiscal.IntParaString(VersaoLeiaute, 2));
			Parametros.add(SistemaOrigem);
			Parametros.add(DataGeracao);
			Parametros.add(ConversorACFiscal.StringParaString(Empresa,10));
			
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exception", e);
		}
	}
	
	
}
