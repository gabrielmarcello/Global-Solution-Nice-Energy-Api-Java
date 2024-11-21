package resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import beans.Cliente;
import bo.ClienteBO;
import br.com.fiap.beans.Solicitacao;
import br.com.fiap.bo.SolicitacaoBO;

@Path("solicitacao")
public class SolicitacaoResource {
	
	private SolicitacaoBO solicitacaoBO = new SolicitacaoBO();

	
	//inserir (POST)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Solicitacao solicitacao, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		solicitacaoBO.
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); //recebe a informação do front (página)
		builder.path(Integer.toString(solicitacao.getId())); //identifica o id do campo (String)
		return Response.created(builder.build()).build(); //composição -> caminho (carrregar o que foi carregado) - http -> 200
	}
	
	//atualizar (PUT)
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Solicitacao solicitacao, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		solicitacaoBO.atualizarBO(solicitacao, id);
		return Response.ok().build();
	}
	
	
	//deletar (DELETE)
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		solicitacaoBO.deletarBO(id);
		return Response.ok().build();
	}
	
	
	//consultar (GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Solicitacao> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<Solicitacao>) solicitacaoBO.listarBO();
	}

}
