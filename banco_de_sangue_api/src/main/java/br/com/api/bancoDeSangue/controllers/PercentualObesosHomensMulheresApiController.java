package br.com.api.bancoDeSangue.controllers;

import br.com.api.bancoDeSangue.enums.RespostaCodigo;
import br.com.api.bancoDeSangue.responses.Response;
import br.com.api.bancoDeSangue.services.PercentualObesosHomensMulheresService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T20:16:55.024Z[GMT]")
@RestController
@CrossOrigin
public class PercentualObesosHomensMulheresApiController implements PercentualObesosHomensMulheresApi {

    private static final Logger log = LoggerFactory.getLogger(PercentualObesosHomensMulheresApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PercentualObesosHomensMulheresApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Response> getPercentualObesosHomensMulheres() {
    	String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
        	Response response = new Response();
        	Gson gson = new Gson();
            try {
            	PercentualObesosHomensMulheresService percentualObesosHomensMulheresService = new PercentualObesosHomensMulheresService();
            	response = percentualObesosHomensMulheresService.getPercentualObesosHomensMulheres();

            	return new ResponseEntity<Response>(objectMapper.readValue(gson.toJson(response), Response.class), HttpStatus.valueOf(response.getCode())); 
            } catch (Exception e) {
            	StringWriter sw = new StringWriter();
    			PrintWriter pw = new PrintWriter(sw);
    			e.printStackTrace(pw);
    			String ex = sw.toString();
    			
    			String msgError = "";
    			response.setCode(RespostaCodigo.CODE_ERROR.getValue());
    			
    			if(e.getMessage() != null) {
    				msgError = e.getMessage();
    				response.setMensage(e.getMessage().split(":")[0]);
    			}
    			if(e.getCause() != null) {
    				msgError = msgError + e.getCause();
    			}
    			
    			e.printStackTrace();
    		
				try {
					return new ResponseEntity<Response>(objectMapper.readValue(gson.toJson(response), Response.class), HttpStatus.valueOf(response.getCode()));
				} catch (JsonParseException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        }

        return new ResponseEntity<Response>(HttpStatus.NOT_IMPLEMENTED);
    }

}
