package br.com.api.bancoDeSangue.services;

import br.com.api.bancoDeSangue.repositories.ImcMedioPorFaixaDeIdadeRepository;
import br.com.api.bancoDeSangue.responses.Response;

public class ImcMedioPorFaixaDeIdadeService {
	private ImcMedioPorFaixaDeIdadeRepository imcMedioPorFaixaDeIdadeRepository;
	
	
	public ImcMedioPorFaixaDeIdadeService(){}
	
	
	
	public Response getImcMedioPorFaixaDeIdade(Integer faixaInicial, Integer faixaFinal) throws Exception {
		Response resposta = new Response();
		
		imcMedioPorFaixaDeIdadeRepository = new ImcMedioPorFaixaDeIdadeRepository();
		resposta = imcMedioPorFaixaDeIdadeRepository.getImcMedioPorFaixaDeIdade(faixaInicial, faixaFinal);
		
		return resposta;
	}
}
