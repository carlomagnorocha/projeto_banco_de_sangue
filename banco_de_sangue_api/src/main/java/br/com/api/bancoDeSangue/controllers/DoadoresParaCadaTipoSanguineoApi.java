/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package br.com.api.bancoDeSangue.controllers;

import br.com.api.bancoDeSangue.responses.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T20:16:55.024Z[GMT]")
@Validated
public interface DoadoresParaCadaTipoSanguineoApi {

    @Operation(summary = "retorna a quantidade de doadores para cada tipo sanguineo receptor", description = "retorna a quantidade de doadores para cada tipo sanguineo receptor ", tags={ "doadoresParaCadaTipoSanguineo" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "resultados retornados com sucesso", content = @Content(schema = @Schema(implementation = Response.class))),
        
        @ApiResponse(responseCode = "400", description = "erro de parametro") })
    @RequestMapping(value = "/doadoresParaCadaTipoSanguineo",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Response> getDoadoresParaCadaTipoSanguineo();

}

