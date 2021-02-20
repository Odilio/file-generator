package file.generator.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

public class Contagem {
	public Connection conn;
	File file; 
	int cont = 0;
	double total = 0.0;
public void transfere(){
	StringBuilder texto = new StringBuilder();
	try {
		Class.forName("org.postgresql.Driver");
		 conn = DriverManager.getConnection("jdbc:postgresql://192.168.30.3/vessel?user=gessy&password=gessy121200");
		Statement stm = conn.createStatement();
		Statement stmt = conn.createStatement();
		ResultSet rs = stm.executeQuery(" SELECT    codigo, iddeposito,  quantidade,  endereco,  valormedio,  estoqueminimo,  estoquemaximo,"
				+ "  quantidaderessuprimento,  nf,  nr FROM  public.mercadoriadeposito inner join mercadoria on mercadoria.idmercadoria=mercadoriadeposito.idmercadoria"
				+ " where iddeposito = 34  ");
		while (rs.next()) {
			
			String codigo = rs.getString("codigo");
			Double valor = rs.getDouble("valormedio");
			int quantidade = rs.getInt("quantidade");
			//System.out.println("entrada " + quantidade);
			ResultSet re = stmt.executeQuery(" select mercadoria.codigo,   sum( case tipopedido.nome   when 'Venda' then item.quantidade"
					+ "  when 'Compra' then item.quantidade * -1"
					+ "  when 'TransferenciaSaida' then item.quantidade"
					+ "  when 'TransferenciaEntrada' then item.quantidade * -1"
					+ "  end  ) as quantidadeSoma "
					+ " from pedido inner join empresa on empresa.idempresa=pedido.idempresa inner join"
					+ " tipopedido on tipopedido.idtipopedido=pedido.idtipopedido inner join item on item.idempresa=pedido.idempresa"
					+ " and item.idpedido=pedido.idpedido inner join mercadoria on mercadoria.idmercadoria=item.idtipoitem"
					+ " where pedido.datapedido between '2014-02-06 00:00:00' and '2014-02-11 23:59:59' and pedido.estado in ('confirmado', 'fechado')"
					+ " and tipopedido.nome in ('Venda', 'TransferenciaSaida', 'TransferenciaEntrada','Compra') and pedido.idempresa = 16"
					+ " and mercadoria.codigo like '" + codigo + "' group by mercadoria.codigo");
			if (re.next()){
				
				int quantMercadoria = re.getInt("quantidadeSoma");
			 // System.out.println(quantMercadoria +" saida");
				quantidade += quantMercadoria; 
				if (quantidade>0)
					texto.append( codigo + " ; " + quantidade + "\n");
					//System.out.println("quantidade impressa do item " + codigo + " é  " + quantidade  );
				total = total + (quantidade * valor);
			}else
			{
				if (quantidade>0)
				texto.append(codigo + " ; " + quantidade +  "\n");
				cont++;
				 total = total + (quantidade * valor);
			}
		}
		try {
			System.out.println("contador " + cont);
			file = new File("Contagem.txt");
			System.out.println("valor total "+ total);
	
		FileUtils.writeStringToFile(file, texto.toString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}  
}
	public static void main(String[] args) {
		Contagem a = new Contagem();
		a.transfere();

	}

}
