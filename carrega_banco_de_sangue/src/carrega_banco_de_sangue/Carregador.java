package carrega_banco_de_sangue;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Carregador {

	public static void main(String[] args) throws Exception{
		ConnectionPostgreSql connPostgre = new ConnectionPostgreSql();
		connPostgre.connect();
		
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("data.json"));
		Item[] itens = gson.fromJson(reader, Item[].class);
		List<Item> itemList = Arrays.asList(itens);
		
		int count = 1;
		
		for(Item item:itemList) {
			////////////pessoa///////////////////////
			String sqlInsertPessoa =  "insert into public.pessoa (id, data_nasc, pai, rg, sexo, cpf, mae, nome) "
							  + "values ("+count+",'"+item.getData_nasc()+"','"+item.getPai()+"','"+item.getRg()+"','"+item.getSexo()+"','"+item.getCpf()+"','"+item.getMae()+"','"+item.getNome()+"')";
			int resultPessoa = connPostgre.getConn().prepareStatement(sqlInsertPessoa).executeUpdate();
			////////////pessoa///////////////////////
			
			////////////endereco///////////////////////
			String sqlInsertEndereco =  "insert into public.endereco (cep, endereco, numero, bairro, cidade, estado, pessoa_id) "
					  + "values ('"+item.getCep()+"','"+item.getEndereco()+"','"+item.getNumero()+"','"+item.getBairro()+"','"+item.getCidade()+"','"+item.getEstado()+"',"+count+")";
			int resultEndereco = connPostgre.getConn().prepareStatement(sqlInsertEndereco).executeUpdate();
			////////////endereco///////////////////////
			
			////////////contato///////////////////////
			String sqlInsertContato =  "insert into public.contato (tipo_contato_id, valor, pessoa_id) "
					  + "values ("+1+",'"+item.getTelefone_fixo()+"',"+count+")";
			int resultContato = connPostgre.getConn().prepareStatement(sqlInsertContato).executeUpdate();
			sqlInsertContato =  "insert into public.contato (tipo_contato_id, valor, pessoa_id) "
					  + "values ("+2+",'"+item.getCelular()+"',"+count+")";
			resultContato = connPostgre.getConn().prepareStatement(sqlInsertContato).executeUpdate();
			sqlInsertContato =  "insert into public.contato (tipo_contato_id, valor, pessoa_id) "
					  + "values ("+3+",'"+item.getEmail()+"',"+count+")";
			resultContato = connPostgre.getConn().prepareStatement(sqlInsertContato).executeUpdate();
			////////////contato///////////////////////
			
			////////////dados clinicos///////////////////////
			String sqlInsertDadosClinicos =  "insert into public.dados_clinicos (altura, peso, tipo_sanguineo, pessoa_id) "
					  + "values ("+item.getAltura()+","+item.getPeso()+",'"+item.getTipo_sanguineo()+"',"+count+")";
			int resultDadosClinicos = connPostgre.getConn().prepareStatement(sqlInsertDadosClinicos).executeUpdate();
			////////////dados clinicos///////////////////////
			
			count++;
		}
	}

}
