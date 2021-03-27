package file.generator.registro;

import java.util.List;

public abstract class ATipoRegistro {
	//--------------------------------------------------------------------------------
	// Constantes
	//--------------------------------------------------------------------------------
	public final String SEPARADOR = ";";
	
	//--------------------------------------------------------------------------------
	// Variáveis
	//--------------------------------------------------------------------------------
	/**
	 * Tipo do registro.
	 */
	protected ETipoRegistro TipoRegistro;
	/**
	 * Parâmetros que serão impressos.
	 */
	protected List<String> Parametros;

	//--------------------------------------------------------------------------------
	// Metodos
	//--------------------------------------------------------------------------------
	/**
	 * 
	 */
	@Override
	public String toString() {
		MontarParametros();
		
		if (Parametros != null)
		{
			String retorno = TipoRegistro.getValor();
			
			for (String par : Parametros) {
				retorno += SEPARADOR + par;
			}
			
			return retorno;
		}
		
		return null;
	}
	
	public abstract void MontarParametros();
}
