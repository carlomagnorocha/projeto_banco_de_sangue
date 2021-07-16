package br.com.api.bancoDeSangue.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PercentualObesosHomensMulheres
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T19:45:18.181Z[GMT]")


public class PercentualObesosHomensMulheres   {
  @JsonProperty("sexo")
  private String sexo = null;

  @JsonProperty("percentualObesidade")
  private Long percentualObesidade = null;

  public PercentualObesosHomensMulheres sexo(String sexo) {
    this.sexo = sexo;
    return this;
  }

  /**
   * Get sexo
   * @return sexo
   **/
  @Schema(description = "")
  
    public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public PercentualObesosHomensMulheres percentualObesidade(Long percentualObesidade) {
    this.percentualObesidade = percentualObesidade;
    return this;
  }

  /**
   * Get percentualObesidade
   * @return percentualObesidade
   **/
  @Schema(description = "")
  
    public Long getPercentualObesidade() {
    return percentualObesidade;
  }

  public void setPercentualObesidade(Long percentualObesidade) {
    this.percentualObesidade = percentualObesidade;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PercentualObesosHomensMulheres percentualObesosHomensMulheres = (PercentualObesosHomensMulheres) o;
    return Objects.equals(this.sexo, percentualObesosHomensMulheres.sexo) &&
        Objects.equals(this.percentualObesidade, percentualObesosHomensMulheres.percentualObesidade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sexo, percentualObesidade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PercentualObesosHomensMulheres {\n");
    
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    percentualObesidade: ").append(toIndentedString(percentualObesidade)).append("\n");
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
