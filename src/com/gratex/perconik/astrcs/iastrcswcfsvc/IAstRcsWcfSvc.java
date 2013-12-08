
package com.gratex.perconik.astrcs.iastrcswcfsvc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IAstRcsWcfSvc", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
@XmlSeeAlso({
    com.gratex.perconik.astrcs.ientityservice.ObjectFactory.class,
    com.microsoft.schemas._2003._10.serialization.ObjectFactory.class,
    com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class,
    org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.ObjectFactory.class
})
public interface IAstRcsWcfSvc {


    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse
     */
    @WebMethod(operationName = "GetCodeEntity", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetCodeEntity")
    @WebResult(name = "GetCodeEntityResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetCodeEntity", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntity")
    @ResponseWrapper(localName = "GetCodeEntityResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse")
    public GetCodeEntityResponse getCodeEntity(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetCodeEntityRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse
     */
    @WebMethod(operationName = "SearchFiles", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchFiles")
    @WebResult(name = "SearchFilesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchFiles", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchFiles")
    @ResponseWrapper(localName = "SearchFilesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse")
    public SearchFilesResponse searchFiles(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchFilesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse
     */
    @WebMethod(operationName = "GetFile", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetFile")
    @WebResult(name = "GetFileResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetFile", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFile")
    @ResponseWrapper(localName = "GetFileResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFileResponse")
    public GetFileResponse getFile(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetFileRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse
     */
    @WebMethod(operationName = "GetFilesByTfsIdentifiers", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetFilesByTfsIdentifiers")
    @WebResult(name = "GetFilesByTfsIdentifiersResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetFilesByTfsIdentifiers", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiers")
    @ResponseWrapper(localName = "GetFilesByTfsIdentifiersResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse")
    public GetFilesByTfsIdentifiersResponse getFilesByTfsIdentifiers(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetFilesByTfsIdentifiersRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse
     */
    @WebMethod(operationName = "GetFilesByGitIdentifiers", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetFilesByGitIdentifiers")
    @WebResult(name = "GetFilesByGitIdentifiersResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetFilesByGitIdentifiers", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiers")
    @ResponseWrapper(localName = "GetFilesByGitIdentifiersResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse")
    public GetFilesByGitIdentifiersResponse getFilesByGitIdentifiers(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetFilesByGitIdentifiersRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse
     */
    @WebMethod(operationName = "GetChildCodeEntities", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetChildCodeEntities")
    @WebResult(name = "GetChildCodeEntitiesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetChildCodeEntities", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntities")
    @ResponseWrapper(localName = "GetChildCodeEntitiesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse")
    public GetChildCodeEntitiesResponse getChildCodeEntities(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetChildCodeEntitiesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse
     */
    @WebMethod(operationName = "GetCodeEntityContent", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetCodeEntityContent")
    @WebResult(name = "GetCodeEntityContentResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetCodeEntityContent", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContent")
    @ResponseWrapper(localName = "GetCodeEntityContentResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse")
    public GetCodeEntityContentResponse getCodeEntityContent(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetCodeEntityContentRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse
     */
    @WebMethod(operationName = "GetFileContent", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetFileContent")
    @WebResult(name = "GetFileContentResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetFileContent", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFileContent")
    @ResponseWrapper(localName = "GetFileContentResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse")
    public GetFileContentResponse getFileContent(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetFileContentRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse
     */
    @WebMethod(operationName = "SearchCodeEntities", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchCodeEntities")
    @WebResult(name = "SearchCodeEntitiesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchCodeEntities", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchCodeEntities")
    @ResponseWrapper(localName = "SearchCodeEntitiesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse")
    public SearchCodeEntitiesResponse searchCodeEntities(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchCodeEntitiesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse
     */
    @WebMethod(operationName = "SearchFolders", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchFolders")
    @WebResult(name = "SearchFoldersResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchFolders", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchFolders")
    @ResponseWrapper(localName = "SearchFoldersResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse")
    public SearchFoldersResponse searchFolders(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchFoldersRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse
     */
    @WebMethod(operationName = "GetRcsServer", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetRcsServer")
    @WebResult(name = "GetRcsServerResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetRcsServer", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetRcsServer")
    @ResponseWrapper(localName = "GetRcsServerResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse")
    public GetRcsServerResponse getRcsServer(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetRcsServerRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse
     */
    @WebMethod(operationName = "SearchRcsServers", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchRcsServers")
    @WebResult(name = "SearchRcsServersResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchRcsServers", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchRcsServers")
    @ResponseWrapper(localName = "SearchRcsServersResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse")
    public SearchRcsServersResponse searchRcsServers(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchRcsServersRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse
     */
    @WebMethod(operationName = "GetRcsProject", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetRcsProject")
    @WebResult(name = "GetRcsProjectResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetRcsProject", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetRcsProject")
    @ResponseWrapper(localName = "GetRcsProjectResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse")
    public GetRcsProjectResponse getRcsProject(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetRcsProjectRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse
     */
    @WebMethod(operationName = "SearchRcsProjects", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchRcsProjects")
    @WebResult(name = "SearchRcsProjectsResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchRcsProjects", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchRcsProjects")
    @ResponseWrapper(localName = "SearchRcsProjectsResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse")
    public SearchRcsProjectsResponse searchRcsProjects(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchRcsProjectsRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse
     */
    @WebMethod(operationName = "GetBranch", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetBranch")
    @WebResult(name = "GetBranchResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetBranch", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranch")
    @ResponseWrapper(localName = "GetBranchResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranchResponse")
    public GetBranchResponse getBranch(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetBranchRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse
     */
    @WebMethod(operationName = "SearchBranches", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchBranches")
    @WebResult(name = "SearchBranchesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchBranches", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchBranches")
    @ResponseWrapper(localName = "SearchBranchesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse")
    public SearchBranchesResponse searchBranches(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchBranchesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse
     */
    @WebMethod(operationName = "GetChangeset", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetChangeset")
    @WebResult(name = "GetChangesetResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetChangeset", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangeset")
    @ResponseWrapper(localName = "GetChangesetResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse")
    public GetChangesetResponse getChangeset(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetChangesetRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse
     */
    @WebMethod(operationName = "SearchChangesets", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchChangesets")
    @WebResult(name = "SearchChangesetsResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchChangesets", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchChangesets")
    @ResponseWrapper(localName = "SearchChangesetsResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse")
    public SearchChangesetsResponse searchChangesets(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchChangesetsRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse
     */
    @WebMethod(operationName = "QueueChangesetForImport", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/QueueChangesetForImport")
    @WebResult(name = "QueueChangesetForImportResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "QueueChangesetForImport", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImport")
    @ResponseWrapper(localName = "QueueChangesetForImportResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse")
    public QueueChangesetForImportResponse queueChangesetForImport(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        QueueChangesetForImportRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse
     */
    @WebMethod(operationName = "AssociateChangesetWithBranch", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/AssociateChangesetWithBranch")
    @WebResult(name = "AssociateChangesetWithBranchResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "AssociateChangesetWithBranch", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranch")
    @ResponseWrapper(localName = "AssociateChangesetWithBranchResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse")
    public AssociateChangesetWithBranchResponse associateChangesetWithBranch(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        AssociateChangesetWithBranchRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse
     */
    @WebMethod(operationName = "EnsureBranches", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/EnsureBranches")
    @WebResult(name = "EnsureBranchesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "EnsureBranches", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureBranches")
    @ResponseWrapper(localName = "EnsureBranchesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse")
    public EnsureBranchesResponse ensureBranches(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        EnsureBranchesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse
     */
    @WebMethod(operationName = "EnsureRcsProject", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/EnsureRcsProject")
    @WebResult(name = "EnsureRcsProjectResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "EnsureRcsProject", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureRcsProject")
    @ResponseWrapper(localName = "EnsureRcsProjectResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse")
    public EnsureRcsProjectResponse ensureRcsProject(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        EnsureRcsProjectRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse
     */
    @WebMethod(operationName = "EnsureRcsServer", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/EnsureRcsServer")
    @WebResult(name = "EnsureRcsServerResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "EnsureRcsServer", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureRcsServer")
    @ResponseWrapper(localName = "EnsureRcsServerResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse")
    public EnsureRcsServerResponse ensureRcsServer(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        EnsureRcsServerRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse
     */
    @WebMethod(operationName = "GetImportCapabilities", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetImportCapabilities")
    @WebResult(name = "GetImportCapabilitiesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetImportCapabilities", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetImportCapabilities")
    @ResponseWrapper(localName = "GetImportCapabilitiesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse")
    public GetImportCapabilitiesResponse getImportCapabilities(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetImportCapabilitiesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse
     */
    @WebMethod(operationName = "IsChangesetQueuedOrImported", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/IsChangesetQueuedOrImported")
    @WebResult(name = "IsChangesetQueuedOrImportedResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "IsChangesetQueuedOrImported", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImported")
    @ResponseWrapper(localName = "IsChangesetQueuedOrImportedResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse")
    public IsChangesetQueuedOrImportedResponse isChangesetQueuedOrImported(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        IsChangesetQueuedOrImportedRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse
     */
    @WebMethod(operationName = "GetUser", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetUser")
    @WebResult(name = "GetUserResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetUser", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetUser")
    @ResponseWrapper(localName = "GetUserResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetUserResponse")
    public GetUserResponse getUser(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetUserRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse
     */
    @WebMethod(operationName = "SearchUsers", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/SearchUsers")
    @WebResult(name = "SearchUsersResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "SearchUsers", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchUsers")
    @ResponseWrapper(localName = "SearchUsersResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse")
    public SearchUsersResponse searchUsers(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        SearchUsersRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse
     */
    @WebMethod(operationName = "GetBranchQueuedHead", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetBranchQueuedHead")
    @WebResult(name = "GetBranchQueuedHeadResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetBranchQueuedHead", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHead")
    @ResponseWrapper(localName = "GetBranchQueuedHeadResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse")
    public GetBranchQueuedHeadResponse getBranchQueuedHead(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetBranchQueuedHeadRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse
     */
    @WebMethod(operationName = "GetBranchImportedHead", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetBranchImportedHead")
    @WebResult(name = "GetBranchImportedHeadResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetBranchImportedHead", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHead")
    @ResponseWrapper(localName = "GetBranchImportedHeadResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse")
    public GetBranchImportedHeadResponse getBranchImportedHead(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetBranchImportedHeadRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse
     */
    @WebMethod(operationName = "GetChangedFiles", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetChangedFiles")
    @WebResult(name = "GetChangedFilesResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetChangedFiles", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangedFiles")
    @ResponseWrapper(localName = "GetChangedFilesResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse")
    public GetChangedFilesResponse getChangedFiles(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetChangedFilesRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse
     */
    @WebMethod(operationName = "GetFileChangesets", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetFileChangesets")
    @WebResult(name = "GetFileChangesetsResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetFileChangesets", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFileChangesets")
    @ResponseWrapper(localName = "GetFileChangesetsResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse")
    public GetFileChangesetsResponse getFileChangesets(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetFileChangesetsRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse
     */
    @WebMethod(operationName = "GetCodeEntityChangesets", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetCodeEntityChangesets")
    @WebResult(name = "GetCodeEntityChangesetsResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetCodeEntityChangesets", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesets")
    @ResponseWrapper(localName = "GetCodeEntityChangesetsResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse")
    public GetCodeEntityChangesetsResponse getCodeEntityChangesets(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetCodeEntityChangesetsRequest request);

    /**
     * 
     * @param request
     * @return
     *     returns org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse
     */
    @WebMethod(operationName = "GetChangesetRcsProject", action = "http://www.gratex.com/PerConIk/AstRcs/IEntityService/IAstRcsWcfSvc/GetChangesetRcsProject")
    @WebResult(name = "GetChangesetRcsProjectResult", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
    @RequestWrapper(localName = "GetChangesetRcsProject", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProject")
    @ResponseWrapper(localName = "GetChangesetRcsProjectResponse", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", className = "com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse")
    public GetChangesetRcsProjectResponse getChangesetRcsProject(
        @WebParam(name = "request", targetNamespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService")
        GetChangesetRcsProjectRequest request);

}
