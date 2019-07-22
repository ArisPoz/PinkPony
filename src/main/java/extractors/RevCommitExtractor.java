package extractors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

/**
 * Extract the RevCommits from git
 *
 * @author pmitsou
 * @version 12/07/2019
 */
public class RevCommitExtractor {

    private final CommitDifferencesExtractor commitDifferencesExtractor;

    @Inject
    public RevCommitExtractor(final CommitDifferencesExtractor commitDifferencesExtractor) {
        this.commitDifferencesExtractor = commitDifferencesExtractor;
    }

    public List<RevCommit> extractWithOutFiles(final Git git) throws IOException, GitAPIException {
        final List<RevCommit> commitsList = new ArrayList<>();

        final Iterable<RevCommit> commits = git.log().all().call();
        commits.forEach(commitsList::add);

        return commitsList;
    }



}

