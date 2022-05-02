package guru.qa;

import org.junit.jupiter.api.Test;

public class AnnotatedWebStepsTest {
    public static final String REPOSITORY = "VOPdg/MyHomework_12_7";
    @Test
    public void annotatedStepsTest() {
        WebTest steps = new WebTest();
        steps.openMainPage();
        steps.searchRepo(REPOSITORY);
        steps.openRepoPage(REPOSITORY);
        steps.checkIssuesName("Issues");
    }}