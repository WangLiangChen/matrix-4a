package wang.liangchen.matrix.iam.authorization.northbound_ohs.remote.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectCommandRequest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectQueryRequest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectQueryResponse;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationSubjectCommandService;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationSubjectQueryService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

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

    @PostMapping("/add")
    public void add(@RequestBody AuthorizationSubjectCommandRequest commandRequest) {
        commandService.add(commandRequest);
    }

    @GetMapping("/delete")
    public void delete(@Param("subjectId") Long subjectId) {
        commandService.delete(subjectId);
    }

    @PostMapping("/update")
    public void update(@RequestBody AuthorizationSubjectCommandRequest commandRequest) {
        commandService.add(commandRequest);
    }

    @GetMapping("/detail")
    public void detail(@Param("subjectId") Long subjectId) {
        queryService.detail(subjectId);
    }

    @PostMapping("/pagination")
    public PaginationResult<AuthorizationSubjectQueryResponse> pagination(@RequestBody AuthorizationSubjectQueryRequest queryRequest) {
        return queryService.pagination(queryRequest);
    }

    @PostMapping("/queryByStates")
    public List<AuthorizationSubjectQueryResponse> queryByStates(@RequestBody Collection<String> states) {
        return queryService.queryByStates(states);
    }
}
