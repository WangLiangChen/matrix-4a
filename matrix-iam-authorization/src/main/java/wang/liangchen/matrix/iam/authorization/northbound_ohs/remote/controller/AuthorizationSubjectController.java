package wang.liangchen.matrix.iam.authorization.northbound_ohs.remote.controller;

import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationSubjectCommandService;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationSubjectQueryService;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-07-08 10:54
 */
@RestController("authorization/subject")
public class AuthorizationSubjectController {
    private final AuthorizationSubjectCommandService commandService;
    private final AuthorizationSubjectQueryService queryService;

    @Inject
    public AuthorizationSubjectController(AuthorizationSubjectCommandService commandService, AuthorizationSubjectQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }
}
