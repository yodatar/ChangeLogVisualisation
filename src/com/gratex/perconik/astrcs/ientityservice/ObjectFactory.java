
package com.gratex.perconik.astrcs.ientityservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersRequest;
import org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gratex.perconik.astrcs.ientityservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUserRequest_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "request");
    private final static QName _GetRcsServerResponseGetRcsServerResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetRcsServerResult");
    private final static QName _GetUserResponseGetUserResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetUserResult");
    private final static QName _GetFilesByGitIdentifiersResponseGetFilesByGitIdentifiersResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetFilesByGitIdentifiersResult");
    private final static QName _GetFileContentResponseGetFileContentResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetFileContentResult");
    private final static QName _EnsureBranchesResponseEnsureBranchesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "EnsureBranchesResult");
    private final static QName _GetCodeEntityChangesetsResponseGetCodeEntityChangesetsResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetCodeEntityChangesetsResult");
    private final static QName _GetChangedFilesResponseGetChangedFilesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetChangedFilesResult");
    private final static QName _SearchRcsProjectsResponseSearchRcsProjectsResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchRcsProjectsResult");
    private final static QName _SearchBranchesResponseSearchBranchesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchBranchesResult");
    private final static QName _EnsureRcsProjectResponseEnsureRcsProjectResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "EnsureRcsProjectResult");
    private final static QName _SearchCodeEntitiesResponseSearchCodeEntitiesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchCodeEntitiesResult");
    private final static QName _GetRcsProjectResponseGetRcsProjectResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetRcsProjectResult");
    private final static QName _GetChangesetResponseGetChangesetResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetChangesetResult");
    private final static QName _IsChangesetQueuedOrImportedResponseIsChangesetQueuedOrImportedResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "IsChangesetQueuedOrImportedResult");
    private final static QName _SearchFilesResponseSearchFilesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchFilesResult");
    private final static QName _SearchRcsServersResponseSearchRcsServersResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchRcsServersResult");
    private final static QName _GetBranchQueuedHeadResponseGetBranchQueuedHeadResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetBranchQueuedHeadResult");
    private final static QName _GetChildCodeEntitiesResponseGetChildCodeEntitiesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetChildCodeEntitiesResult");
    private final static QName _GetBranchResponseGetBranchResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetBranchResult");
    private final static QName _AssociateChangesetWithBranchResponseAssociateChangesetWithBranchResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "AssociateChangesetWithBranchResult");
    private final static QName _GetCodeEntityContentResponseGetCodeEntityContentResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetCodeEntityContentResult");
    private final static QName _SearchFoldersResponseSearchFoldersResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchFoldersResult");
    private final static QName _GetCodeEntityResponseGetCodeEntityResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetCodeEntityResult");
    private final static QName _GetImportCapabilitiesResponseGetImportCapabilitiesResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetImportCapabilitiesResult");
    private final static QName _SearchChangesetsResponseSearchChangesetsResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchChangesetsResult");
    private final static QName _GetBranchImportedHeadResponseGetBranchImportedHeadResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetBranchImportedHeadResult");
    private final static QName _SearchUsersResponseSearchUsersResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "SearchUsersResult");
    private final static QName _GetFileChangesetsResponseGetFileChangesetsResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetFileChangesetsResult");
    private final static QName _GetChangesetRcsProjectResponseGetChangesetRcsProjectResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetChangesetRcsProjectResult");
    private final static QName _GetFileResponseGetFileResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetFileResult");
    private final static QName _EnsureRcsServerResponseEnsureRcsServerResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "EnsureRcsServerResult");
    private final static QName _QueueChangesetForImportResponseQueueChangesetForImportResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "QueueChangesetForImportResult");
    private final static QName _GetFilesByTfsIdentifiersResponseGetFilesByTfsIdentifiersResult_QNAME = new QName("http://www.gratex.com/PerConIk/AstRcs/IEntityService", "GetFilesByTfsIdentifiersResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gratex.perconik.astrcs.ientityservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse createGetImportCapabilitiesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse createSearchUsersResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse createSearchRcsServersResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse createAssociateChangesetWithBranchResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse();
    }

    /**
     * Create an instance of {@link QueueChangesetForImport }
     * 
     */
    public QueueChangesetForImport createQueueChangesetForImport() {
        return new QueueChangesetForImport();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetBranchResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetBranchResponse createGetBranchResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetBranchResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse createSearchFoldersResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse createIsChangesetQueuedOrImportedResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse createSearchRcsProjectsResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse();
    }

    /**
     * Create an instance of {@link GetBranchQueuedHead }
     * 
     */
    public GetBranchQueuedHead createGetBranchQueuedHead() {
        return new GetBranchQueuedHead();
    }

    /**
     * Create an instance of {@link GetRcsServer }
     * 
     */
    public GetRcsServer createGetRcsServer() {
        return new GetRcsServer();
    }

    /**
     * Create an instance of {@link SearchRcsServers }
     * 
     */
    public SearchRcsServers createSearchRcsServers() {
        return new SearchRcsServers();
    }

    /**
     * Create an instance of {@link GetCodeEntityChangesets }
     * 
     */
    public GetCodeEntityChangesets createGetCodeEntityChangesets() {
        return new GetCodeEntityChangesets();
    }

    /**
     * Create an instance of {@link SearchChangesets }
     * 
     */
    public SearchChangesets createSearchChangesets() {
        return new SearchChangesets();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse createGetFileChangesetsResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse createGetChangedFilesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse();
    }

    /**
     * Create an instance of {@link GetChildCodeEntities }
     * 
     */
    public GetChildCodeEntities createGetChildCodeEntities() {
        return new GetChildCodeEntities();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse createSearchCodeEntitiesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse();
    }

    /**
     * Create an instance of {@link GetFileChangesets }
     * 
     */
    public GetFileChangesets createGetFileChangesets() {
        return new GetFileChangesets();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse createGetBranchImportedHeadResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse();
    }

    /**
     * Create an instance of {@link GetCodeEntity }
     * 
     */
    public GetCodeEntity createGetCodeEntity() {
        return new GetCodeEntity();
    }

    /**
     * Create an instance of {@link GetImportCapabilities }
     * 
     */
    public GetImportCapabilities createGetImportCapabilities() {
        return new GetImportCapabilities();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse createGetFilesByGitIdentifiersResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse();
    }

    /**
     * Create an instance of {@link SearchRcsProjects }
     * 
     */
    public SearchRcsProjects createSearchRcsProjects() {
        return new SearchRcsProjects();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse createGetChildCodeEntitiesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse createEnsureRcsProjectResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse();
    }

    /**
     * Create an instance of {@link EnsureBranches }
     * 
     */
    public EnsureBranches createEnsureBranches() {
        return new EnsureBranches();
    }

    /**
     * Create an instance of {@link GetFilesByGitIdentifiers }
     * 
     */
    public GetFilesByGitIdentifiers createGetFilesByGitIdentifiers() {
        return new GetFilesByGitIdentifiers();
    }

    /**
     * Create an instance of {@link GetChangedFiles }
     * 
     */
    public GetChangedFiles createGetChangedFiles() {
        return new GetChangedFiles();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse createGetCodeEntityContentResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse createQueueChangesetForImportResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse createGetChangesetRcsProjectResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse();
    }

    /**
     * Create an instance of {@link GetFile }
     * 
     */
    public GetFile createGetFile() {
        return new GetFile();
    }

    /**
     * Create an instance of {@link EnsureRcsProject }
     * 
     */
    public EnsureRcsProject createEnsureRcsProject() {
        return new EnsureRcsProject();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse createEnsureBranchesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse();
    }

    /**
     * Create an instance of {@link GetRcsProject }
     * 
     */
    public GetRcsProject createGetRcsProject() {
        return new GetRcsProject();
    }

    /**
     * Create an instance of {@link GetFilesByTfsIdentifiers }
     * 
     */
    public GetFilesByTfsIdentifiers createGetFilesByTfsIdentifiers() {
        return new GetFilesByTfsIdentifiers();
    }

    /**
     * Create an instance of {@link AssociateChangesetWithBranch }
     * 
     */
    public AssociateChangesetWithBranch createAssociateChangesetWithBranch() {
        return new AssociateChangesetWithBranch();
    }

    /**
     * Create an instance of {@link IsChangesetQueuedOrImported }
     * 
     */
    public IsChangesetQueuedOrImported createIsChangesetQueuedOrImported() {
        return new IsChangesetQueuedOrImported();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse createGetRcsServerResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse createGetFilesByTfsIdentifiersResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse();
    }

    /**
     * Create an instance of {@link SearchBranches }
     * 
     */
    public SearchBranches createSearchBranches() {
        return new SearchBranches();
    }

    /**
     * Create an instance of {@link SearchFolders }
     * 
     */
    public SearchFolders createSearchFolders() {
        return new SearchFolders();
    }

    /**
     * Create an instance of {@link GetChangesetRcsProject }
     * 
     */
    public GetChangesetRcsProject createGetChangesetRcsProject() {
        return new GetChangesetRcsProject();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse createGetCodeEntityResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse createGetFileContentResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse();
    }

    /**
     * Create an instance of {@link SearchCodeEntities }
     * 
     */
    public SearchCodeEntities createSearchCodeEntities() {
        return new SearchCodeEntities();
    }

    /**
     * Create an instance of {@link GetCodeEntityContent }
     * 
     */
    public GetCodeEntityContent createGetCodeEntityContent() {
        return new GetCodeEntityContent();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetUserResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetUserResponse createGetUserResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetUserResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse createEnsureRcsServerResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse();
    }

    /**
     * Create an instance of {@link EnsureRcsServer }
     * 
     */
    public EnsureRcsServer createEnsureRcsServer() {
        return new EnsureRcsServer();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetFileResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetFileResponse createGetFileResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetFileResponse();
    }

    /**
     * Create an instance of {@link SearchUsers }
     * 
     */
    public SearchUsers createSearchUsers() {
        return new SearchUsers();
    }

    /**
     * Create an instance of {@link GetBranch }
     * 
     */
    public GetBranch createGetBranch() {
        return new GetBranch();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse createGetBranchQueuedHeadResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse();
    }

    /**
     * Create an instance of {@link SearchFiles }
     * 
     */
    public SearchFiles createSearchFiles() {
        return new SearchFiles();
    }

    /**
     * Create an instance of {@link GetBranchImportedHead }
     * 
     */
    public GetBranchImportedHead createGetBranchImportedHead() {
        return new GetBranchImportedHead();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse createGetRcsProjectResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse createSearchChangesetsResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse createSearchFilesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse();
    }

    /**
     * Create an instance of {@link GetChangeset }
     * 
     */
    public GetChangeset createGetChangeset() {
        return new GetChangeset();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse createGetChangesetResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse createGetCodeEntityChangesetsResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse();
    }

    /**
     * Create an instance of {@link com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse }
     * 
     */
    public com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse createSearchBranchesResponse() {
        return new com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse();
    }

    /**
     * Create an instance of {@link GetFileContent }
     * 
     */
    public GetFileContent createGetFileContent() {
        return new GetFileContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetUser.class)
    public JAXBElement<GetUserRequest> createGetUserRequest(GetUserRequest value) {
        return new JAXBElement<GetUserRequest>(_GetUserRequest_QNAME, GetUserRequest.class, GetUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilesByGitIdentifiersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetFilesByGitIdentifiers.class)
    public JAXBElement<GetFilesByGitIdentifiersRequest> createGetFilesByGitIdentifiersRequest(GetFilesByGitIdentifiersRequest value) {
        return new JAXBElement<GetFilesByGitIdentifiersRequest>(_GetUserRequest_QNAME, GetFilesByGitIdentifiersRequest.class, GetFilesByGitIdentifiers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetRcsServerResult", scope = com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse> createGetRcsServerResponseGetRcsServerResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse>(_GetRcsServerResponseGetRcsServerResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsServerResponse.class, com.gratex.perconik.astrcs.ientityservice.GetRcsServerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchRcsServersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchRcsServers.class)
    public JAXBElement<SearchRcsServersRequest> createSearchRcsServersRequest(SearchRcsServersRequest value) {
        return new JAXBElement<SearchRcsServersRequest>(_GetUserRequest_QNAME, SearchRcsServersRequest.class, SearchRcsServers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetUserResult", scope = com.gratex.perconik.astrcs.ientityservice.GetUserResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse> createGetUserResponseGetUserResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse>(_GetUserResponseGetUserResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetUserResponse.class, com.gratex.perconik.astrcs.ientityservice.GetUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetFilesByGitIdentifiersResult", scope = com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse> createGetFilesByGitIdentifiersResponseGetFilesByGitIdentifiersResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse>(_GetFilesByGitIdentifiersResponseGetFilesByGitIdentifiersResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByGitIdentifiersResponse.class, com.gratex.perconik.astrcs.ientityservice.GetFilesByGitIdentifiersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRcsProjectRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetRcsProject.class)
    public JAXBElement<GetRcsProjectRequest> createGetRcsProjectRequest(GetRcsProjectRequest value) {
        return new JAXBElement<GetRcsProjectRequest>(_GetUserRequest_QNAME, GetRcsProjectRequest.class, GetRcsProject.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilesByTfsIdentifiersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetFilesByTfsIdentifiers.class)
    public JAXBElement<GetFilesByTfsIdentifiersRequest> createGetFilesByTfsIdentifiersRequest(GetFilesByTfsIdentifiersRequest value) {
        return new JAXBElement<GetFilesByTfsIdentifiersRequest>(_GetUserRequest_QNAME, GetFilesByTfsIdentifiersRequest.class, GetFilesByTfsIdentifiers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImportCapabilitiesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetImportCapabilities.class)
    public JAXBElement<GetImportCapabilitiesRequest> createGetImportCapabilitiesRequest(GetImportCapabilitiesRequest value) {
        return new JAXBElement<GetImportCapabilitiesRequest>(_GetUserRequest_QNAME, GetImportCapabilitiesRequest.class, GetImportCapabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetFileContentResult", scope = com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse> createGetFileContentResponseGetFileContentResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse>(_GetFileContentResponseGetFileContentResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileContentResponse.class, com.gratex.perconik.astrcs.ientityservice.GetFileContentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "EnsureBranchesResult", scope = com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse> createEnsureBranchesResponseEnsureBranchesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse>(_EnsureBranchesResponseEnsureBranchesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureBranchesResponse.class, com.gratex.perconik.astrcs.ientityservice.EnsureBranchesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetCodeEntityChangesetsResult", scope = com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse> createGetCodeEntityChangesetsResponseGetCodeEntityChangesetsResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse>(_GetCodeEntityChangesetsResponseGetCodeEntityChangesetsResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityChangesetsResponse.class, com.gratex.perconik.astrcs.ientityservice.GetCodeEntityChangesetsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsChangesetQueuedOrImportedRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = IsChangesetQueuedOrImported.class)
    public JAXBElement<IsChangesetQueuedOrImportedRequest> createIsChangesetQueuedOrImportedRequest(IsChangesetQueuedOrImportedRequest value) {
        return new JAXBElement<IsChangesetQueuedOrImportedRequest>(_GetUserRequest_QNAME, IsChangesetQueuedOrImportedRequest.class, IsChangesetQueuedOrImported.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChangedFilesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetChangedFiles.class)
    public JAXBElement<GetChangedFilesRequest> createGetChangedFilesRequest(GetChangedFilesRequest value) {
        return new JAXBElement<GetChangedFilesRequest>(_GetUserRequest_QNAME, GetChangedFilesRequest.class, GetChangedFiles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetChangedFilesResult", scope = com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse> createGetChangedFilesResponseGetChangedFilesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse>(_GetChangedFilesResponseGetChangedFilesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangedFilesResponse.class, com.gratex.perconik.astrcs.ientityservice.GetChangedFilesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFoldersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchFolders.class)
    public JAXBElement<SearchFoldersRequest> createSearchFoldersRequest(SearchFoldersRequest value) {
        return new JAXBElement<SearchFoldersRequest>(_GetUserRequest_QNAME, SearchFoldersRequest.class, SearchFolders.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchUsersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchUsers.class)
    public JAXBElement<SearchUsersRequest> createSearchUsersRequest(SearchUsersRequest value) {
        return new JAXBElement<SearchUsersRequest>(_GetUserRequest_QNAME, SearchUsersRequest.class, SearchUsers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchRcsProjectsResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse> createSearchRcsProjectsResponseSearchRcsProjectsResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse>(_SearchRcsProjectsResponseSearchRcsProjectsResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsProjectsResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchRcsProjectsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchBranchesResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse> createSearchBranchesResponseSearchBranchesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse>(_SearchBranchesResponseSearchBranchesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchBranchesResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchBranchesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchChangesetsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchChangesets.class)
    public JAXBElement<SearchChangesetsRequest> createSearchChangesetsRequest(SearchChangesetsRequest value) {
        return new JAXBElement<SearchChangesetsRequest>(_GetUserRequest_QNAME, SearchChangesetsRequest.class, SearchChangesets.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociateChangesetWithBranchRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = AssociateChangesetWithBranch.class)
    public JAXBElement<AssociateChangesetWithBranchRequest> createAssociateChangesetWithBranchRequest(AssociateChangesetWithBranchRequest value) {
        return new JAXBElement<AssociateChangesetWithBranchRequest>(_GetUserRequest_QNAME, AssociateChangesetWithBranchRequest.class, AssociateChangesetWithBranch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueueChangesetForImportRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = QueueChangesetForImport.class)
    public JAXBElement<QueueChangesetForImportRequest> createQueueChangesetForImportRequest(QueueChangesetForImportRequest value) {
        return new JAXBElement<QueueChangesetForImportRequest>(_GetUserRequest_QNAME, QueueChangesetForImportRequest.class, QueueChangesetForImport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCodeEntityRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetCodeEntity.class)
    public JAXBElement<GetCodeEntityRequest> createGetCodeEntityRequest(GetCodeEntityRequest value) {
        return new JAXBElement<GetCodeEntityRequest>(_GetUserRequest_QNAME, GetCodeEntityRequest.class, GetCodeEntity.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "EnsureRcsProjectResult", scope = com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse> createEnsureRcsProjectResponseEnsureRcsProjectResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse>(_EnsureRcsProjectResponseEnsureRcsProjectResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsProjectResponse.class, com.gratex.perconik.astrcs.ientityservice.EnsureRcsProjectResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChildCodeEntitiesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetChildCodeEntities.class)
    public JAXBElement<GetChildCodeEntitiesRequest> createGetChildCodeEntitiesRequest(GetChildCodeEntitiesRequest value) {
        return new JAXBElement<GetChildCodeEntitiesRequest>(_GetUserRequest_QNAME, GetChildCodeEntitiesRequest.class, GetChildCodeEntities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchCodeEntitiesResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse> createSearchCodeEntitiesResponseSearchCodeEntitiesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse>(_SearchCodeEntitiesResponseSearchCodeEntitiesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchCodeEntitiesResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchCodeEntitiesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetRcsProjectResult", scope = com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse> createGetRcsProjectResponseGetRcsProjectResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse>(_GetRcsProjectResponseGetRcsProjectResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetRcsProjectResponse.class, com.gratex.perconik.astrcs.ientityservice.GetRcsProjectResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBranchRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetBranch.class)
    public JAXBElement<GetBranchRequest> createGetBranchRequest(GetBranchRequest value) {
        return new JAXBElement<GetBranchRequest>(_GetUserRequest_QNAME, GetBranchRequest.class, GetBranch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchRcsProjectsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchRcsProjects.class)
    public JAXBElement<SearchRcsProjectsRequest> createSearchRcsProjectsRequest(SearchRcsProjectsRequest value) {
        return new JAXBElement<SearchRcsProjectsRequest>(_GetUserRequest_QNAME, SearchRcsProjectsRequest.class, SearchRcsProjects.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChangesetRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetChangeset.class)
    public JAXBElement<GetChangesetRequest> createGetChangesetRequest(GetChangesetRequest value) {
        return new JAXBElement<GetChangesetRequest>(_GetUserRequest_QNAME, GetChangesetRequest.class, GetChangeset.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCodeEntityChangesetsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetCodeEntityChangesets.class)
    public JAXBElement<GetCodeEntityChangesetsRequest> createGetCodeEntityChangesetsRequest(GetCodeEntityChangesetsRequest value) {
        return new JAXBElement<GetCodeEntityChangesetsRequest>(_GetUserRequest_QNAME, GetCodeEntityChangesetsRequest.class, GetCodeEntityChangesets.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetChangesetResult", scope = com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse> createGetChangesetResponseGetChangesetResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse>(_GetChangesetResponseGetChangesetResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetResponse.class, com.gratex.perconik.astrcs.ientityservice.GetChangesetResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetFile.class)
    public JAXBElement<GetFileRequest> createGetFileRequest(GetFileRequest value) {
        return new JAXBElement<GetFileRequest>(_GetUserRequest_QNAME, GetFileRequest.class, GetFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "IsChangesetQueuedOrImportedResult", scope = com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse> createIsChangesetQueuedOrImportedResponseIsChangesetQueuedOrImportedResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse>(_IsChangesetQueuedOrImportedResponseIsChangesetQueuedOrImportedResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.IsChangesetQueuedOrImportedResponse.class, com.gratex.perconik.astrcs.ientityservice.IsChangesetQueuedOrImportedResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCodeEntitiesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchCodeEntities.class)
    public JAXBElement<SearchCodeEntitiesRequest> createSearchCodeEntitiesRequest(SearchCodeEntitiesRequest value) {
        return new JAXBElement<SearchCodeEntitiesRequest>(_GetUserRequest_QNAME, SearchCodeEntitiesRequest.class, SearchCodeEntities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchFilesResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse> createSearchFilesResponseSearchFilesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse>(_SearchFilesResponseSearchFilesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFilesResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchFilesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchRcsServersResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse> createSearchRcsServersResponseSearchRcsServersResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse>(_SearchRcsServersResponseSearchRcsServersResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchRcsServersResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchRcsServersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetBranchQueuedHeadResult", scope = com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse> createGetBranchQueuedHeadResponseGetBranchQueuedHeadResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse>(_GetBranchQueuedHeadResponseGetBranchQueuedHeadResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchQueuedHeadResponse.class, com.gratex.perconik.astrcs.ientityservice.GetBranchQueuedHeadResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetChildCodeEntitiesResult", scope = com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse> createGetChildCodeEntitiesResponseGetChildCodeEntitiesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse>(_GetChildCodeEntitiesResponseGetChildCodeEntitiesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChildCodeEntitiesResponse.class, com.gratex.perconik.astrcs.ientityservice.GetChildCodeEntitiesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetBranchResult", scope = com.gratex.perconik.astrcs.ientityservice.GetBranchResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse> createGetBranchResponseGetBranchResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse>(_GetBranchResponseGetBranchResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchResponse.class, com.gratex.perconik.astrcs.ientityservice.GetBranchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBranchImportedHeadRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetBranchImportedHead.class)
    public JAXBElement<GetBranchImportedHeadRequest> createGetBranchImportedHeadRequest(GetBranchImportedHeadRequest value) {
        return new JAXBElement<GetBranchImportedHeadRequest>(_GetUserRequest_QNAME, GetBranchImportedHeadRequest.class, GetBranchImportedHead.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "AssociateChangesetWithBranchResult", scope = com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse> createAssociateChangesetWithBranchResponseAssociateChangesetWithBranchResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse>(_AssociateChangesetWithBranchResponseAssociateChangesetWithBranchResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.AssociateChangesetWithBranchResponse.class, com.gratex.perconik.astrcs.ientityservice.AssociateChangesetWithBranchResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetCodeEntityContentResult", scope = com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse> createGetCodeEntityContentResponseGetCodeEntityContentResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse>(_GetCodeEntityContentResponseGetCodeEntityContentResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityContentResponse.class, com.gratex.perconik.astrcs.ientityservice.GetCodeEntityContentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchFoldersResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse> createSearchFoldersResponseSearchFoldersResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse>(_SearchFoldersResponseSearchFoldersResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchFoldersResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchFoldersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChangesetRcsProjectRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetChangesetRcsProject.class)
    public JAXBElement<GetChangesetRcsProjectRequest> createGetChangesetRcsProjectRequest(GetChangesetRcsProjectRequest value) {
        return new JAXBElement<GetChangesetRcsProjectRequest>(_GetUserRequest_QNAME, GetChangesetRcsProjectRequest.class, GetChangesetRcsProject.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetCodeEntityResult", scope = com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse> createGetCodeEntityResponseGetCodeEntityResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse>(_GetCodeEntityResponseGetCodeEntityResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetCodeEntityResponse.class, com.gratex.perconik.astrcs.ientityservice.GetCodeEntityResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetImportCapabilitiesResult", scope = com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse> createGetImportCapabilitiesResponseGetImportCapabilitiesResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse>(_GetImportCapabilitiesResponseGetImportCapabilitiesResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetImportCapabilitiesResponse.class, com.gratex.perconik.astrcs.ientityservice.GetImportCapabilitiesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchChangesetsResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse> createSearchChangesetsResponseSearchChangesetsResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse>(_SearchChangesetsResponseSearchChangesetsResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchChangesetsResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchChangesetsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRcsServerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetRcsServer.class)
    public JAXBElement<GetRcsServerRequest> createGetRcsServerRequest(GetRcsServerRequest value) {
        return new JAXBElement<GetRcsServerRequest>(_GetUserRequest_QNAME, GetRcsServerRequest.class, GetRcsServer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetBranchImportedHeadResult", scope = com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse> createGetBranchImportedHeadResponseGetBranchImportedHeadResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse>(_GetBranchImportedHeadResponseGetBranchImportedHeadResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetBranchImportedHeadResponse.class, com.gratex.perconik.astrcs.ientityservice.GetBranchImportedHeadResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnsureRcsServerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = EnsureRcsServer.class)
    public JAXBElement<EnsureRcsServerRequest> createEnsureRcsServerRequest(EnsureRcsServerRequest value) {
        return new JAXBElement<EnsureRcsServerRequest>(_GetUserRequest_QNAME, EnsureRcsServerRequest.class, EnsureRcsServer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFilesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchFiles.class)
    public JAXBElement<SearchFilesRequest> createSearchFilesRequest(SearchFilesRequest value) {
        return new JAXBElement<SearchFilesRequest>(_GetUserRequest_QNAME, SearchFilesRequest.class, SearchFiles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "SearchUsersResult", scope = com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse> createSearchUsersResponseSearchUsersResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse>(_SearchUsersResponseSearchUsersResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.SearchUsersResponse.class, com.gratex.perconik.astrcs.ientityservice.SearchUsersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCodeEntityContentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetCodeEntityContent.class)
    public JAXBElement<GetCodeEntityContentRequest> createGetCodeEntityContentRequest(GetCodeEntityContentRequest value) {
        return new JAXBElement<GetCodeEntityContentRequest>(_GetUserRequest_QNAME, GetCodeEntityContentRequest.class, GetCodeEntityContent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetFileChangesetsResult", scope = com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse> createGetFileChangesetsResponseGetFileChangesetsResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse>(_GetFileChangesetsResponseGetFileChangesetsResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileChangesetsResponse.class, com.gratex.perconik.astrcs.ientityservice.GetFileChangesetsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetChangesetRcsProjectResult", scope = com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse> createGetChangesetRcsProjectResponseGetChangesetRcsProjectResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse>(_GetChangesetRcsProjectResponseGetChangesetRcsProjectResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetChangesetRcsProjectResponse.class, com.gratex.perconik.astrcs.ientityservice.GetChangesetRcsProjectResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileChangesetsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetFileChangesets.class)
    public JAXBElement<GetFileChangesetsRequest> createGetFileChangesetsRequest(GetFileChangesetsRequest value) {
        return new JAXBElement<GetFileChangesetsRequest>(_GetUserRequest_QNAME, GetFileChangesetsRequest.class, GetFileChangesets.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetFileResult", scope = com.gratex.perconik.astrcs.ientityservice.GetFileResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse> createGetFileResponseGetFileResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse>(_GetFileResponseGetFileResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFileResponse.class, com.gratex.perconik.astrcs.ientityservice.GetFileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "EnsureRcsServerResult", scope = com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse> createEnsureRcsServerResponseEnsureRcsServerResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse>(_EnsureRcsServerResponseEnsureRcsServerResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.EnsureRcsServerResponse.class, com.gratex.perconik.astrcs.ientityservice.EnsureRcsServerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnsureBranchesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = EnsureBranches.class)
    public JAXBElement<EnsureBranchesRequest> createEnsureBranchesRequest(EnsureBranchesRequest value) {
        return new JAXBElement<EnsureBranchesRequest>(_GetUserRequest_QNAME, EnsureBranchesRequest.class, EnsureBranches.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBranchQueuedHeadRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetBranchQueuedHead.class)
    public JAXBElement<GetBranchQueuedHeadRequest> createGetBranchQueuedHeadRequest(GetBranchQueuedHeadRequest value) {
        return new JAXBElement<GetBranchQueuedHeadRequest>(_GetUserRequest_QNAME, GetBranchQueuedHeadRequest.class, GetBranchQueuedHead.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBranchesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = SearchBranches.class)
    public JAXBElement<SearchBranchesRequest> createSearchBranchesRequest(SearchBranchesRequest value) {
        return new JAXBElement<SearchBranchesRequest>(_GetUserRequest_QNAME, SearchBranchesRequest.class, SearchBranches.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "QueueChangesetForImportResult", scope = com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse> createQueueChangesetForImportResponseQueueChangesetForImportResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse>(_QueueChangesetForImportResponseQueueChangesetForImportResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.QueueChangesetForImportResponse.class, com.gratex.perconik.astrcs.ientityservice.QueueChangesetForImportResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnsureRcsProjectRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = EnsureRcsProject.class)
    public JAXBElement<EnsureRcsProjectRequest> createEnsureRcsProjectRequest(EnsureRcsProjectRequest value) {
        return new JAXBElement<EnsureRcsProjectRequest>(_GetUserRequest_QNAME, EnsureRcsProjectRequest.class, EnsureRcsProject.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileContentRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "request", scope = GetFileContent.class)
    public JAXBElement<GetFileContentRequest> createGetFileContentRequest(GetFileContentRequest value) {
        return new JAXBElement<GetFileContentRequest>(_GetUserRequest_QNAME, GetFileContentRequest.class, GetFileContent.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gratex.com/PerConIk/AstRcs/IEntityService", name = "GetFilesByTfsIdentifiersResult", scope = com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse> createGetFilesByTfsIdentifiersResponseGetFilesByTfsIdentifiersResult(org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse>(_GetFilesByTfsIdentifiersResponseGetFilesByTfsIdentifiersResult_QNAME, org.datacontract.schemas._2004._07.gratex_perconik_astrcs_svc.GetFilesByTfsIdentifiersResponse.class, com.gratex.perconik.astrcs.ientityservice.GetFilesByTfsIdentifiersResponse.class, value);
    }

}
