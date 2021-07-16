package br.com.api.bancoDeSangue.responses;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T20:03:04.165Z[GMT]")


public class Response   {
  @JsonProperty("data")
  private Data data = null;

  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("mensage")
  private String mensage = null;

  public Response data(Data data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @Schema(description = "")
  
    @Valid
    public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public Response code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(description = "")
  
    public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Response mensage(String mensage) {
    this.mensage = mensage;
    return this;
  }

  /**
   * Get mensage
   * @return mensage
   **/
  @Schema(description = "")
  
    public String getMensage() {
    return mensage;
  }

  public void setMensage(String mensage) {
    this.mensage = mensage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.data, response.data) &&
        Objects.equals(this.code, response.code) &&
        Objects.equals(this.mensage, response.mensage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, code, mensage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    mensage: ").append(toIndentedString(mensage)).append("\n");
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
