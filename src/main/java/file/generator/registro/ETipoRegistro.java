package file.generator.registro;

public enum ETipoRegistro {

	CAB("CAB"), // Cabecalho
	PAR("PAR"), // Participantes dos documentos fiscais
	GRP("GRP"), // Grupo de produtos
	UND("UND"), // Unidade de medida
	NOP("NOP"), // Natureza da Operacao das Notas Fiscais Eletronicas (Saidas e Entradas Documento Proprio)
	CDF("CDF"), // Informacao Complementar
	PRO("PRO"), // Produtos
	OUM("OUM"), // Outras Unidades de Medida
	ESI("ESI"), // Entradas(Servicos ISS)
	IES("IES"), // ISS
	OVE("OVE"), // Outros Valores do Documento
	DSS("DSS"), // Saidas - Servicos (ISS)
	ITS("ITS"), // ISS
	OVD("OVD"), // Outros Valores do Documento
	NFM("NFM"), // Notas Fiscais de Mercadoria
	PNM("PNM"), // Produtos
	INM("INM"), // ICMS & IPI
	CFC("CFC"), // Cupons Fiscais
	CCF("CCF"), // Cupons
	PCC("PCC"), // Produtos
	ICF("ICF"), // ICMS
	TRA("TRA"), // Trailler
	PCF("PCF"), // Outros Valores Documento
	OVF("OVF"); // Outros Valores Documento
	
	
	private String valor;
	
	ETipoRegistro(String valor_)
	{
		valor = valor_;
	}

	/**
	 * Retorna o valor da enumeração.
	 * @return
	 */
	public String getValor()
	{
		return valor;
	}
}
