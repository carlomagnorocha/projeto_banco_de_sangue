package br.com.api.bancoDeSangue.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CandidatosPorEstado
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T19:45:18.181Z[GMT]")


public class CandidatosPorEstado   {
  @JsonProperty("estado")
  private String estado = null;

  @JsonProperty("candidatos")
  private Integer candidatos = null;

  public CandidatosPorEstado estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
   **/
  @Schema(description = "")
  
    public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public CandidatosPorEstado candidatos(Integer candidatos) {
    this.candidatos = candidatos;
    return this;
  }

  /**
   * Get candidatos
   * @return candidatos
   **/
  @Schema(description = "")
  
    public Integer getCandidatos() {
    return candidatos;
  }

  public void setCandidatos(Integer candidatos) {
    this.candidatos = candidatos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CandidatosPorEstado candidatosPorEstado = (CandidatosPorEstado) o;
    return Objects.equals(this.estado, candidatosPorEstado.estado) &&
        Objects.equals(this.candidatos, candidatosPorEstado.candidatos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(estado, candidatos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidatosPorEstado {\n");
    
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    candidatos: ").append(toIndentedString(candidatos)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
