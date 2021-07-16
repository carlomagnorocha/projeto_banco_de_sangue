package br.com.api.bancoDeSangue.services;

import br.com.api.bancoDeSangue.repositories.PercentualObesosHomensMulheresRepository;
import br.com.api.bancoDeSangue.responses.Response;

public class PercentualObesosHomensMulheresService {
	private PercentualObesosHomensMulheresRepository percentualObesosHomensMulheresRepository;
	
	
	public PercentualObesosHomensMulheresService(){}
	
	
	public Response getPercentualObesosHomensMulheres() throws Exception {
		Response resposta = new Response();
		
		percentualObesosHomensMulheresRepository = new PercentualObesosHomensMulheresRepository();
		resposta = percentualObesosHomensMulheresRepository.getPercentualObesosHomensMulheres();
		
		return resposta;
	}
}
